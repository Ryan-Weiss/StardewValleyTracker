package stardewtracker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class SaveFile {
	private String SaveFileName;
	private String SavePath;
	private CommunityCenter communityCenter;
	private Properties saveData;
	
	public SaveFile(String SaveFileName, String SavePath) {
		this.SaveFileName = SaveFileName;
		this.SavePath = SavePath;
		this.saveData = initializeSaveData();
		this.communityCenter = initializeObjects();
	}

	//Getter Function
	public String getName() {
		return this.SaveFileName;
	}
	public CommunityCenter getCommunityCenter() {
		return communityCenter;
	}
	public Properties getSaveData() {
		return saveData;
	}	
	
	//Private Getter Function for retrieving specific mapping value
	private boolean isItemAcquired(String itemName) {
		return propConvert(saveData.getProperty(itemName));
	}
	
	//Setter Function
	public String getPath() {
		return this.SavePath;
	}
	public void setCommunityCenter(CommunityCenter communityCenter) {
		this.communityCenter = communityCenter;
	}
	public void setSaveData(Properties saveData) {
		this.saveData = saveData;
	}	

	//Helper Functions
	
	//Function to convert a property string into the Boolean representation
	private boolean propConvert(String property) {
		if (property.equals("0")) {
			return false;
		} else if (property.equals("1")) {
			return true;
		} 
		return false;
	}
	
	//Initializes the properties file that represents the users saved data
	private Properties initializeSaveData() {
		try(InputStream InStream = new FileInputStream(this.SavePath)) {
			Properties save = new Properties();
			save.load(InStream);
			InStream.close();
			return save;
		} catch (IOException io) {
            io.printStackTrace();
        }	 
		return null;
	}		
	
	//This function returns the community center object that represents this save files data
	private CommunityCenter initializeObjects() {
		//Seasons Frequent Use Objects to save time
		ArrayList<Seasons> springOnly = new ArrayList<Seasons>();
		springOnly.add(Seasons.SPRING);
		ArrayList<Seasons> summerOnly = new ArrayList<Seasons>();
		summerOnly.add(Seasons.SUMMER);
		ArrayList<Seasons> fallOnly = new ArrayList<Seasons>();
		fallOnly.add(Seasons.FALL);
		ArrayList<Seasons> winterOnly = new ArrayList<Seasons>();
		winterOnly.add(Seasons.WINTER);
		ArrayList<Seasons> allYear = new ArrayList<Seasons>();
		allYear.add(Seasons.SPRING);		
		allYear.add(Seasons.SUMMER);
		allYear.add(Seasons.FALL);
		allYear.add(Seasons.WINTER);
		ArrayList<Seasons> springFall = new ArrayList<Seasons>();
		springFall.add(Seasons.SPRING);		
		springFall.add(Seasons.FALL);
		ArrayList<Seasons> springSummer = new ArrayList<Seasons>();
		springSummer.add(Seasons.SPRING);		
		springSummer.add(Seasons.SUMMER);
		ArrayList<Seasons> summerFall = new ArrayList<Seasons>();
		summerFall.add(Seasons.SUMMER);		
		summerFall.add(Seasons.FALL);	
		ArrayList<Seasons> springSummerFall = new ArrayList<Seasons>();
		springSummerFall.add(Seasons.SPRING);		
		springSummerFall.add(Seasons.SUMMER);
		springSummerFall.add(Seasons.FALL);		
		ArrayList<Seasons> fallWinter = new ArrayList<Seasons>();	
		fallWinter.add(Seasons.FALL);	
		fallWinter.add(Seasons.WINTER);	
		ArrayList<Seasons> summerWinter = new ArrayList<Seasons>();	
		summerWinter.add(Seasons.SUMMER);	
		summerWinter.add(Seasons.WINTER);			
		
		//Weather Frequent Use Objects to save time
		ArrayList<Weather> sunnyWeather = new ArrayList<Weather>();
		sunnyWeather.add(Weather.SUNNY);
		ArrayList<Weather> rainyWeather = new ArrayList<Weather>();
		rainyWeather.add(Weather.RAINY);
		ArrayList<Weather> allWeather = new ArrayList<Weather>();
		allWeather.add(Weather.SUNNY);
		allWeather.add(Weather.RAINY);
		allWeather.add(Weather.WINDY);
		ArrayList<Weather> sunnyWindy = new ArrayList<Weather>();
		sunnyWindy.add(Weather.SUNNY);
		sunnyWindy.add(Weather.WINDY);		
		
		//Locations Frequent Use Objects to save time
		ArrayList<StardewLocation> farm = new ArrayList<StardewLocation>();
		farm.add(StardewLocation.PLAYERFARM);

		ArrayList<StardewLocation> foragingLocations = new ArrayList<StardewLocation>();
		foragingLocations.add(StardewLocation.ALLABOVEGROUND);	
		ArrayList<StardewLocation> artifactSpots = new ArrayList<StardewLocation>();
		artifactSpots.add(StardewLocation.ARTIFACTSPOTS);	
		
		ArrayList<StardewLocation> mine = new ArrayList<StardewLocation>();
		mine.add(StardewLocation.MINE);				
		ArrayList<StardewLocation> desert = new ArrayList<StardewLocation>();
		desert.add(StardewLocation.DESERT);		
		ArrayList<StardewLocation> townriver = new ArrayList<StardewLocation>();
		townriver.add(StardewLocation.TOWNRIVER);
		ArrayList<StardewLocation> ocean = new ArrayList<StardewLocation>();
		ocean.add(StardewLocation.OCEAN);
		ArrayList<StardewLocation> mountainlake = new ArrayList<StardewLocation>();
		mountainlake.add(StardewLocation.MOUNTAINLAKE);
		ArrayList<StardewLocation> anyRiver = new ArrayList<StardewLocation>();
		anyRiver.add(StardewLocation.TOWNRIVER);
		anyRiver.add(StardewLocation.CINDERSAPRIVER);
		ArrayList<StardewLocation> anyRiverSecret = new ArrayList<StardewLocation>();
		anyRiverSecret.add(StardewLocation.TOWNRIVER);
		anyRiverSecret.add(StardewLocation.CINDERSAPRIVER);	
		anyRiverSecret.add(StardewLocation.SECRETWOODS);
		ArrayList<StardewLocation> freshwater = new ArrayList<StardewLocation>();
		freshwater.add(StardewLocation.TOWNRIVER);
		freshwater.add(StardewLocation.CINDERSAPRIVER);	
		freshwater.add(StardewLocation.MOUNTAINLAKE);
		freshwater.add(StardewLocation.PLAYERFARM);
		ArrayList<StardewLocation> oceanBeach = new ArrayList<StardewLocation>();
		oceanBeach.add(StardewLocation.OCEAN);
		oceanBeach.add(StardewLocation.BEACH);	
		ArrayList<StardewLocation> beach = new ArrayList<StardewLocation>();
		beach.add(StardewLocation.BEACH);	
		ArrayList<StardewLocation> lakeRivers = new ArrayList<StardewLocation>();
		lakeRivers.add(StardewLocation.TOWNRIVER);
		lakeRivers.add(StardewLocation.CINDERSAPRIVER);	
		lakeRivers.add(StardewLocation.MOUNTAINLAKE);	
		
		//specific item locations
		ArrayList<StardewLocation> winterRootLocations = new ArrayList<StardewLocation>();
		winterRootLocations.add(StardewLocation.ARTIFACTSPOTS);
		winterRootLocations.add(StardewLocation.MINE);
		ArrayList<StardewLocation> crystalFruitLocations = new ArrayList<StardewLocation>();
		winterRootLocations.add(StardewLocation.ALLABOVEGROUND);
		winterRootLocations.add(StardewLocation.MINE);		
		ArrayList<StardewLocation> commonMushroomLocations = new ArrayList<StardewLocation>();
		winterRootLocations.add(StardewLocation.ALLABOVEGROUND);
		winterRootLocations.add(StardewLocation.SECRETWOODS);	
		ArrayList<StardewLocation> secretWoods = new ArrayList<StardewLocation>();
		secretWoods.add(StardewLocation.SECRETWOODS);	
		ArrayList<StardewLocation> carpLocations = new ArrayList<StardewLocation>();
		carpLocations.add(StardewLocation.SECRETWOODS);			
		carpLocations.add(StardewLocation.MOUNTAINLAKE);	
		carpLocations.add(StardewLocation.SEWER);	
		carpLocations.add(StardewLocation.MUTANTBUGLAIR);		
		carpLocations.add(StardewLocation.CINDERSAPPOND);
		ArrayList<StardewLocation> riversLakes = new ArrayList<StardewLocation>();
		riversLakes.add(StardewLocation.CINDERSAPPOND);			
		riversLakes.add(StardewLocation.MOUNTAINLAKE);	
		riversLakes.add(StardewLocation.CINDERSAPRIVER);	
		riversLakes.add(StardewLocation.TOWNRIVER);		
		ArrayList<StardewLocation> witchesSwamp = new ArrayList<StardewLocation>();
		witchesSwamp.add(StardewLocation.WITCHSSWAMP);				
		
		//Hours Frequent Use Objects to save time
		boolean[] allDay = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
		//6am-7pm
		boolean[] daytime = {true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false};
		//6am-8pm
		boolean[] extendedDaytime = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false};
		//6pm-2am
		boolean[] nighttime = {false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true};
		//12pm-2am
		boolean[] walleye = {false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true};	
		//9am-2am
		boolean[] shad = {false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};		
		//12pm-4pm
		boolean[] pufferfish = {false, false, false, false, false, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false};	
		//4pm-2am
		boolean[] eel = {false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true};	
		//6am-12am
		boolean[] catfish = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};		
		//6am-2pm
		boolean[] tilapia = {true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false};				
			
		/********************* Item Initialization ******************************/
		
		//Spring Forage
		Item WildHorseradish = new Item(springOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Wild Horseradish", isItemAcquired("Wild Horseradish"), 1);
		Item Leek = new Item(springOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Leek", isItemAcquired("Leek"), 1);		
		Item Daffodil = new Item(springOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Buyable from Pierre at Flower Dance 50g", "Daffodil", isItemAcquired("Daffodil"), 1);
		Item Dandelion = new Item(springOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Buyable from Pierre at Flower Dance 50g", "Dandelion", isItemAcquired("Dandelion"), 1);
		
		ArrayList<Item> springForageItems = new ArrayList<Item>();
		springForageItems.add(WildHorseradish);
		springForageItems.add(Leek);
		springForageItems.add(Daffodil);
		springForageItems.add(Dandelion);
		
		//Summer Forage
		Item Grape = new Item(summerFall, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Summer Forage, Farmable Fall", "Grape", isItemAcquired("Grape"), 1);		
		Item SpiceBerry = new Item(summerOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Farm Cave (Bat)", "Spice Berry", isItemAcquired("Spice Berry"), 1);
		Item SweetPea = new Item(summerOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Sweet Pea", isItemAcquired("Sweet Pea"), 1);	
		
		ArrayList<Item> summerForageItems = new ArrayList<Item>();
		summerForageItems.add(Grape);
		summerForageItems.add(SpiceBerry);
		summerForageItems.add(SweetPea);		
		
		//Fall Forage
		Item CommonMushroom = new Item(springFall, allWeather, commonMushroomLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Forage Fall, Secret Woods (Spring + Fall), Farm Cave (Mushroom), Tapping Mushroom Tree", "Common Mushroom", isItemAcquired("Common Mushroom"), 1);
		Item WildPlum = new Item(fallOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Farm Cave (Bat)", "Wild Plum", isItemAcquired("Wild Plum"), 1);		
		Item Hazelnut = new Item(fallOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Hazelnut", isItemAcquired("Hazelnut"), 1);
		Item Blackberry = new Item(fallOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Farm Cave (Bat)", "Blackberry", isItemAcquired("Blackberry"), 1);		
		
		ArrayList<Item> fallForageItems = new ArrayList<Item>();
		fallForageItems.add(CommonMushroom);
		fallForageItems.add(WildPlum);
		fallForageItems.add(Hazelnut);
		fallForageItems.add(Blackberry);		
		
		//Winter Forage
		Item WinterRoot = new Item(allYear, allWeather, winterRootLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Winter: Artifact spots and tilling soil, Mine: Blue Slimes (41-79)", "Winter Root", isItemAcquired("Winter Root"), 1);
		Item CrystalFruit = new Item(allYear, allWeather, crystalFruitLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Winter: Foraging, Mine: Dust Sprites (41-79)", "Crystal Fruit", isItemAcquired("Crystal Fruit"), 1);		
		Item SnowYam = new Item(winterOnly, allWeather, artifactSpots, Quality.ANY, 0, Skill.FORAGING, allDay, "Artifact spots and tilling soil", "Snow Yam", isItemAcquired("Snow Yam"), 1);
		Item Crocus = new Item(winterOnly, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Crocus", isItemAcquired("Crocus"), 1);		
		
		ArrayList<Item> winterForageItems = new ArrayList<Item>();
		winterForageItems.add(WinterRoot);
		winterForageItems.add(CrystalFruit);
		winterForageItems.add(SnowYam);
		winterForageItems.add(Crocus);		
		
		//Construction	
		Item Wood = new Item(allYear, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Wood", isItemAcquired("Wood"), 99);	
		Item Wood2 = new Item(allYear, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Wood2", isItemAcquired("Wood2"), 99);	
		Item Stone = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "", "Stone", isItemAcquired("Stone"), 99);	
		Item Hardwood = new Item(allYear, allWeather, foragingLocations, Quality.ANY, 0, Skill.FORAGING, allDay, "Stumps: Copper (2 HW), Logs: Iron (8 HW)", "Hardwood", isItemAcquired("Hardwood"), 10);	
		
		ArrayList<Item> constructionItems = new ArrayList<Item>();
		constructionItems.add(Wood);
		constructionItems.add(Wood2);
		constructionItems.add(Stone);
		constructionItems.add(Hardwood);		
		
		//Exotic Forage
		Item Coconut = new Item(allYear, allWeather, desert, Quality.ANY, 0, Skill.FORAGING, allDay, "Desert", "Coconut", isItemAcquired("Coconut"), 1);	
		Item CactusFruit = new Item(allYear, allWeather, desert, Quality.ANY, 0, Skill.FORAGING, allDay, "Desert", "Cactus Fruit", isItemAcquired("Cactus Fruit"), 1);	
		Item CaveCarrot = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.FORAGING, allDay, "From Boxes or Tilling Cave Soil", "Cave Carrot", isItemAcquired("Cave Carrot"), 1);	
		Item RedMushroom = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.FORAGING, allDay, "Secret Woods in Summer&Fall, Farm Cave all year", "Red Mushroom", isItemAcquired("RedMushroom"), 1);	
		Item PurpleMushroom = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.FORAGING, allDay, "Mine: 81+, Skull Cave, Farm Cave", "Purple Mushroom", isItemAcquired("PurpleMushroom"), 1);	
		Item MapleSyrup = new Item(allYear, allWeather, foragingLocations, Quality.ANY, 3, Skill.FORAGING, allDay, "Tapped Maple Tree - 9 days", "Maple Syrup", isItemAcquired("MapleSyrup"), 1);	
		Item OakResin = new Item(allYear, allWeather, foragingLocations, Quality.ANY, 3, Skill.FORAGING, allDay, "Tapped Oak Tree - 8 days", "Oak Resin", isItemAcquired("OakResin"), 1);	
		Item PineTar = new Item(allYear, allWeather, foragingLocations, Quality.ANY, 3, Skill.FORAGING, allDay, "Tapped Pine Tree - 6 days", "Pine Tar", isItemAcquired("PineTar"), 1);	
		Item Morel = new Item(springOnly, allWeather, secretWoods, Quality.ANY, 0, Skill.FORAGING, allDay, "Farm Cave", "Morel", isItemAcquired("Morel"), 1);			
		
		ArrayList<Item> exoticItems = new ArrayList<Item>();
		exoticItems.add(Coconut);
		exoticItems.add(CactusFruit);
		exoticItems.add(CaveCarrot);
		exoticItems.add(RedMushroom);
		exoticItems.add(PurpleMushroom);
		exoticItems.add(MapleSyrup);
		exoticItems.add(OakResin);
		exoticItems.add(PineTar);
		exoticItems.add(Morel);		
		
		//Spring Crops
		Item Parsnip = new Item(springOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "4 days", "Parsnip", isItemAcquired("Parsnip"), 1);	
		Item GreenBean = new Item(springOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "10 days", "Green Bean", isItemAcquired("GreenBean"), 1);
		Item Cauliflower = new Item(springOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "12 days", "Cauliflower", isItemAcquired("Cauliflower"), 1);
		Item Potato = new Item(springOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "6 days", "Potato", isItemAcquired("Potato"), 1);
		
		ArrayList<Item> springCropItems = new ArrayList<Item>();
		springCropItems.add(Parsnip);
		springCropItems.add(GreenBean);
		springCropItems.add(Cauliflower);
		springCropItems.add(Potato);	
		
		//Summer Crops
		Item Tomato = new Item(summerOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "11 days, then every 4", "Tomato", isItemAcquired("Tomato"), 1);
		Item HotPepper = new Item(summerOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "5 days, then every 3", "Hot Pepper", isItemAcquired("HotPepper"), 1);
		Item Blueberry = new Item(summerOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "13 days, then every 4 (Yield of 3)", "Blueberry", isItemAcquired("Blueberry"), 1);
		Item Melon = new Item(summerOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "12 days", "Melon", isItemAcquired("Melon"), 1);
		
		ArrayList<Item> summerCropItems = new ArrayList<Item>();
		summerCropItems.add(Tomato);
		summerCropItems.add(HotPepper);
		summerCropItems.add(Blueberry);
		summerCropItems.add(Melon);			
		
		//Fall Crops
		Item Corn = new Item(summerFall, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "14 days, then every 4", "Corn", isItemAcquired("Corn"), 1);
		Item Eggplant = new Item(fallOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "5 days, then every 5", "Eggplant", isItemAcquired("Eggplant"), 1);
		Item Pumpkin = new Item(fallOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "13 days", "Pumpkin", isItemAcquired("Pumpkin"), 1);
		Item Yam = new Item(fallOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "10 days", "Yam", isItemAcquired("Yam"), 1);
		
		ArrayList<Item> fallCropItems = new ArrayList<Item>();
		fallCropItems.add(Corn);
		fallCropItems.add(Eggplant);
		fallCropItems.add(Pumpkin);
		fallCropItems.add(Yam);			
		
		//Quality Crops
		Item GoldParsnip = new Item(springOnly, allWeather, farm, Quality.GOLD, 0, Skill.FARMING, allDay, "4 days", "Gold Parsnip", isItemAcquired("GoldParsnip"), 5);
		Item GoldMelon = new Item(summerOnly, allWeather, farm, Quality.GOLD, 0, Skill.FARMING, allDay, "12 days", "Gold Melon", isItemAcquired("GoldMelon"), 5);
		Item GoldPumpkin = new Item(fallOnly, allWeather, farm, Quality.GOLD, 0, Skill.FARMING, allDay, "13 days", "Gold Pumpkin", isItemAcquired("GoldPumpkin"), 5);
		Item GoldCorn = new Item(summerFall, allWeather, farm, Quality.GOLD, 0, Skill.FARMING, allDay, "14 days, then every 4", "Gold Corn", isItemAcquired("GoldCorn"), 5);
		
		ArrayList<Item> qualityCropItems = new ArrayList<Item>();
		qualityCropItems.add(GoldParsnip);
		qualityCropItems.add(GoldMelon);
		qualityCropItems.add(GoldPumpkin);
		qualityCropItems.add(GoldCorn);			
		
		//Animal Bundle
		Item LargeMilk = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Cow, high mood & friendship", "Large Milk", isItemAcquired("LargeMilk"), 1);
		Item WhiteLargeEgg = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "White Chicken, high mood & friendship", "Large White Egg", isItemAcquired("WhiteLargeEgg"), 1);
		Item BrownLargeEgg = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Brown Chicken, high mood & friendship", "Large Brown Egg", isItemAcquired("BrownLargeEgg"), 1);
		Item LargeGoatMilk = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Goat, high mood & friendship", "Large Goat Milk", isItemAcquired("LargeGoatMilk"), 1);
		Item Wool = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Rabbit or Sheep", "Wool", isItemAcquired("Wool"), 1);
		Item DuckEgg = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Duck", "Duck Egg", isItemAcquired("DuckEgg"), 1);
		
		ArrayList<Item> animalItems = new ArrayList<Item>();
		animalItems.add(LargeMilk);
		animalItems.add(WhiteLargeEgg);
		animalItems.add(BrownLargeEgg);
		animalItems.add(LargeGoatMilk);	
		animalItems.add(Wool);	
		animalItems.add(DuckEgg);			
		
		//Artisan Bundle
		Item TruffleOil = new Item(springSummerFall, sunnyWindy, farm, Quality.ANY, 8, Skill.FARMING, allDay, "Pig, truffle & oil maker", "Truffle Oil", isItemAcquired("TruffleOil"), 1);
		Item Cloth = new Item(allYear, allWeather, farm, Quality.ANY, 7, Skill.FARMING, allDay, "Wool & Loom, 10% from Soggy Newspaper & Recycling Machine", "Cloth", isItemAcquired("Cloth"), 1);
		Item GoatCheese = new Item(allYear, allWeather, farm, Quality.ANY, 6, Skill.FARMING, allDay, "Goat Milk & Cheese Press", "Goat Cheese", isItemAcquired("GoatCheese"), 1);
		Item Cheese = new Item(allYear, allWeather, farm, Quality.ANY, 6, Skill.FARMING, allDay, "Milk & Cheese Press", "Cheese", isItemAcquired("Cheese"), 1);		
		Item Honey = new Item(springSummerFall, allWeather, farm, Quality.ANY, 3, Skill.FARMING, allDay, "Bee Box, every 4 days", "Honey", isItemAcquired("Honey"), 1);
		Item Jelly = new Item(allYear, allWeather, farm, Quality.ANY, 4, Skill.FARMING, allDay, "Any Fruit & Preserves Jar, 2-3 days", "Jelly", isItemAcquired("Jelly"), 1);
		Item Apple = new Item(fallOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Tree or Farm Cave", "Apple", isItemAcquired("Apple"), 1);
		Item Apricot = new Item(springOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Tree or Farm Cave", "Apricot", isItemAcquired("Apricot"), 1);
		Item Orange = new Item(summerOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Tree or Farm Cave", "Orange", isItemAcquired("Orange"), 1);
		Item Peach = new Item(summerOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Tree or Farm Cave", "Peach", isItemAcquired("Peach"), 1);
		Item Pomegranate = new Item(fallOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Tree or Farm Cave", "Pomegranate", isItemAcquired("Pomegranate"), 1);
		Item Cherry = new Item(springOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Tree or Farm Cave", "Cherry", isItemAcquired("Cherry"), 1);
		
		ArrayList<Item> artisanItems = new ArrayList<Item>();
		artisanItems.add(TruffleOil);	
		artisanItems.add(Cloth);	
		artisanItems.add(GoatCheese);	
		artisanItems.add(Cheese);	
		artisanItems.add(Honey);	
		artisanItems.add(Jelly);	
		artisanItems.add(Apple);	
		artisanItems.add(Apricot);	
		artisanItems.add(Orange);	
		artisanItems.add(Peach);
		artisanItems.add(Pomegranate);
		artisanItems.add(Cherry);		

		//River Fish Bundle
		Item Sunfish = new Item(springSummer, sunnyWindy, anyRiver, Quality.ANY, 0, Skill.FISHING, daytime, "Difficulty: 30, Behavior: Mixed", "Sunfish", isItemAcquired("Sunfish"), 1);
		Item Catfish = new Item(springFall, rainyWeather, anyRiverSecret, Quality.ANY, 0, Skill.FISHING, catfish, "Difficulty: 75, Behavior: Mixed", "Catfish", isItemAcquired("Catfish"), 1);
		Item Shad = new Item(springSummerFall, rainyWeather, anyRiver, Quality.ANY, 0, Skill.FISHING, shad, "Difficulty: 45, Behavior: Smooth", "Shad", isItemAcquired("Shad"), 1);	
		Item TigerTrout = new Item(fallWinter, allWeather, anyRiver, Quality.ANY, 0, Skill.FISHING, daytime, "Difficulty: 60, Behavior: Dart", "Tiger Trout", isItemAcquired("TigerTrout"), 1);		
		
		ArrayList<Item> riverFishItems = new ArrayList<Item>();
		riverFishItems.add(Sunfish);
		riverFishItems.add(Catfish);
		riverFishItems.add(Shad);
		riverFishItems.add(TigerTrout);			
		
		//Lake Fish Bundle
		Item LargemouthBass = new Item(allYear, allWeather, mountainlake, Quality.ANY, 0, Skill.FISHING, daytime, "Difficulty: 50, Behavior: Mixed", "Largemouth Bass", isItemAcquired("LargemouthBass"), 1);
		Item Carp = new Item(allYear, allWeather, carpLocations, Quality.ANY, 0, Skill.FISHING, allDay, "Difficulty: 15, Behavior: Mixed, Not in Lake/Pond in Winter", "Carp", isItemAcquired("Carp"), 1);
		Item Bullhead = new Item(allYear, allWeather, mountainlake, Quality.ANY, 0, Skill.FISHING, allDay, "Difficulty: 46, Behavior: Smooth", "Bullhead", isItemAcquired("Bullhead"), 1);
		Item Sturgeon = new Item(summerWinter, allWeather, mountainlake, Quality.ANY, 0, Skill.FISHING, daytime, "Difficulty: 78, Behavior: Mixed", "Sturgeon", isItemAcquired("Sturgeon"), 1);	
		
		ArrayList<Item> lakeFishItems = new ArrayList<Item>();
		lakeFishItems.add(LargemouthBass);
		lakeFishItems.add(Carp);
		lakeFishItems.add(Bullhead);
		lakeFishItems.add(Sturgeon);		
		
		//Ocean Fish Bundle
		Item Sardine = new Item(springSummerFall, allWeather, ocean, Quality.ANY, 0, Skill.FISHING, daytime, "Difficulty: 30, Behavior: Dart", "Sardine", isItemAcquired("Sardine"), 1);		
		Item Tuna = new Item(summerWinter, allWeather, ocean, Quality.ANY, 0, Skill.FISHING, daytime, "Difficulty: 70, Behavior: Smooth", "Tuna", isItemAcquired("Tuna"), 1);
		Item RedSnapper = new Item(summerFall, rainyWeather, ocean, Quality.ANY, 0, Skill.FISHING, daytime, "Difficulty: 40, Behavior: Mixed", "Red Snapper", isItemAcquired("RedSnapper"), 1);
		Item Tilapia = new Item(summerFall, allWeather, ocean, Quality.ANY, 0, Skill.FISHING, tilapia, "Difficulty: 50, Behavior: Mixed", "Tilapia", isItemAcquired("Tilapia"), 1);		
		
		ArrayList<Item> oceanFishItems = new ArrayList<Item>();
		oceanFishItems.add(Sardine);
		oceanFishItems.add(Tuna);
		oceanFishItems.add(RedSnapper);
		oceanFishItems.add(Tilapia);		
		
		//Night Fish Bundle
		Item Walleye = new Item(fallOnly, rainyWeather, riversLakes, Quality.ANY, 0, Skill.FISHING, walleye, "Difficulty: 45, Behavior: Smooth", "Walleye", isItemAcquired("Walleye"), 1);	
		Item Bream = new Item(allYear, allWeather, anyRiver, Quality.ANY, 0, Skill.FISHING, nighttime, "Difficulty: 35, Behavior: Smooth", "Bream", isItemAcquired("Bream"), 1);	
		Item Eel = new Item(springFall, rainyWeather, ocean, Quality.ANY, 0, Skill.FISHING, eel, "Difficulty: 70, Behavior: Smooth", "Eel", isItemAcquired("Eel"), 1);			
		
		ArrayList<Item> nightFishItems = new ArrayList<Item>();
		nightFishItems.add(Walleye);
		nightFishItems.add(Bream);
		nightFishItems.add(Eel);	
		
		//Crab Pot Bundle
		Item Lobster = new Item(allYear, allWeather, ocean, Quality.ANY, 3, Skill.FISHING, allDay, "Crab Pot", "Lobster", isItemAcquired("Lobster"), 1);
		Item Crayfish = new Item(allYear, allWeather, freshwater, Quality.ANY, 3, Skill.FISHING, allDay, "Crab Pot", "Crayfish", isItemAcquired("Crayfish"), 1);	
		Item Crab = new Item(allYear, allWeather, ocean, Quality.ANY, 0, Skill.FISHING, allDay, "Crab Pot, Also Crabs in Mines", "Crab", isItemAcquired("Crab"), 1);	
		Item Cockle = new Item(allYear, allWeather, oceanBeach, Quality.ANY, 0, Skill.FISHING, allDay, "Crab Pot or Beach", "Cockle", isItemAcquired("Cockle"), 1);	
		Item Mussel = new Item(allYear, allWeather, oceanBeach, Quality.ANY, 0, Skill.FISHING, allDay, "Crab Pot or Beach", "Mussel", isItemAcquired("Mussel"), 1);		
		Item Shrimp = new Item(allYear, allWeather, ocean, Quality.ANY, 3, Skill.FISHING, allDay, "Crab Pot", "Shrimp", isItemAcquired("Shrimp"), 1);
		Item Snail = new Item(allYear, allWeather, freshwater, Quality.ANY, 3, Skill.FISHING, allDay, "Crab Pot", "Snail", isItemAcquired("Snail"), 1);	
		Item Periwinkle = new Item(allYear, allWeather, freshwater, Quality.ANY, 3, Skill.FISHING, allDay, "Crab Pot", "Periwinkle", isItemAcquired("Periwinkle"), 1);			
		Item Oyster = new Item(allYear, allWeather, oceanBeach, Quality.ANY, 0, Skill.FISHING, allDay, "Crab Pot or Beach", "Oyster", isItemAcquired("Oyster"), 1);	
		Item Clam = new Item(allYear, allWeather, oceanBeach, Quality.ANY, 0, Skill.FISHING, allDay, "Crab Pot or Beach", "Clam", isItemAcquired("Clam"), 1);
		
		ArrayList<Item> crabPotItems = new ArrayList<Item>();
		crabPotItems.add(Lobster);
		crabPotItems.add(Crayfish);
		crabPotItems.add(Crab);
		crabPotItems.add(Cockle);
		crabPotItems.add(Mussel);
		crabPotItems.add(Shrimp);
		crabPotItems.add(Snail);
		crabPotItems.add(Periwinkle);	
		crabPotItems.add(Oyster);
		crabPotItems.add(Clam);		
		
		//Specialty Fish Bundle
		Item Pufferfish = new Item(summerOnly, sunnyWeather, ocean, Quality.ANY, 0, Skill.FISHING, pufferfish, "Difficulty: 80, Behavior: Floater", "Pufferfish", isItemAcquired("Pufferfish"), 1);	
		Item Ghostfish = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.FISHING, allDay, "Floors: 20 & 60, dropped by ghosts, Difficulty: 50, Behavior: Mixed", "Ghostfish", isItemAcquired("Ghostfish"), 1);	
		Item Sandfish = new Item(allYear, allWeather, desert, Quality.ANY, 0, Skill.FISHING, extendedDaytime, "Difficulty: 65, Behavior: Mixed", "Sandfish", isItemAcquired("Sandfish"), 1);	
		Item Woodskip = new Item(allYear, allWeather, secretWoods, Quality.ANY, 0, Skill.FISHING, allDay, "Difficulty: 50, Behavior: Mixed", "Woodskip", isItemAcquired("Woodskip"), 1);			
		
		ArrayList<Item> specialtyFishItems = new ArrayList<Item>();
		specialtyFishItems.add(Pufferfish);
		specialtyFishItems.add(Ghostfish);
		specialtyFishItems.add(Sandfish);
		specialtyFishItems.add(Woodskip);			
		
		//Blacksmiths Bundle
		Item CopperBar = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Smelt 5 copper ore, Floors 1-39", "Copper Bar", isItemAcquired("CopperBar"), 1);
		Item IronBar = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Smelt 5 iron ore, Floors 41-79", "Iron Bar", isItemAcquired("IronBar"), 1);
		Item GoldBar = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Smelt 5 gold ore, Floors 81+", "Gold Bar", isItemAcquired("GoldBar"), 1);	
		
		ArrayList<Item> blacksmithItems = new ArrayList<Item>();
		blacksmithItems.add(CopperBar);
		blacksmithItems.add(IronBar);
		blacksmithItems.add(GoldBar);		
		
		//Geologists Bundle
		Item Quartz = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "", "Quartz", isItemAcquired("Quartz"), 1);
		Item EarthCrystal = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Floors 1-39, Geodes, Duggies", "Earth Crystal", isItemAcquired("EarthCrystal"), 1);
		Item FrozenTear = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Floors 40-79, Frozen Geodes, Dust Sprites", "Frozen Tear", isItemAcquired("FrozenTear"), 1);
		Item FireQuartz = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Floors 80+, Magma Geodes", "Fire Quartz", isItemAcquired("FireQuartz"), 1);	
		
		ArrayList<Item> geologistItems = new ArrayList<Item>();
		geologistItems.add(Quartz);
		geologistItems.add(EarthCrystal);
		geologistItems.add(FrozenTear);
		geologistItems.add(FireQuartz);			
		
		//Adventurers Bundle
		Item Slime = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.COMBAT, allDay, "Slimes", "Slime", isItemAcquired("Slime"), 1);
		Item BatWing = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.COMBAT, allDay, "Bat, Frost Bat, Lava Bat, Floors: 31-119", "Bat Wing", isItemAcquired("BatWing"), 1);
		Item SolarEssence = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.COMBAT, allDay, "Ghosts, Metal Head, Haunted Skull, Squid Kid, Floors: 50+", "Solar Essence", isItemAcquired("SolarEssence"), 1);
		Item VoidEssence = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.COMBAT, allDay, "Shadow Creatures, Haunted Skull, Floors 80+", "Void Essence", isItemAcquired("VoidEssence"), 1);		
		
		ArrayList<Item> adventureItems = new ArrayList<Item>();
		adventureItems.add(Slime);
		adventureItems.add(BatWing);
		adventureItems.add(SolarEssence);
		adventureItems.add(VoidEssence);			
		
		//Chefs Bundle
		Item MapleSyrup2 = new Item(allYear, allWeather, foragingLocations, Quality.ANY, 3, Skill.FORAGING, allDay, "Tapped Maple Tree - 9 days", "Maple Syrup", isItemAcquired("MapleSyrup2"), 1);	
		Item Truffle = new Item(springSummerFall, sunnyWindy, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Pig", "Truffle", isItemAcquired("Truffle"), 1);	
		Item FiddleheadFern = new Item(summerOnly, allWeather, secretWoods, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Fiddlehead Fern", isItemAcquired("FiddleheadFern"), 1);	
		Item Poppy = new Item(summerOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "7 days", "Poppy", isItemAcquired("Poppy"), 1);
		Item MakiRoll = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Cooking: Any Fish + Seaweed + Rice, Recipie @ Saloon 300g, Saloon 440g", "Maki Roll", isItemAcquired("MakiRoll"), 1);
		Item FriedEgg = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Cooking: egg, Saloon 70g", "Fried Egg", isItemAcquired("FriedEgg"), 1);	
		
		ArrayList<Item> chefItems = new ArrayList<Item>();
		chefItems.add(MapleSyrup2);		
		chefItems.add(Truffle);
		chefItems.add(FiddleheadFern);
		chefItems.add(Poppy);
		chefItems.add(MakiRoll);
		chefItems.add(FriedEgg);		
		
		//Dye Bundle
		Item RedMushroom2 = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.FORAGING, allDay, "Secret Woods in Summer&Fall, Farm Cave all year", "Red Mushroom", isItemAcquired("RedMushroom2"), 1);		
		Item SeaUrchin = new Item(allYear, allWeather, beach, Quality.ANY, 0, Skill.FORAGING, allDay, "Requires repaired bridge", "Sea Urchin", isItemAcquired("SeaUrchin"), 1);
		Item Sunflower = new Item(summerFall, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "8 days", "Sunflower", isItemAcquired("Sunflower"), 1);
		Item DuckFeather = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Dropped by 200+ friendship duck", "Duck Feather", isItemAcquired("DuckFeather"), 1);
		Item Aquamarine = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Floors: 40+", "Aquamarine", isItemAcquired("Aquamarine"), 1);
		Item RedCabbage = new Item(summerOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Seeds available in year 2, 9 days", "Red Cabbage", isItemAcquired("RedCabbage"), 1);
		
		ArrayList<Item> dyeItems = new ArrayList<Item>();
		dyeItems.add(RedMushroom2);		
		dyeItems.add(SeaUrchin);
		dyeItems.add(Sunflower);
		dyeItems.add(DuckFeather);
		dyeItems.add(Aquamarine);
		dyeItems.add(RedCabbage);		
		
		//Field Research Bundle
		Item PurpleMushroom2 = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.FORAGING, allDay, "Mine: 81+, Skull Cave, Farm Cave", "Purple Mushroom", isItemAcquired("PurpleMushroom2"), 1);	
		Item NautilusShell = new Item(winterOnly, allWeather, beach, Quality.ANY, 0, Skill.FORAGING, allDay, "", "Nautilus Shell", isItemAcquired("NautilusShell"), 1);
		Item Chub = new Item(allYear, allWeather, lakeRivers, Quality.ANY, 0, Skill.FISHING, allDay, "Difficulty: 35, Behavior: Dart", "Chub", isItemAcquired("Chub"), 1);
		Item FrozenGeode = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Floors: 41-79", "Frozen Geode", isItemAcquired("FrozenGeode"), 1);		
		
		ArrayList<Item> researchItems = new ArrayList<Item>();
		researchItems.add(PurpleMushroom2);		
		researchItems.add(NautilusShell);
		researchItems.add(Chub);
		researchItems.add(FrozenGeode);		
		
		//Fodder Bundle
		Item Apple2 = new Item(fallOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Tree or Farm Cave", "Apple", isItemAcquired("Apple2"), 3);
		Item Wheat = new Item(summerFall, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "4 days", "Wheat", isItemAcquired("Wheat"), 10);
		Item Hay = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Bought from Marnie 50g, harvesting grass", "Hay", isItemAcquired("Hay"), 10);		
		
		ArrayList<Item> fodderItems = new ArrayList<Item>();
		fodderItems.add(Apple2);		
		fodderItems.add(Wheat);
		fodderItems.add(Hay);		
		
		//Enchanters Bundle
		Item OakResin2 = new Item(allYear, allWeather, foragingLocations, Quality.ANY, 3, Skill.FORAGING, allDay, "Tapped Oak Tree - 8 days", "Oak Resin", isItemAcquired("OakResin2"), 1);	
		Item Wine = new Item(allYear, allWeather, farm, Quality.ANY, 4, Skill.FARMING, allDay, "Any Fruit & Keg, 2-3 days", "Wine", isItemAcquired("Wine"), 1);
		Item Pomegranate2 = new Item(fallOnly, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Tree or Farm Cave", "Pomegranate", isItemAcquired("Pomegranate2"), 1);		
		Item RabbitsFoot = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "Rabbit, Rare drop from Skull Cave Serprent", "Rabbit's Foot", isItemAcquired("RabbitsFoot"), 1);		
		
		ArrayList<Item> enchantersItems = new ArrayList<Item>();
		enchantersItems.add(OakResin2);		
		enchantersItems.add(Wine);
		enchantersItems.add(Pomegranate2);
		enchantersItems.add(RabbitsFoot);		
		
		//2500 bundle
		Item gold2500 = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "2,500g", "2,500 Gold", isItemAcquired("gold2500"), 1);		
		
		ArrayList<Item> gold2500Items = new ArrayList<Item>();
		gold2500Items.add(gold2500);			
		
		//5000 bundle
		Item gold5000 = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "5,000g", "5,000 Gold", isItemAcquired("gold5000"), 1);			
		
		ArrayList<Item> gold5000Items = new ArrayList<Item>();
		gold5000Items.add(gold5000);			
		
		//10000 bundle
		Item gold10000 = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "10,000g", "10,000 Gold", isItemAcquired("gold10000"), 1);			
		
		ArrayList<Item> gold10000Items = new ArrayList<Item>();
		gold10000Items.add(gold10000);			
		
		//25000 bundle
		Item gold25000 = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FARMING, allDay, "25,000g", "25,000 Gold", isItemAcquired("gold25000"), 1);	
		
		ArrayList<Item> gold25000Items = new ArrayList<Item>();
		gold25000Items.add(gold25000);			
		
		//Missing Bundle
		Item SilverWine = new Item(allYear, allWeather, farm, Quality.SILVER, 4, Skill.FARMING, allDay, "Wine & Cask 14 days", "Silver Wine", isItemAcquired("SilverWine"), 1);
		Item DinosaurMayonnaise = new Item(allYear, allWeather, farm, Quality.ANY, 2, Skill.FARMING, allDay, "Dino Egg (Artifacts/Dinos) + Mayo Machine", "Dinosaur Mayonnaise", isItemAcquired("DinosaurMayonnaise"), 1);
		Item PrismaticShard = new Item(allYear, allWeather, mine, Quality.ANY, 0, Skill.MINING, allDay, "Omni Geode, Iridium Node, Serpent, Mummy, Shadow Creatures, Mystic Stone", "Prismatic Shard", isItemAcquired("PrismaticShard"), 1);
		Item GoldAncientFruit = new Item(springSummerFall, allWeather, farm, Quality.GOLD, 0, Skill.FARMING, allDay, "28 days then every 7", "Gold Ancient Fruit", isItemAcquired("GoldAncientFruit"), 5);
		Item GoldVoidSalmon = new Item(allYear, allWeather, witchesSwamp, Quality.GOLD, 0, Skill.FISHING, allDay, "Difficulty: 80, Behavior: Mixed", "Gold Void Salmon", isItemAcquired("GoldVoidSalmon"), 5);
		Item Caviar = new Item(allYear, allWeather, farm, Quality.ANY, 0, Skill.FISHING, allDay, "Sturgeon Roe (Pond) + Preserves Jar", "Caviar", isItemAcquired("Caviar"), 5);		
		
		ArrayList<Item> missingItems = new ArrayList<Item>();
		missingItems.add(SilverWine);		
		missingItems.add(DinosaurMayonnaise);
		missingItems.add(PrismaticShard);
		missingItems.add(GoldAncientFruit);
		missingItems.add(GoldVoidSalmon);
		missingItems.add(Caviar);		
		
		/********************* Bundle Initialization ******************************/
		
		//CRAFTS ROOM
		Bundle SpringForage = new Bundle(springForageItems, 4, "Spring Seeds (30)");
		Bundle SummerForage = new Bundle(summerForageItems, 3, "Summer Seeds (30)");
		Bundle FallForage = new Bundle(fallForageItems, 4, "Fall Seeds (30)");
		Bundle WinterForage = new Bundle(winterForageItems, 4, "Winter Seeds (30)");
		Bundle Construction = new Bundle(constructionItems, 4, "Charcoal Kiln");
		Bundle ExoticForage = new Bundle(exoticItems, 5, "Autumn's Bounty (5)");
		
		ArrayList<Bundle> craftRoomBundles = new ArrayList<Bundle>();
		craftRoomBundles.add(SpringForage);		
		craftRoomBundles.add(SummerForage);	
		craftRoomBundles.add(FallForage);	
		craftRoomBundles.add(WinterForage);	
		craftRoomBundles.add(Construction);	
		craftRoomBundles.add(ExoticForage);	
		
		//PANTRY ROOM
		Bundle SpringCrops = new Bundle(springCropItems, 4, "Speed-Gro (20)");
		Bundle SummerCrops = new Bundle(springCropItems, 4, "Quality Sprinkler");
		Bundle FallCrops = new Bundle(fallCropItems, 4, "Bee House");
		Bundle QualityCrops = new Bundle(qualityCropItems, 3, "Preserves Jar");
		Bundle Animal = new Bundle(animalItems, 5, "Cheese Press");
		Bundle Artisan = new Bundle(artisanItems, 6, "Keg");
		
		ArrayList<Bundle> pantryRoomBundles = new ArrayList<Bundle>();
		pantryRoomBundles.add(SpringCrops);		
		pantryRoomBundles.add(SummerCrops);	
		pantryRoomBundles.add(FallCrops);	
		pantryRoomBundles.add(QualityCrops);	
		pantryRoomBundles.add(Animal);	
		pantryRoomBundles.add(Artisan);			
		
		//FISH TANK
		Bundle RiverFish = new Bundle(riverFishItems, 4, "Bair (30)");
		Bundle LakeFish = new Bundle(lakeFishItems, 4, "Dressed Spinner");
		Bundle OceanFish = new Bundle(oceanFishItems, 4, "Warp Totem: Beach (5)");
		Bundle NightFish = new Bundle(nightFishItems, 3, "Small Glow Ring");
		Bundle CrabPot = new Bundle(crabPotItems, 5, "Crab Pot (3)");
		Bundle SpecialtyFish = new Bundle(specialtyFishItems, 4, "Dish O' The Sea (5)");
		
		ArrayList<Bundle> fishTankBundles = new ArrayList<Bundle>();
		fishTankBundles.add(RiverFish);		
		fishTankBundles.add(LakeFish);	
		fishTankBundles.add(OceanFish);	
		fishTankBundles.add(NightFish);	
		fishTankBundles.add(CrabPot);	
		fishTankBundles.add(SpecialtyFish);			
		
		//BOILER ROOM
		Bundle Blacksmiths = new Bundle(blacksmithItems, 3, "Furnace");
		Bundle Geologists = new Bundle(geologistItems, 4, "Omni Geode (5)");
		Bundle Adventurers = new Bundle(adventureItems, 2, "Small Magnet Ring");
		
		ArrayList<Bundle> boilerRoomBundles = new ArrayList<Bundle>();
		boilerRoomBundles.add(Blacksmiths);		
		boilerRoomBundles.add(Geologists);	
		boilerRoomBundles.add(Adventurers);			
		
		//BULLETIN BOARD
		Bundle Chefs = new Bundle(chefItems, 6, "Pink Cake(3)");
		Bundle Dye = new Bundle(dyeItems, 6, "Seed Maker");
		Bundle FieldResearch = new Bundle(researchItems, 4, "Recycling Machine");
		Bundle Fodder = new Bundle(fodderItems, 3, "Heater");
		Bundle Enchanters = new Bundle(enchantersItems, 4, "Gold Bar (5)");
		
		ArrayList<Bundle> bulletinBoardBundles = new ArrayList<Bundle>();
		bulletinBoardBundles.add(Chefs);		
		bulletinBoardBundles.add(Dye);	
		bulletinBoardBundles.add(FieldResearch);	
		bulletinBoardBundles.add(Fodder);	
		bulletinBoardBundles.add(Enchanters);				
		
		//VAULT
		Bundle Gold2500 = new Bundle(gold2500Items, 1, "Chocolate Cake (3)");
		Bundle Gold5000 = new Bundle(gold5000Items, 1, "Quality Fertilizer (30)");
		Bundle Gold10000 = new Bundle(gold10000Items, 1, "Lightning Rod");
		Bundle Gold25000 = new Bundle(gold25000Items, 1, "Crystalarium");
		
		ArrayList<Bundle> vaultBundles = new ArrayList<Bundle>();
		vaultBundles.add(Gold2500);		
		vaultBundles.add(Gold5000);	
		vaultBundles.add(Gold10000);	
		vaultBundles.add(Gold25000);			
		
		//ABANDONED JOJAMART
		Bundle Missing = new Bundle(missingItems, 5, "");
		
		ArrayList<Bundle> jojaMartBundles = new ArrayList<Bundle>();
		jojaMartBundles.add(Missing);				
		
		/********************* Room Initialization ******************************/
		
		CommunityRoom CraftsRoom = new CommunityRoom(craftRoomBundles, "Bridge Repair");
		CommunityRoom Pantry = new CommunityRoom(pantryRoomBundles, "Greenhouse");
		CommunityRoom FishTank = new CommunityRoom(fishTankBundles, "Glittering Boulder Removed");
		CommunityRoom BoilerRoom = new CommunityRoom(boilerRoomBundles, "Minecarts Repaired");
		CommunityRoom BulletinBoard = new CommunityRoom(bulletinBoardBundles, "Friendship (500 points)");
		CommunityRoom Vault = new CommunityRoom(vaultBundles, "Bus Repair");
		CommunityRoom AbandonedJojaMart = new CommunityRoom(jojaMartBundles, "Movie Theater");		
		
		ArrayList<CommunityRoom> communityCenterRooms = new ArrayList<CommunityRoom>();
		communityCenterRooms.add(CraftsRoom);	
		communityCenterRooms.add(Pantry);	
		communityCenterRooms.add(FishTank);	
		communityCenterRooms.add(BoilerRoom);	
		communityCenterRooms.add(BulletinBoard);	
		communityCenterRooms.add(Vault);	
		communityCenterRooms.add(AbandonedJojaMart);	
		
		//Community Center
		CommunityCenter playersCommunityCenter = new CommunityCenter(communityCenterRooms);
		
		return playersCommunityCenter;
	}
}
