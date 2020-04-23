package stardewtracker;

import java.util.ArrayList;

public class CommunityCenter {
	private ArrayList<CommunityRoom> communityRooms;
	
	public CommunityCenter(SaveFile saveFileToLoad) {
		
	}
	
	//Getter Methods
	public ArrayList<CommunityRoom> communityRooms() {
		return communityRooms;
	}

	//Setter Methods
	public void communityRooms(ArrayList<CommunityRoom> communityRooms) {
		this.communityRooms = communityRooms;
	}

}
