package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ResultController implements Initializable{

    @FXML
    private ImageView backpattren;
    @FXML
    private Text TheResult; 
	
    static FadeTransition Result;
    static FadeTransition Weclome;
	public static void StartTranstion(){
	Result=new FadeTransition(Duration.millis(300), Main.Result);
	Result.setFromValue(1);
	Result.setToValue(0);
	
	Result.setOnFinished(e->{
	Main.WelcomePane.setTranslateX(0);
    Main.WelcomePane.setLayoutX(0);
	Main.AfterWelcome.setLayoutX(Main.WIDTH);
	Main.TheGame.setLayoutX(Main.WIDTH);
	Main.Result.setLayoutX(Main.WIDTH);
	TheGameController.PIVOT=1;
	TheGameController.Bits=0;
	TheGameController.BinaryResult="";
	
	});
	
	Weclome=new FadeTransition(Duration.millis(800), Main.WelcomePane);
	Weclome.setFromValue(0);
	Weclome.setToValue(1);
	
	Weclome.setOnFinished(e->{
    	Main.Result.setTranslateX(0);
    	Main.Result.setLayoutX(Main.WIDTH);
    	Main.Result.setOpacity(1);
	});
		
	SequentialTransition st=new SequentialTransition(Result,Weclome);
	st.setInterpolator(Interpolator.EASE_BOTH);
	st.play();
    } 
    
   @FXML
   public void Exit(MouseEvent e) {
	   Main.scene.getWindow().setOpacity(0);
	   System.exit(0); 
   }
   
   @FXML
   public void Restart(MouseEvent e) {
   StartTranstion();
   AfterWelcomeController.Value.set(AfterWelcomeController.Value.get()+1); 
   }
    
   @FXML
   public void Information(MouseEvent e) {
	   
	   
   }
   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TheGameController.BR.addListener(e->{
		TheResult.setText(TheGameController.BR.get()+"");
		});
	
		ScaleTransition s=new ScaleTransition(Duration.millis(800), TheResult);
		s.setInterpolator(Interpolator.EASE_BOTH);
		s.setFromX(1);
		s.setToX(0.8);
		s.setFromY(1);
		s.setToY(0.8);
		s.setCycleCount(ScaleTransition.INDEFINITE);
		s.setAutoReverse(true);
		s.play();
	}
	
	
	

}
