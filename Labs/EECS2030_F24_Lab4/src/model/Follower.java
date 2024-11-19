package model;

public class Follower {
	int maxchannels;
	String name;
	String type;
	String []followinglist;
	int followingcount;
	String [] recomendedvids; // maxvids to relese is the vids that can be possibly recoemnded max vids 
	int recvidcount = 0; 
	// all static as i nee them in diffrent objects of type follower 
	static String vidname = ""; // not accsessed in child class
	
	Channel [] channelarray; // for storing channels from these channels i will find who made video i watched
	int channelarrcount = 0;
	static Channel currchannel;
	

	public Follower(String name, int maxchannels, String type) {
		this.maxchannels = maxchannels;
		this.name = name;
		this.type = type;
		this.followinglist = new String[maxchannels];
		channelarray = new Channel[maxchannels];
	}
	public String toString(){
		
		
		String tempfollow = "";
		for(int i = 0; i<followingcount; i++) {
			tempfollow += followinglist[i];
			if(i<followingcount-1) {
				tempfollow += ", ";
			}
		}
		
		String tempfollowmon = "";
		for(int i = 0; i<followingcount; i++) {
			tempfollowmon += followinglist[i];
			if (currchannel != null && currchannel.channelname == followinglist[i]) {
				int watchtime = currchannel.watchtime;
				int maxwatchtime = currchannel.maxwatchtime;
				int viewcount = currchannel.viewcount;
				float avgtime = (float)watchtime / viewcount;
				currchannel.recipt = String.format(" {#views: %d, max watch time: %d, avg watch time: %.2f}", viewcount, maxwatchtime, avgtime );
			}
			if(currchannel != null) {
				tempfollowmon += channelarray[i].recipt;
			}
			if(i<followingcount-1) {
				tempfollowmon += ", ";
			}
		}
		
		
		
		String temprecomended = "";
		for(int i = 0; i<recvidcount; i++) {
			temprecomended += recomendedvids[i];
			if(i<recvidcount-1) {
				temprecomended += ", ";
			}
			
		}
		
		if (recvidcount == 0) {
			String forsub = (followingcount == 0) ?  "Subscriber "+name+" follows no channels and has no recommended videos.":  "Subscriber "+name+" follows ["+tempfollow+"] and has no recommended videos.";
			
			String formonitor = (followingcount == 0) ?  "Monitor "+name+" follows no channels.":  "Monitor "+name +" follows ["+tempfollowmon+"].";
			
			String retString = (type == "Subscriber") ? forsub:formonitor;
			return retString;
		}
		
		// if vids to recoment
		String forsub = (followingcount == 0) ?  "Subscriber "+name+" follows no channels and has no recommended videos.":  "Subscriber "+name+" follows ["+tempfollow+"] and is recommended <"+temprecomended+">.";
		
		String formonitor = (followingcount == 0) ?  "Monitor "+name+" follows no channels.":  "Monitor "+name +" follows ["+tempfollowmon+"].";
		
		String retString = (type == "Subscriber") ? forsub:formonitor;
		return retString;
		
		
		
	}
	public void addtime(int time, String videoname) {
		vidname = videoname;
		for(int i = 0; i<channelarrcount; i++) {
			Channel curr = channelarray[i];
			for(int j = 0; j<curr.videolist.length; j++) {
				if (curr.videolist[j] == null) {
					j = curr.videolist.length-1; // break the serch 
				}
				if (curr.videolist[j] == videoname) {
					currchannel = curr;
					if (time > curr.maxwatchtime) {
						curr.maxwatchtime = time;
					}
					curr.watchtime += time;
					curr.viewcount += 1;
					return;
				}
			}
		}
		
	}
	
}








