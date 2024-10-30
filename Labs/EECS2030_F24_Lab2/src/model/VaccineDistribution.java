// VaccineDistribution.java
package model;

public class VaccineDistribution {
    Vaccine vaccine;
    int doses;

    public VaccineDistribution(Vaccine vaccine, int doses) {
        this.vaccine = vaccine;
        this.doses = doses;
    }

    @Override
    public String toString() {
        return doses + " doses of " + vaccine.codename + " by " + vaccine.manufacturer;
    }
}
