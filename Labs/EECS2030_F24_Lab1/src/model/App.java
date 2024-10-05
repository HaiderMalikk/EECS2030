package model;

public class App {
    String appName;
    int maxRatings;
    int numberofRatings;
    Log[] appfixes;
    int numofupdates;
    String ratings;
    int onestar = 0;
	int twostar = 0;
	int threestar = 0;
	int fourstar = 0;
	int fivestar = 0;
	double avgrating;

    public App(String appName, int maxRatings) {
        this.appName = appName;
        this.maxRatings = maxRatings;
        this.appfixes = new Log[20];  
        this.numofupdates = 0;
        this.ratings = "No ratings submitted so far!";
    }

    public String getName() {
        return appName;
    }

    public String getWhatIsNew() {
        if (numofupdates == 0) {
            return "n/a";  // No update
        }
        Log latestLog = appfixes[numofupdates - 1];  // Get the latest log
        return latestLog.toString();  
    }

    public Log[] getUpdateHistory() {
        Log[] history = new Log[numofupdates];
        for (int i = 0; i < numofupdates; i++) {
            history[i] = appfixes[i];  
        }
        return history;
    }

    public Log getVersionInfo(String version) {
        for (int i = 0; i < numofupdates; i++) {
            if (appfixes[i].getVersion().equals(version)) {
                return appfixes[i];  
            }
        }
        return null;  //
    }

    public String getRatingReport() {
    	double totalRating = (onestar + 2 * twostar + 3 * threestar + 4 * fourstar + 5 * fivestar);
    	avgrating = (totalRating/numberofRatings);
    	String ratingreport = String.format("Average of %d ratings: %.1f (Score 5: %d, Score 4: %d, Score 3: %d, Score 2: %d, Score 1: %d)",
                numberofRatings, avgrating, fivestar, fourstar, threestar, twostar, onestar);

    	String ratingRP = (numberofRatings == 0) ? "No ratings submitted so far!" : ratingreport;
    	return ratingRP;
    }

    public void releaseUpdate(String newVersion) {
        Log newLog = new Log(newVersion);  
        appfixes[numofupdates] = newLog;   
        numofupdates++;  
        
    }

    public String toString() {
    	String formattedavg = String.format("%.1f", avgrating);
        String averageRating = (numberofRatings == 0) ? "n/a" : formattedavg;

        return appName + " (Current Version: " + getWhatIsNew() + "; Average Rating: " + averageRating + ")";
        
    }

	public void submitRating(int r) {
		
		
		switch (r) {
	      case 1:
	    	  onestar++;
	    	  break;
	      case 2:
	    	  twostar++;
	    	  break;
	      case 3:
	    	  threestar++;
	    	  break;
	      case 4:
	    	  fourstar++;
	    	  break;
	      case 5:
	    	  fivestar++;
	    	  break;
		}
		numberofRatings++;
	     
	   
	
	    	  
	      
	}
		
		
		
}
    
    


