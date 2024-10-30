// Vaccine.java
package model;

public class Vaccine {
    String codename;
    String type;
    String manufacturer;
    private static final String[] APPROVED_CODES = {"mRNA-1273", "BNT162b2", "Ad26.COV2.S", "AZD1222"};

    public Vaccine(String codename, String type, String manufacturer) {
        this.codename = codename;
        this.type = type;
        this.manufacturer = manufacturer;
    }

    public boolean isRecognized() {
        for (String code : APPROVED_CODES) {
            if (codename.equals(code)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String status = isRecognized() ? "Recognized" : "Unrecognized";
        return status + " vaccine: " + codename + " (" + type + "; " + manufacturer + ")";
    }
}
