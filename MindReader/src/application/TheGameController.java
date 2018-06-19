package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TheGameController implements Initializable {
    @FXML
    private Button yes;

    @FXML
    private Button no;

    @FXML
    public  Text NumberArea;
    public static int PIVOT=1;
    public static int Bits=0;
    public static String BinaryResult="";
    static SimpleIntegerProperty BR=new SimpleIntegerProperty(0);
	
    public static int ReverseBinary(String x){
		x=new StringBuilder(x).reverse().toString();
		int Value=Integer.parseInt(x);
		int Counter=0;
		int Result = 0;
		int R=0;
		
		while(Value>0){
		R=Value%10;
		//Result +=2^Position*digit
		Result+=(int) (Math.pow(2, Counter)*R);
		Value=Value/10;
		Counter++;
		}
		return Result;
	}
	
	public int Length(int x) {
		return String.valueOf(x).length();
	}
	
	
	
	public void MindReaderFunc(int PIVOT,int Bits){
		//64=2^NumberofBits
		PIVOT=this.PIVOT;
		if(PIVOT>=(Bits+2))
		return;

		int Value=PIVOT;
		String Texte="";
		while(Value<=Bits){
			for(int i=1;i<=PIVOT;i++){
			if(Length(Value)==1)	
			Texte+="00"+Value+" ";
			else if(Length(Value)==2)
			Texte+="0"+Value+" ";	
			else 
			Texte+=Value+" ";		
			Value++;
			}
			Value+=PIVOT;
		}
		NumberArea.setText(Texte);
	    //if == 1 then add 1 to thestring else add 0
		
	}
	static TranslateTransition TheGame;
    static TranslateTransition Result;
	public static void StartTranstion(){
		Main.TheGame.setLayoutX(0);
		TheGame=new TranslateTransition(Duration.millis(300), Main.TheGame);
		TheGame.setInterpolator(Interpolator.EASE_OUT);
		TheGame.setFromX(0);
		TheGame.setToX(-Main.WIDTH);
		TheGame.play();
    	
		Result=new TranslateTransition(Duration.millis(300), Main.Result);
		Result.setInterpolator(Interpolator.EASE_OUT);
		Result.setFromX(0);
		Result.setToX(-Main.WIDTH);
		Result.play();
		
		
		Result.setOnFinished(e->{
			Main.Result.setTranslateX(0);
        	Main.Result.setLayoutX(0);
        	Main.TheGame.setTranslateX(0);
        	Main.TheGame.setLayoutX(-Main.WIDTH);
  
		});

    }
	
	
	public void AnimateNumbers(){
		yes.setMouseTransparent(true);
		no.setMouseTransparent(true);
		FadeTransition ft=new FadeTransition(Duration.millis(150), NumberArea);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		ft.setOnFinished(e->{
			yes.setMouseTransparent(!true);
			no.setMouseTransparent(!true);
		});
	}
	
    
    @FXML
    void NoClicked(MouseEvent event) {
    	if(Bits<AfterWelcomeController.Bits.get()) {
    	MindReaderFunc(PIVOT=PIVOT*2, (int) AfterWelcomeController.Value.get());
    	Bits++;
    	BinaryResult+="0";
    	}
    	//On Finish Do :
    	if(Bits>=AfterWelcomeController.Bits.get()) {
    	StartTranstion();
    	BR.set(ReverseBinary(BinaryResult));
    	}
    	AnimateNumbers();
    	
    	
    }

    @FXML
    void YesClicked(MouseEvent event) {
    	if(Bits<AfterWelcomeController.Bits.get()) {
        MindReaderFunc(PIVOT=PIVOT*2, (int) AfterWelcomeController.Value.get());
        Bits++;
        BinaryResult+="1";
        }
    	//On Finish Do :
    	if(Bits>=AfterWelcomeController.Bits.get()) {
        StartTranstion();
        BR.set(ReverseBinary(BinaryResult));
    	}
    	AnimateNumbers();
    }
   
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AfterWelcomeController.Value.addListener(e->{
		MindReaderFunc(1,(int) AfterWelcomeController.Value.get());
		});
		
	}
}
