package model;

public class Account {
	String name;
	AppStore Store;
	String statusmsg;
	String[] downloadedapps = new String[0];
	int numofdownloadedapps = 0;
	App[] objectsarray = new App[0];
	

	public Account(String name, AppStore Store) {
		this.name = name;
		this.Store = Store;
		this.statusmsg = "An account linked to the "+Store.getBranch()+" store is created for "+name+".";
	}
	
	public String toString() {

		return statusmsg;
	}

	public String[] getNamesOfDownloadedApps() {
		
		return downloadedapps;
	}

	public App[] getObjectsOfDownloadedApps() {
		
		return objectsarray;
	}

	public void uninstall(String uninstalledappname) {
		for(int i = 0; i < getNamesOfDownloadedApps().length; i++) {
			if (getNamesOfDownloadedApps()[i] == uninstalledappname) {
				statusmsg = getNamesOfDownloadedApps()[i] + " is successfully uninstalled for "+name+".";
		
				
				// temp array to spill values of downloaded array as uninstalled app will be skipped
				String[] temparray = new String[getNamesOfDownloadedApps().length-1];
				int tempidx = 1;
				// deleting null app from array
				for(int j = 0;j<getNamesOfDownloadedApps().length; j++) {
					if(getNamesOfDownloadedApps()[j] != uninstalledappname) {
						temparray[tempidx] = getNamesOfDownloadedApps()[j];
						tempidx++; // only incement temp index if we add to it as its different from get names index
					}

				}
				
				
				// now temp array is new array with uninstalled app gone so we just copy to class array
				downloadedapps = new String[temparray.length];
				for(int k = 0;k<downloadedapps.length;k++) {
					downloadedapps[k] = temparray[k];
				}
				
				// now i have new downloaded apps array so i will copy the objs stright to new obj array
				objectsarray = new App[downloadedapps.length];
				for(int l = 0; l<downloadedapps.length; l++) {
					objectsarray[l] = Store.getApp(downloadedapps[l]);
				}
				
				return;
			}
		}
		
		
		statusmsg = "Error: "+uninstalledappname+" has not been downloaded for "+name+".";
	}

	public void submitRating(String ratingappname, int rating) {
		for(int i = 0; i < getNamesOfDownloadedApps().length; i++) {
			if (getNamesOfDownloadedApps()[i] == ratingappname) {
				statusmsg = "Rating score "+rating+" of "+name+" is successfully submitted for "+ratingappname+".";
				Store.appsArray[i].submitRating(rating);
				return;
			}
		}
		statusmsg = "Error: "+ratingappname+" is not a downloaded app for "+name+".";
	}

	public void switchStore(AppStore newappStore) { 
		Store = newappStore;
		statusmsg = "Account for "+name+" is now linked to the "+Store.getBranch()+" store.";
		
		
	}

	public void download(String downloadappname) {
		if (numofdownloadedapps == 50) {
			return;
		}
		
		/// check of app existing
		for(int i = 0; i<numofdownloadedapps;i++) {
			if(downloadedapps[i] == downloadappname) {
				statusmsg = "Error: "+downloadappname+" has already been downloaded for "+name+".";
				return;
			}
		}	
		
		// download apps names list
		String[] localarr = new String[numofdownloadedapps + 1];
		
		for(int i = 0; i < numofdownloadedapps; i++) {
			localarr[i] = downloadedapps[i];
		}
		
		localarr[localarr.length-1] = downloadappname;
		
		downloadedapps = new String[localarr.length];
		
		for(int i = 0; i < localarr.length;i++) {
			downloadedapps[i] = localarr[i];
		}
		
		// i alredy have a complete updated array with app names so for each name i will get object and put in new array
		objectsarray = new App[downloadedapps.length];
		for(int i = 0; i<downloadedapps.length; i++) {
			objectsarray[i] = Store.getApp(downloadedapps[i]);
		}
		
		// incement counter for next call
		numofdownloadedapps++;
		// message if all runs
		statusmsg = downloadappname+" is successfully downloaded for "+name+".";
		
		
	}

}
