package stardewtracker;

import java.util.ArrayList;

public class Bundle {
	private ArrayList<Item> bundleItems;
	private int itemsRequired;
	private Item reward;
	private int quantityReward;
	
	public Bundle() {
		
	}

	//Getter Functions
	public ArrayList<Item> getBundleItems() {
		return bundleItems;
	}
	public int getItemsRequired() {
		return itemsRequired;
	}	
	public Item getReward() {
		return reward;
	}	
	public int getQuantityReward() {
		return quantityReward;
	}	

	//Setter Functions
	public void setBundleItems(ArrayList<Item> bundleItems) {
		this.bundleItems = bundleItems;
	}
	public void setItemsRequired(int itemsRequired) {
		this.itemsRequired = itemsRequired;
	}
	public void setReward(Item reward) {
		this.reward = reward;
	}
	public void setQuantityReward(int quantityReward) {
		this.quantityReward = quantityReward;
	}
	
}
