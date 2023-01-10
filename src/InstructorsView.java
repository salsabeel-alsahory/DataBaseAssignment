import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InstructorsView extends VBox {

	char IDIns;
	String name;
	String dept_name;
	Double salary;
    GridPane viewsPane = new GridPane();
    VBox vb = new VBox();
	
	public InstructorsView() {

		vb.setSpacing(20);
		Label label1 = new Label("ID:");
		TextField textF1 = new TextField ();
		HBox hb1 =new HBox(label1,textF1);
		hb1.setSpacing(20);
		hb1.setAlignment(Pos.CENTER);
		
		Label label2 = new Label("NAME");
		TextField textF2 = new TextField ();
		HBox hb2 = new HBox(label2,textF2);
		hb2.setSpacing(20);
		hb2.setAlignment(Pos.CENTER);
		
		Label label3 = new Label("DEPARTMENT:");
		ComboBox  co = new ComboBox ();
		HBox hb3 = new HBox(label3,co);
		hb3.setSpacing(20);
		hb3.setAlignment(Pos.CENTER);
		
		Label label4 = new Label("SALARY");
		TextField textF4 = new TextField ();
		HBox hb4 = new HBox(label4,textF4);
		hb4.setSpacing(20);
		hb4.setAlignment(Pos.CENTER);
		
		Button button1 =new Button("INSERT");
		Button button2 =new Button("SEARCH");
		
		button1.setAlignment(Pos.BASELINE_RIGHT);
		button2.setAlignment(Pos.CENTER);
		
		HBox hb6 =new HBox(button1,button2);
		this.getChildren().add(hb6);
		hb6.setSpacing(10);
		
	    vb.getChildren().addAll( viewsPane);
	    vb.setSpacing(20);
	    
	}



	
	
}
