package model;

public class Subscriber extends Follower {
	String username;
	int maxchannels;
	int maxvideos;
	
	public Subscriber(String username, int maxchannels, int maxvideos) {
		super(username, maxchannels, "Subscriber");
		this.maxvideos = maxvideos;
	}

	public void watch(String videoname, int watchtime) {
		super.addtime(watchtime, videoname);
		
	}
	
	

}
