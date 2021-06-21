package Tanmayi;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class myMain2 extends Application {
	public static void main(String[] args){ //optional method
		System.out.println("main");
		launch(args);

	}

	@Override
	public void init() throws Exception {
		System.out.println("init"); //Initialize your application
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");//Starts an application
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		//MenuBar menuBar = createMenu();
		//rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
	//primaryStage.setResizable(false);If you want to fix the size of your application
		primaryStage.show();
	}
	private MenuBar createMenu(){

		//File menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {Platform.exit(); System.exit(0);});

		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		//Help menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);


		//Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu , helpMenu);
		return menuBar;


	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.ERROR);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner but soon I will be pro and start developing awesome Java Games");
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn , noBtn);
		Optional<ButtonType>clickedBtn = alertDialog.showAndWait();
		if (clickedBtn.isPresent() && clickedBtn.get()==yesBtn) System.out.println("Yes Button CLICKED!!");
		else{
			System.out.println("No Button Clicked!!");
		}

	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");//Called when application is stopped and is about to shut down
		super.stop();
	}
}
