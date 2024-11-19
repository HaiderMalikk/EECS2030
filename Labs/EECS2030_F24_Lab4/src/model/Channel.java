package model;

public class Channel {
	String [] videolist;
	String [] followerlist;
	Follower [] followertypelist; // for storing follower objects
	String channelname;
	int maxfollowers;
	int maxvideos;
	int numofvids = 0;
	int numoffollowers;
	
	// view count and watch time for all videos
	int watchtime;
	int maxwatchtime;
	int viewcount;
	
	String recipt = "";

	public Channel(String channelname, int maxfollowers, int maxvideos) { 
		this.channelname = channelname;
		this.maxfollowers = maxfollowers;
		this.maxvideos = maxvideos;
		this.videolist = new String[maxvideos];
		this.followerlist = new String[maxfollowers];
		this.followertypelist = new Follower[maxfollowers];
	}

	public void releaseANewVideo(String videoname) {
		videolist[numofvids] = videoname;
		
		
		// add recoemened to all elements in followers list
		for(int i = 0; i<numoffollowers; i++) {
			followertypelist[i].recomendedvids[followertypelist[i].recvidcount] = videoname;
			followertypelist[i].recvidcount ++;
		}
		
		numofvids ++;
		
	}
	
	public String toString() {
		
		String tempvidlist =  "";
		
		if (numofvids == 0) {
			tempvidlist = "no videos";
		}
		else {
			tempvidlist = "<";
			for (int i = 0; i < numofvids; i++) {
				tempvidlist += videolist[i];
				if (i < numofvids-1) {
					tempvidlist += ", ";
				}
			}
			tempvidlist += ">";
		}
		
		String tempfollowlist = "";
		for(int i = 0; i<numoffollowers; i++) {
			tempfollowlist += followerlist[i];
			if (i<numoffollowers-1) {
				tempfollowlist += ", ";
			}
		}
		
		
		String numberoffollowers = (numoffollowers == 0) ? "has no followers.":"is followed by " + "["+tempfollowlist+"].";
		
		return channelname+" released "+tempvidlist+" and "+numberoffollowers;
		
	}

	public void follow(Follower follower) {
		followerlist[numoffollowers] = follower.type + " " +follower.name;
		followertypelist[numoffollowers] = follower;
		numoffollowers ++;
		
		follower.followinglist[follower.followingcount] = channelname;
		follower.followingcount ++;
		
		// when we add follower create its rec vid array
		follower.recomendedvids = new String[maxvideos];
		
		// add chnalle something
		follower.channelarray[follower.channelarrcount] = this;
		follower.channelarrcount ++;

	}

	public void unfollow(Follower follower) {
		boolean followerisreal = false; // can cehck if follower is in either classes array 
		for(int i = 0; i<numoffollowers; i++) {
			if(followerlist[i].equals(follower.type + " " +follower.name)) {
				followerisreal  = true;
			}
		}
		
		
		if(followerisreal) {
			// remove from both class's lists 
			// for channel store type = name
			String [] tempFL = new String[followerlist.length]; // list len dose not cahnge
			int tempidx = 0;
			for(int i = 0; i< numoffollowers; i++) {
				if(followerlist != null && followerlist[i].equals(follower.type + " " +follower.name)) { // here use equals not == also for equals check if at i its null you have too also specify it before becasue of short cuircuit
					continue;
				}
				tempFL[tempidx] = followerlist[i];
				tempidx ++;
			}
			followerlist = new String[followerlist.length]; // len remains  same as thats def in constructor 
			for(int i = 0; i<tempFL.length; i++) {
				followerlist[i] = tempFL[i];
			}
			
			// removing from follower type list 
			Follower [] tempFL1 = new Follower[followertypelist.length];
			int tempidx1 = 0;
			for(int i = 0; i<numoffollowers; i++) {
				if(followertypelist[i] != null && followertypelist[i].equals(follower)) {
					continue;
				}
				tempFL1[tempidx1] = followertypelist[i];
				tempidx1 ++;
			}
			followertypelist = new Follower[followertypelist.length];
			for(int i = 0; i<tempFL1.length;i++) {
				followertypelist[i] = tempFL1[i];
			}
			
			
			// for follower temp stores channel name same array size but use follwer's array for ref
			String[] tempFL2 = new String[follower.followinglist.length]; 
			int tempidx2 = 0;
			for(int i = 0; i<numoffollowers; i++) {
				if(follower.followinglist[i] != null && follower.followinglist[i].equals(channelname)) {
					continue;
				}
				tempFL2[tempidx2] = follower.followinglist[i]; 
				tempidx2 ++;
			}
			follower.followinglist = new String[follower.followinglist.length];
			for(int i = 0; i<tempFL2.length; i++) {
				follower.followinglist[i] = tempFL2[i];
			}
				
			// after removing both decrement numoffollowers in both classes
			numoffollowers --; 
			follower.followingcount --;
		}
	}

}


















