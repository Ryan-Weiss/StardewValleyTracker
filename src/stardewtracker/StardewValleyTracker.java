package stardewtracker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StardewValleyTracker extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainWindow) throws Exception {
		mainWindow.setTitle("Hello Window!");
		
		Button firstButton = new Button();
		firstButton.setText("Clickable");
		
		StackPane layout = new StackPane();
		layout.getChildren().add(firstButton);
		
		Scene sampleScene = new Scene(layout, 300, 250);
		mainWindow.setScene(sampleScene);
		mainWindow.show();
	}	
	
}
