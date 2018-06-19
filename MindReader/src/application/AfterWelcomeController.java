package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

	public class AfterWelcomeController implements Initializable{

	    @FXML
	    private Button start;

	    @FXML
	    private Text ValueChoosen;

	    @FXML
	    private Button Exit;

	    

	    static  SimpleDoubleProperty Value=new SimpleDoubleProperty(0);
	    static SimpleIntegerProperty Bits=new SimpleIntegerProperty(0);
	    static TranslateTransition AfterWelcome;
	    static TranslateTransition TheGame;
	    public static void StartTranstion(){
	    	AfterWelcome=new TranslateTransition(Duration.millis(300), Main.AfterWelcome);
	    	AfterWelcome.setInterpolator(Interpolator.EASE_IN);
	    	AfterWelcome.setFromX(0);
	    	AfterWelcome.setToX(-Main.WIDTH);
	    	AfterWelcome.play();
	    	
	    	TheGame=new TranslateTransition(Duration.millis(300), Main.TheGame);
	    	TheGame.setInterpolator(Interpolator.EASE_IN);
	    	TheGame.setFromX(0);
	    	TheGame.setToX(-Main.WIDTH);
	    	TheGame.play();
	    
	    	TheGame.setOnFinished(e->{
	    		Main.TheGame.setTranslateX(0);
	        	Main.TheGame.setLayoutX(0);
	        	Main.AfterWelcome.setTranslateX(0);
	        	Main.AfterWelcome.setLayoutX(-Main.WIDTH);
	    	});

	    }

	@FXML
	public void Exit(MouseEvent e) {
		Main.scene.getWindow().setOpacity(0);
		System.exit(0);
	}
	

    @FXML
    void Play(MouseEvent event) {
    	StartTranstion();
    	
    }
    
    

	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Value.addListener(e->{
		ValueChoosen.setText(String.valueOf((int)Value.get()));
		});
	}

}
