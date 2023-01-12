import java.sql.Date;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TeachesView extends VBox{
//	int secID;
//	int courseID;
//	String semester;
//	Date year;
public TeachesView(){
	Label label1 = new Label("SEC_ID:");
	TextField textF1 = new TextField ();
	
	HBox hb1 = new HBox(label1,textF1);
	this.getChildren().addAll(hb1);
	hb1.setSpacing(10);
	hb1.setAlignment(Pos.CENTER);
	
	Label label2 = new Label("COURSE_ID");
	TextField textF2 = new TextField ();

	HBox hb2 = new HBox(label2,textF2);
	this.getChildren().addAll(hb2);
	hb2.setSpacing(10);
	hb2.setAlignment(Pos.CENTER);
	

	
	Label label3 = new Label("SEMESTER:");
	TextField textF3 = new TextField ();
	HBox hb3 = new HBox(label3,textF3);
	this.getChildren().addAll(hb3);
	hb3.setSpacing(10);
	hb3.setAlignment(Pos.CENTER);
	
	Label label4 = new Label("YEAR");
	TextField textF4 = new TextField ();
	HBox hb4 = new HBox(label4,textF4);
	this.getChildren().addAll(hb4);
	hb4.setSpacing(10);
	hb4.setAlignment(Pos.CENTER);
	
	
}


}
