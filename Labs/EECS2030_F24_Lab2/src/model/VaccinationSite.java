// VaccinationSite.java
package model;

public class VaccinationSite {
    private String name;
    private int doseLimit;
    private int totalDoses;
    private int tempDoses;
    private VaccineDistribution[] distributions;
    private int distributionCount;

    public VaccinationSite(String name, int doseLimit) {
        this.name = name;
        this.doseLimit = doseLimit;
        this.totalDoses = 0;
        this.distributions = new VaccineDistribution[doseLimit];
        this.distributionCount = 0;
    }

    public int getNumberOfAvailableDoses() {
        return totalDoses;
    }

    public int getNumberOfAvailableDoses(String codename) {
        int doses = 0;
        for (int i = 0; i < distributionCount; i++) {
            if (distributions[i].vaccine.codename.equals(codename)) {
                doses += distributions[i].doses;
            }
        }
        return doses;
    }

    public void addDistribution(Vaccine vaccine, int doses) throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException {
        if (!vaccine.isRecognized()) {
            throw new UnrecognizedVaccineCodeNameException("Vaccine codename not recognized.");
        }

        if (totalDoses + doses > doseLimit) {
            throw new TooMuchDistributionException("Total doses exceed the site's limit.");
        }

        boolean added = false;
        for (int i = 0; i < distributionCount; i++) {
            if (distributions[i].vaccine.codename.equals(vaccine.codename)) {
                distributions[i].doses += doses;
                added = true;
                break;
            }
        }
        if (!added) {
            distributions[distributionCount++] = new VaccineDistribution(vaccine, doses);
        }

        totalDoses += doses;
        tempDoses += doses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" has ").append(totalDoses).append(" available doses: <");
        for (int i = 0; i < distributionCount; i++) {
            if (i > 0) sb.append(", ");
            sb.append(distributions[i].doses).append(" doses of ").append(distributions[i].vaccine.manufacturer);
        }
        sb.append(">");
        return sb.toString();
    }

    public void bookAppointment(HealthRecord healthRecord) throws InsufficientVaccineDosesException {
        if (tempDoses == 0) {
            healthRecord.addApp("Last vaccination appointment for " + healthRecord.name + " with " + name + " failed");
            throw new InsufficientVaccineDosesException("Out of vaccine doses.");
        }

        healthRecord.addApp("Last vaccination appointment for " + healthRecord.name + " with " + name + " succeeded");
        tempDoses--;
    }

    public void administer(String date) {
        for (int i = 0; i < distributionCount && tempDoses > 0; i++) {
            if (distributions[i].doses > 0) {
                tempDoses--;
                distributions[i].doses--;
            }
        }
    }
}
