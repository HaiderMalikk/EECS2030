// HealthRecord.java
package model;

public class HealthRecord {
    String name;
    int numofdoses;
    int maxdoses;
    String[] records;
    String appstatus = "";

    public HealthRecord(String name, int maxdoses) {
        this.name = name;
        this.maxdoses = maxdoses;
        this.numofdoses = 0;
        this.records = new String[maxdoses];
    }

    public String getVaccinationReceipt() {
        if (numofdoses == 0) {
            return name + " has not yet received any doses.";
        }
        StringBuilder receiptStr = new StringBuilder();
        receiptStr.append("Number of doses ").append(name).append(" has received: ").append(numofdoses).append(" [");
        for (int i = 0; i < numofdoses; i++) {
            receiptStr.append(records[i]);
            if (i < numofdoses - 1) {
                receiptStr.append("; ");
            }
        }
        receiptStr.append("]");
        return receiptStr.toString();
    }

    public String getAppointmentStatus() {
        return appstatus.isEmpty() ? "No vaccination appointment for " + name + " yet" : appstatus;
    }

    public void addApp(String msg) {
        appstatus = msg;
    }

    public void addRecord(Vaccine vaccine, String location, String date) {
        String recordStr = vaccine.toString() + " in " + location + " on " + date;
        records[numofdoses++] = recordStr;
    }
}
