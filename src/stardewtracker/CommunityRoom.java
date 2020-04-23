package stardewtracker;

import java.util.ArrayList;

public class CommunityRoom {
	private ArrayList<Bundle> roomBundles;
	private String reward;
	
	public CommunityRoom() {
		
	}

	//Getter Functions
	public ArrayList<Bundle> getRoomBundles() {
		return roomBundles;
	}
	public String getReward() {
		return reward;
	}	

	//Setter Functions
	public void setRoomBundles(ArrayList<Bundle> roomBundles) {
		this.roomBundles = roomBundles;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}

}
