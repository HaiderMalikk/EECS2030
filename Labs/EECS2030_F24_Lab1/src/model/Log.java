package model;

public class Log {

    private String Version;
    public String[] Fixes;
    private int numOfFixes;

    public Log(String Version) {
        this.Version = Version;
        this.Fixes = new String[10];  
        this.numOfFixes = 0;  
    }

    public String getVersion() {
        return Version;
    }

    public int getNumberOfFixes() {
        return numOfFixes;  
    }

    public String getFixes() {
        if (numOfFixes == 0) {
            return "[]";  
        }

        // whatever this is 
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numOfFixes; i++) {
            sb.append(Fixes[i]);
            if (i < numOfFixes - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String toString() {
        return "Version " + Version + " contains " + numOfFixes + " fixes " + getFixes();
    }

    public void addFix(String string) {
		Fixes[numOfFixes] = string;
		numOfFixes ++;
		
		
		
	}

}
