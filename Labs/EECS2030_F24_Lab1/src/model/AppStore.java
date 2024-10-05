package model;

public class AppStore {
	String country;
	int maxApps;
	String App;
	App[] appsArray;
	int numofapps = 0;

	
	public AppStore(String country, int maxApps) {
		this.country = country;
		this.maxApps = maxApps;
		appsArray = new App[maxApps];
	}
	
	public String getBranch() {
		return country;
	}

	public App getApp(String appname) {
		for(int i = 0; i < numofapps; i++) {
			String currapp = appsArray[i].getName();
			if (currapp == appname) {
				return appsArray[i];
			}
		}
		return null;
	}
	
	public void addApp(App app) {
		appsArray[numofapps] = app;
		numofapps ++;
		
	}

	public String[] getStableApps(int minupdates) {
	    // count how many apps meet the stability requirement so we can size our stable apps array
	    int count = 0;
	    for (int i = 0; i < numofapps; i++) {
	        if (appsArray[i].getUpdateHistory().length >= minupdates) {
	            count++;
	        }
	    }

	    // Create an array to hold the stable apps witch len of count 
	    String[] stableApps = new String[count];
	    int index = 0; // To track the current position in stableApps array note that num of apps is not alwasys the same size as stable apps arr.
	    // so we only increment index when we add to stable apps so we can keep track of index in stable apps
	    //the i is there to go through all the apps in apps array  

	    // Loop again and add the stableApps to our stable apps array.
	    for (int i = 0; i < numofapps; i++) {
	        App app = appsArray[i];
	        int updates = app.getUpdateHistory().length;
	        if (updates >= minupdates) {
	        	// NOTE: we dont just need fix we need the Tostring from log so we must make a log obj and assign in to updateHistories
	            Log latestLog = app.getUpdateHistory()[updates - 1]; // the fix for the lastest version ie last index in updateH
	            stableApps[index] = String.format("%s (%d versions; Current Version: %s)", app.getName(), updates, latestLog.toString());
	            index++;
	        }
	    }
	    
	    return stableApps;
	}

	
	

}
