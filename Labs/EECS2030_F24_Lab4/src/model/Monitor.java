package model;

public class Monitor extends Follower {

	String monitorname;
	int maxchannels;
	public Monitor(String monitorname, int maxchannels) {
		super(monitorname, maxchannels, "Monitor");
	}
	

}
