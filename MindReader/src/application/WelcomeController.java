package application;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class WelcomeController implements Initializable {

	public ToggleGroup TheGroup;	
    @FXML
    private Button next;

    @FXML
    private ImageView logo;

    @FXML
    public RadioButton firstradio;

    @FXML
    private RadioButton secondradio;

    @FXML
    private RadioButton thirdradio;

    @FXML
    private RadioButton fordradio;
    
    @FXML
    private ImageView backpattren;
    static TranslateTransition Welcome;
    static TranslateTransition AfterWelcome;
    
    public static void StartTranstion(){
    	Welcome=new TranslateTransition(Duration.millis(300), Main.WelcomePane);
    	Welcome.setInterpolator(Interpolator.EASE_OUT);
    	Welcome.setFromX(0);
    	Welcome.setToX(-Main.WIDTH);
    	Welcome.play();
    	
    	AfterWelcome=new TranslateTransition(Duration.millis(300), Main.AfterWelcome);
    	AfterWelcome.setInterpolator(Interpolator.EASE_OUT);
    	AfterWelcome.setFromX(0);
    	AfterWelcome.setToX(-Main.WIDTH);
    	AfterWelcome.play();
    	AfterWelcome.setOnFinished(e->{
    	Main.AfterWelcome.setTranslateX(0);
    	Main.AfterWelcome.setLayoutX(0);
    	Main.WelcomePane.setTranslateX(0);
    	Main.WelcomePane.setLayoutX(-Main.WIDTH);
    	
    	});

    }
    

	
    public void NextClicked(MouseEvent e) {
    	
    		if(TheGroup.getSelectedToggle().equals(firstradio)) {
    		AfterWelcomeController.Value.set(63);
    		AfterWelcomeController.Bits.set(6);
    		}
    		
    		else if(TheGroup.getSelectedToggle().equals(secondradio)) {
    		AfterWelcomeController.Value.set(127);
    		AfterWelcomeController.Bits.set(7);
    		}
    		else if(TheGroup.getSelectedToggle().equals(thirdradio)) {
    		AfterWelcomeController.Value.set(255);
    		AfterWelcomeController.Bits.set(8);
    		}
    		else {
    		AfterWelcomeController.Value.set(511);
    		AfterWelcomeController.Bits.set(9);
    		}

    		StartTranstion();
    	
    		
    	
    
 
    	
    	
    }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TheGroup=new ToggleGroup();
		TheGroup.getToggles().addAll(firstradio,secondradio,thirdradio,fordradio);
		TheGroup.selectToggle(firstradio);
	}


	
}
