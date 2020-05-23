package stardewtracker;

import java.util.ArrayList;

public class Item {	
	private ArrayList<Seasons> seasonsAcquirable;
	private ArrayList<Weather> weatherAcquirable;
	private ArrayList<StardewLocation> placesAcquirable;	
	private Quality qualityRequired;
	private int skillLevelRequired;
	private Skill skillUsed;
	private boolean[] hoursAcquirable;
	private String extraInfo;
	private boolean itemAcquired;
	private String name;
	private int quantityRequired;
	
	public Item(ArrayList<Seasons> seasonsAcquirable, ArrayList<Weather> weatherAcquirable, ArrayList<StardewLocation> placesAcquirable, 
			Quality qualityRequired, int skillLevelRequired, Skill skillUsed, boolean[] hoursAcquirable, String extraInfo, String name, boolean itemAcquired, int quantityRequired) {
		
		this.seasonsAcquirable = seasonsAcquirable;
		this.weatherAcquirable = weatherAcquirable;
		this.placesAcquirable = placesAcquirable;
		this.qualityRequired = qualityRequired;
		this.skillLevelRequired = skillLevelRequired;
		this.skillUsed = skillUsed;
		this.hoursAcquirable = hoursAcquirable;
		this.extraInfo = extraInfo;
		this.name = name;
		this.itemAcquired = itemAcquired;
		this.setQuantityRequired(quantityRequired);
	}

	//Getter Methods
	public ArrayList<Seasons> getSeasonsAcquirable() {
		return seasonsAcquirable;
	}
	public ArrayList<Weather> getWeatherAcquirable() {
		return weatherAcquirable;
	}
	public String getExtraInfo() {
		return extraInfo;
	}
	public int getSkillLevel() {
		return skillLevelRequired;
	}
	public Skill getSkillUsed() {
		return skillUsed;
	}	
	public boolean[] getHoursAcquirable() {
		return hoursAcquirable;
	}	
	public ArrayList<StardewLocation> getPlacesAcquirable() {
		return placesAcquirable;
	}		
	public boolean getItemAcquired() {
		return itemAcquired;
	}	
	public Quality getQualityRequired() {
		return qualityRequired;
	}	
	public String getName() {
		return name;
	}	
	public int getQuantityRequired() {
		return quantityRequired;
	}	
	
	//Setter Methods
	public void setSeasonsAcquirable(ArrayList<Seasons> seasonsAcquirable) {
		this.seasonsAcquirable = seasonsAcquirable;
	}
	public void setWeatherAcquirable(ArrayList<Weather> weatherAcquirable) {
		this.weatherAcquirable = weatherAcquirable;
	}
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	public void setSkillLevel(int skillLevelRequired) {
		this.skillLevelRequired = skillLevelRequired;
	}
	public void setSkillUsed(Skill skillUsed) {
		this.skillUsed = skillUsed;
	}
	public void setHoursAcquirable(boolean hoursAcquirable[]) {
		this.hoursAcquirable = hoursAcquirable;
	}
	public void setPlacesAcquirable(ArrayList<StardewLocation> placesAcquirable) {
		this.placesAcquirable = placesAcquirable;
	}
	public void setItemAcquired(boolean itemAcquired) {
		this.itemAcquired = itemAcquired;
	}		
	public void setQualityRequired(Quality qualityRequired) {
		this.qualityRequired = qualityRequired;
	}	
	public void setName(String name) {
		this.name = name;
	}	
	public void setQuantityRequired(int quantityRequired) {
		this.quantityRequired = quantityRequired;
	}	

	//This is a special getter method, we might want to convert this into a separate object for the time ranges later
	public String getHoursAcquirableToString() {
		int hourStreakStart = 0;
		int hourStreakEnd = 0;
		boolean inAStreak = false;
		boolean firstStreak = true;
		String acquirableTimeString = "";

		for (int i=0; i < 20; i++) {
			//if the hour is Acquirable, and we are not in a streak, it has started, update values
			if (hoursAcquirable[i]) {
				if (!inAStreak) {
					hourStreakStart = i;
					inAStreak = true;
				}
			} else {
			//if the hour is not Acquirable, and we are in a streak, it has ended, update values
				if (inAStreak) {
					hourStreakEnd = i;
					inAStreak = false;
					acquirableTimeString += streakToString(hourStreakStart, hourStreakEnd, firstStreak);
					firstStreak = false;
				}				
			}			
		}
		//if we reached the end and we are in a streak, it has ended, update values
		if (inAStreak) {
			hourStreakEnd = 19;
			acquirableTimeString += streakToString(hourStreakStart, hourStreakEnd, firstStreak);
		}	
		//if the streak is for the full day, for readability, we shorten it to 'Any'
		if (acquirableTimeString.equals("6am-2am")) {
			return "Any";
		}
		return acquirableTimeString;
		
	}
	//Helper Functions
	private String streakToString(int start, int end, boolean firstStreak) {
		String startString = numberToString(start);
		String endString = numberToString(end);
		if (!firstStreak) { return ", " + startString + "-" + endString; }
		return startString + "-" + endString;
	}
	private String numberToString(int toConvert) {
		//comment to remind myself of hours -> indices, keeping in mind that 0 is technically 6am-7am, therefore 20 does not exist as it is 2am-3am
		// 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20
		// 6  7  8  9 10 11 12  1  2  3 4  5  6  7  8  9  10 11 12 1  2
		int hourNum = (toConvert + 6) % 13 + (toConvert / 13);
		int isPM = toConvert + 6 / 12;
		String convertedNum = Integer.toString(hourNum);
		if (isPM == 1) {
			return convertedNum + "pm";
		}
		return convertedNum + "am";
	}
}
