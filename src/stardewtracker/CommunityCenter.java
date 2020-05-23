package stardewtracker;

import java.util.ArrayList;

public class CommunityCenter {
	private ArrayList<CommunityRoom> communityRooms;
	
	public CommunityCenter(ArrayList<CommunityRoom> communityRooms) {
		this.communityRooms = communityRooms;
	}
	
	//Getter Methods
	public ArrayList<CommunityRoom> getCommunityRooms() {
		return communityRooms;
	}

	//Setter Methods
	public void setCommunityRooms(ArrayList<CommunityRoom> communityRooms) {
		this.communityRooms = communityRooms;
	}

}
