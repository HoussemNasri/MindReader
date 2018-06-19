package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	public static Group root;
	public static AnchorPane WelcomePane;
	public static AnchorPane AfterWelcome;
	public static AnchorPane TheGame;
	public static AnchorPane Result;
	public static final int WIDTH=700;
	public static final int HEIGHT=500;
	public static Scene scene;
	@Override
	public void start(Stage primaryStage) throws IOException {
	        WelcomePane=FXMLLoader.load(getClass().getResource("Welcome.fxml"));
	        AfterWelcome=FXMLLoader.load(getClass().getResource("AfterWelcome.fxml"));
	        TheGame=FXMLLoader.load(getClass().getResource("TheGame.fxml"));
	        TheGame.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        AfterWelcome.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        Result=FXMLLoader.load(getClass().getResource("Result.fxml"));
	        
			root=new Group();
			root.getChildren().add(Result);
			root.getChildren().add(TheGame);
			root.getChildren().add(AfterWelcome);
			root.getChildren().add(WelcomePane);
			
			AfterWelcome.setLayoutX(WIDTH);
			TheGame.setLayoutX(WIDTH);
			Result.setLayoutX(WIDTH);
		
			scene = new Scene(root);
			scene.setFill(Color.web("#37245b"));
			primaryStage.setMaxHeight(539);
			primaryStage.setMaxWidth(710);
			primaryStage.setMinHeight(539);
			primaryStage.setMinWidth(710);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
