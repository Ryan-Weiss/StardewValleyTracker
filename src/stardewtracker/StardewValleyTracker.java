package stardewtracker;

//JavaFX imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
//IO import needed for file operations
import java.io.IOException;
import java.io.File;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
//Utility imports for data structures
import java.util.ArrayList;

public class StardewValleyTracker extends Application {
	
	//Config File Properties
	public String saveFilePath;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainWindow) throws Exception {
		
		mainWindow.setTitle("Stardew Valley Community Center Tracker");
		
		if (fileExists("../config.properties")) {
			readProperties("../config.properties");
		} else {
			createConfigProperties();
		}
		
		StackPane layout = new StackPane();
		Scene sampleScene = new Scene(layout, 600, 500);
		mainWindow.setScene(sampleScene);
		mainWindow.show();
		
		//Direct user to request a save path if path is empty
		if (saveFilePath.equals("")) {
			getSaveDirPath(mainWindow, layout);
		} 
		
		//create the save file folder if none exists, if it fails to create, request a new save path
		if (!folderExists(saveFilePath + "\\StardewValleyTracker")) {
			if (!createSaveFileFolder(saveFilePath + "\\StardewValleyTracker")) {
				getSaveDirPath(mainWindow, layout);
			}
		}
		
		saveScreenInit(mainWindow);
	}	
		
	//Function to draw the current save screen for the user
	public void saveScreenInit(Stage mainWindow) {
		GridPane layout = new GridPane();
		Scene saveScene = new Scene(layout, 600, 500);
		ArrayList<SaveFile> saveFiles = getSaveFiles();
		int rowCount = 1;
		
		for (SaveFile save : saveFiles) {
			
			Button loadButton = new Button("Load File");
			loadButton.setOnAction(e -> {
				//this has to wait, we need to launch a new screen that actually has data on it, once we hit this function we are in the green for developing the objects to represent the structures in the system
		    });			
			
			//Button to direct the user to a pop up for renaming a save file
			Button renameButton = new Button("Rename File");
			renameButton.setOnAction(e -> {
				Stage renameWindow = new Stage();
				renameWindow.initModality(Modality.WINDOW_MODAL);
				renameWindow.initOwner(mainWindow);
				GridPane renameLayout = new GridPane();
				Scene renameScene = new Scene(renameLayout, 300, 250);
				
				TextField renameText = new TextField();
				Button submit = new Button("Submit");
				
				submit.setOnAction(e2 -> {
					if (!renameText.getCharacters().toString().equals("")) {
						String renameString = renameText.getCharacters().toString();
						renameSaveFile(mainWindow, renameString, save.getPath());
						renameWindow.close();
					}
			    });	
				
				renameLayout.add(renameText, 1, 1);				
				renameLayout.add(submit, 2, 1);	
				renameWindow.setScene(renameScene);
				renameWindow.show();
		    });			
			
			//Button to direct the user to a pop up for deleting the save file
			Button deleteButton = new Button("Delete File");
			deleteButton.setOnAction(e -> {
				Stage confirmWindow = new Stage();
				confirmWindow.initModality(Modality.WINDOW_MODAL);
				confirmWindow.initOwner(mainWindow);
				GridPane confirmLayout = new GridPane();
				Scene confirmScene = new Scene(confirmLayout, 300, 250);
				
				Text confirmation = new Text("Are you sure you want to delete?");
				Button returnToWindow = new Button("No");
				Button delete = new Button("Yes");
				
				delete.setOnAction(e2 -> {
					confirmWindow.close();
					deleteSaveFile(mainWindow, save.getPath());
			    });	
				returnToWindow.setOnAction(e2 -> {
					confirmWindow.close();
					saveScreenInit(mainWindow);
			    });					
				
				confirmLayout.add(confirmation, 1, 1);				
				confirmLayout.add(returnToWindow, 1, 2);
				confirmLayout.add(delete, 2, 2);	
				confirmWindow.setScene(confirmScene);
				confirmWindow.show();
		    });			
			
			Text saveFileName = new Text(save.getName());

			layout.addRow(rowCount, saveFileName, loadButton, renameButton, deleteButton);
			rowCount++;
		}
		
		//Button to direct the user to a pop up for naming a new save file
		Button newSaveButton = new Button("New File");
		newSaveButton.setOnAction(e -> {
			Stage nameWindow = new Stage();
			nameWindow.initModality(Modality.WINDOW_MODAL);
			nameWindow.initOwner(mainWindow);
			GridPane nameLayout = new GridPane();
			Scene nameScene = new Scene(nameLayout, 300, 250);
	
			Text prompt = new Text("Enter Save Name");
			TextField nameText = new TextField();
			Button submit = new Button("Submit");
			
			submit.setOnAction(e2 -> {
				if (!nameText.getCharacters().toString().equals("")) {
					String nameString = nameText.getCharacters().toString();
					nameWindow.close();
					newSaveFile(mainWindow, nameString, saveFilePath + "\\StardewValleyTracker");
				}
		    });	
			
			nameLayout.add(prompt, 2, 1);
			nameLayout.add(nameText, 2, 2);
			nameLayout.add(submit, 3, 2);	
			nameWindow.setScene(nameScene);
			nameWindow.show();
	    });	
		
		layout.add(newSaveButton, 1, rowCount);
		mainWindow.setScene(saveScene);
		mainWindow.show();
	}
	
	//Function to retrieve list of save file objects
	public ArrayList<SaveFile> getSaveFiles() {
		String filesLocations = saveFilePath + "\\StardewValleyTracker";
		File[] fileList = new File(filesLocations).listFiles();
		ArrayList<SaveFile> saveFiles = new ArrayList<SaveFile>();
		for (File file : fileList) {
			SaveFile save = readSaveFile(file.getAbsolutePath());
			if (save != null) {
				saveFiles.add(save);
			}
		}		
		return saveFiles;
	}
	
	//Function to read a save file into a SaveFile object
	public SaveFile readSaveFile(String savePath) {
		try(InputStream InStream = new FileInputStream(savePath)) {
			Properties save = new Properties();
			save.load(InStream);
			SaveFile saveFile = new SaveFile(save.getProperty("SaveFileName"), savePath);
			InStream.close();
			return saveFile;
		} catch (IOException io) {
            io.printStackTrace();
        }
		return null;
	}		
	
	//Function to create a new save file
	public void newSaveFile(Stage mainWindow, String nameString, String nameBasePath) {
		String newSavePath = nameBasePath + "\\" + nameString + ".properties";
        try (OutputStream output = new FileOutputStream(newSavePath)) {
            Properties prop = new Properties();
            
            //Save File Properties
            prop.setProperty("SaveFileName", nameString);
            prop.setProperty("SavePath", newSavePath); 
            
    		//Item Properties
            prop.setProperty("Wild Horseradish", "0"); 
            prop.setProperty("Leek", "0");		
            prop.setProperty("Daffodil", "0");
            prop.setProperty("Dandelion", "0");
            prop.setProperty("Grape", "0");		
            prop.setProperty("Spice Berry", "0");
            prop.setProperty("Sweet Pea", "0");		
            prop.setProperty("Common Mushroom", "0");
            prop.setProperty("Wild Plum", "0");		
            prop.setProperty("Hazelnut", "0");
            prop.setProperty("Blackberry", "0");			
            prop.setProperty("Winter Root", "0");
            prop.setProperty("Crystal Fruit", "0");		
            prop.setProperty("Snow Yam", "0");
            prop.setProperty("Crocus", "0");			
            prop.setProperty("Wood", "0"); 
            prop.setProperty("Wood2", "0"); 	
            prop.setProperty("Stone", "0"); 
            prop.setProperty("Hardwood", "0"); 	
            prop.setProperty("Coconut", "0");	
            prop.setProperty("Cactus Fruit", "0");	
            prop.setProperty("Cave Carrot", "0");	
            prop.setProperty("RedMushroom", "0");	
            prop.setProperty("PurpleMushroom", "0");	
            prop.setProperty("MapleSyrup", "0");	
            prop.setProperty("OakResin", "0");	
            prop.setProperty("PineTar", "0");	
            prop.setProperty("Morel", "0");			
            prop.setProperty("Parsnip", "0");	
            prop.setProperty("GreenBean", "0");
            prop.setProperty("Cauliflower", "0");
            prop.setProperty("Potato", "0");
            prop.setProperty("Tomato", "0");
            prop.setProperty("HotPepper", "0");
            prop.setProperty("Blueberry", "0");
            prop.setProperty("Melon", "0");	
            prop.setProperty("Corn", "0");
            prop.setProperty("Eggplant", "0");
            prop.setProperty("Pumpkin", "0");
            prop.setProperty("Yam", "0");	
            prop.setProperty("GoldParsnip", "0"); 
            prop.setProperty("GoldMelon", "0"); 
            prop.setProperty("GoldPumpkin", "0"); 
            prop.setProperty("GoldCorn", "0"); 
            prop.setProperty("LargeMilk", "0");
            prop.setProperty("BrownLargeEgg", "0");
            prop.setProperty("LargeGoatMilk", "0");
            prop.setProperty("Wool", "0");
            prop.setProperty("DuckEgg", "0");		
            prop.setProperty("TruffleOil", "0");
            prop.setProperty("Cloth", "0");
            prop.setProperty("GoatCheese", "0");
            prop.setProperty("Cheese", "0");		
            prop.setProperty("Honey", "0");
            prop.setProperty("Jelly", "0");
            prop.setProperty("Apple", "0");
            prop.setProperty("Apricot", "0");
            prop.setProperty("Orange", "0");
            prop.setProperty("Peach", "0");
            prop.setProperty("Pomegranate", "0");
            prop.setProperty("Cherry", "0");
            prop.setProperty("Sunfish", "0");
            prop.setProperty("Catfish", "0");
            prop.setProperty("Shad", "0");	
            prop.setProperty("TigerTrout", "0");		
            prop.setProperty("LargemouthBass", "0");
            prop.setProperty("Carp", "0");
            prop.setProperty("Bullhead", "0");
            prop.setProperty("Sturgeon", "0");	
            prop.setProperty("Sardine", "0");		
            prop.setProperty("Tuna", "0");
            prop.setProperty("RedSnapper", "0");
            prop.setProperty("Tilapia", "0");		
            prop.setProperty("Walleye", "0");	
            prop.setProperty("Bream", "0");	
            prop.setProperty("Eel", "0");			
            prop.setProperty("Lobster", "0");
            prop.setProperty("Crayfish", "0");	
            prop.setProperty("Crab", "0");	
            prop.setProperty("Cockle", "0");	
            prop.setProperty("Mussel", "0");		
            prop.setProperty("Shrimp", "0");
            prop.setProperty("Snail", "0");	
            prop.setProperty("Periwinkle", "0");			
            prop.setProperty("Oyster", "0");	
            prop.setProperty("Clam", "0");
            prop.setProperty("Pufferfish", "0");	
            prop.setProperty("Ghostfish", "0");	
            prop.setProperty("Sandfish", "0");	
            prop.setProperty("Woodskip", "0");			
            prop.setProperty("CopperBar", "0");
            prop.setProperty("IronBar", "0");
            prop.setProperty("GoldBar", "0");	
            prop.setProperty("Quartz", "0");
            prop.setProperty("EarthCrystal", "0");
            prop.setProperty("FrozenTear", "0");
            prop.setProperty("FireQuartz", "0");		
            prop.setProperty("Slime", "0");
            prop.setProperty("BatWing", "0");
            prop.setProperty("SolarEssence", "0");
            prop.setProperty("VoidEssence", "0");		
            prop.setProperty("MapleSyrup2", "0");	
            prop.setProperty("Truffle", "0");	
            prop.setProperty("FiddleheadFern", "0");	
            prop.setProperty("Poppy", "0");
            prop.setProperty("MakiRoll", "0");
            prop.setProperty("FriedEgg", "0");	
            prop.setProperty("RedMushroom2", "0");		
            prop.setProperty("SeaUrchin", "0");
            prop.setProperty("Sunflower", "0");
            prop.setProperty("DuckFeather", "0");
            prop.setProperty("Aquamarine", "0");
            prop.setProperty("RedCabbage", "0");
            prop.setProperty("PurpleMushroom2", "0");	
            prop.setProperty("NautilusShell", "0");
            prop.setProperty("Chub", "0");
            prop.setProperty("FrozenGeode", "0");		
            prop.setProperty("Apple2", "0"); 
            prop.setProperty("Wheat", "0"); 
            prop.setProperty("Hay", "0"); 	
            prop.setProperty("OakResin2", "0");	
            prop.setProperty("Wine", "0");
            prop.setProperty("Pomegranate2", "0");		
            prop.setProperty("RabbitsFoot", "0");		
            prop.setProperty("gold2500", "0");				
            prop.setProperty("gold5000", "0");						
            prop.setProperty("gold10000", "0");			
            prop.setProperty("gold25000", "0");			
            prop.setProperty("SilverWine", "0");
            prop.setProperty("DinosaurMayonnaise", "0");
            prop.setProperty("PrismaticShard", "0");
            prop.setProperty("GoldAncientFruit", "0"); 
            prop.setProperty("GoldVoidSalmon", "0"); 
            prop.setProperty("Caviar", "0"); 
                        
            prop.store(output, null);
            output.close();
    		saveScreenInit(mainWindow);
        } catch (IOException io) {
            io.printStackTrace();
        }
	}

	//Function to delete a save file
	public void deleteSaveFile(Stage mainWindow, String path) {
		File toDelete = new File(path);
		toDelete.delete();
		saveScreenInit(mainWindow);
	}
	
	//Function to rename a save file [load properties file, change save name, re-init save screen]
	public void renameSaveFile(Stage mainWindow, String renameString, String renamePath) {
        try (OutputStream output = new FileOutputStream(renamePath)) {
            Properties prop = new Properties();
            prop.setProperty("SaveFileName", renameString);
            prop.store(output, null);
            output.close();
            File toRename = new File(renamePath);
            toRename.renameTo(new File(saveFilePath + "\\StardewValleyTracker\\" + renameString + ".properties"));
    		saveScreenInit(mainWindow);
        } catch (IOException io) {
            io.printStackTrace();
        }
	}
	
	//Function to draw the directory screen needed to get the save path from the user
	public void getSaveDirPath(Stage mainWindow, StackPane layout) {
		Button directorySelect = new Button("Select Directory");
		layout.getChildren().add(directorySelect);
		
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home") + "\\Documents"));	

	    directorySelect.setOnAction(e -> {
	        File selectedDirectory = directoryChooser.showDialog(mainWindow);
	        if (selectedDirectory != null) {
	        	saveFilePath = selectedDirectory.getAbsolutePath();
	        	saveProperties(mainWindow, layout);
	        }
	    });	
	    clearLayout(layout);
	}
	
	//Function to push properties to the config file
	public void saveProperties(Stage mainWindow, StackPane layout) {
        try (OutputStream output = new FileOutputStream("../config.properties")) {
            Properties prop = new Properties();
            prop.setProperty("SaveFilePath", saveFilePath);
            prop.store(output, null);
            output.close();
    		if (saveFilePath.equals("")) {
    			getSaveDirPath(mainWindow, layout);
    		} else {
    			saveScreenInit(mainWindow);
    		}
        } catch (IOException io) {
            io.printStackTrace();
        }
	}
	
	//Function to read in the config properties file given the location path
	public void readProperties(String configPath) {
		try(InputStream configInStream = new FileInputStream(configPath)) {
			Properties config = new Properties();
			config.load(configInStream);
			saveFilePath = config.getProperty("SaveFilePath");
			configInStream.close();
		} catch (IOException io) {
            io.printStackTrace();
        }
	}
	
	//Function to create and load in the default empty value for the config properties file
	public void createConfigProperties() {
        try (OutputStream output = new FileOutputStream("../config.properties")) {
            Properties prop = new Properties();
            prop.setProperty("SaveFilePath", "");
            prop.store(output, null);
            output.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
	}	
	
	//Function to create save file folder
	public boolean createSaveFileFolder(String path) {
		File saveFolder = new File(path);
		return saveFolder.mkdir();
	}
	
	//Function returns T/F value of whether the given path is a file and it exists
	public boolean fileExists(String Path) {
		File file = new File(Path);
		if (file.exists() && file.isFile()) {
			return true;
		}
		return false;
	}
	
	//Function returns T/F value of whether the given path is a directory and exists
	public boolean folderExists(String Path) {
		File file = new File(Path);
		if (file.isDirectory()) {
			return true;
		}
		return false;
	}
	
	//Small function to make it easier to read when clearing a layout for scene change
	public void clearLayout(StackPane layout) {
		layout.getChildren().removeAll();
	}	
}
