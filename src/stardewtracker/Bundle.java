package stardewtracker;

import java.util.ArrayList;

public class Bundle {
	private ArrayList<Item> bundleItems;
	private int itemsRequired;
	private String reward;
	
	public Bundle(ArrayList<Item> bundleItems, int itemsRequired, String reward) {
		this.bundleItems = bundleItems;
		this.itemsRequired = itemsRequired;
		this.reward = reward;
	}

	//Getter Functions
	public ArrayList<Item> getBundleItems() {
		return bundleItems;
	}
	public int getItemsRequired() {
		return itemsRequired;
	}	
	public String getReward() {
		return reward;
	}	

	//Setter Functions
	public void setBundleItems(ArrayList<Item> bundleItems) {
		this.bundleItems = bundleItems;
	}
	public void setItemsRequired(int itemsRequired) {
		this.itemsRequired = itemsRequired;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	
}
