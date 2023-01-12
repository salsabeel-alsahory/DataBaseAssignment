import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrereqView extends VBox{
	
	int CourseID;
	int prereqID;
	
	
	public PrereqView() {
		Label label1 = new Label("COURSE_ID:");
		TextField textF1 = new TextField();
		HBox hb1 = new HBox(label1,textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		
		Label label2 = new Label("PREREQ_ID");
		TextField textF2 = new TextField();

		HBox hb2 = new HBox(label2,textF2);
		hb2.setAlignment(Pos.CENTER);
		this.getChildren().addAll(hb2);
		hb2.setSpacing(10);
		
		Button button1 =new Button("INSERT");
		Button button2 =new Button("SEARCH");
		
		button1.setAlignment(Pos.BASELINE_RIGHT);
		button2.setAlignment(Pos.CENTER);
		
		HBox hb6 =new HBox(button1,button2);
		this.getChildren().add(hb6);
		hb6.setSpacing(10);
	}


	public int getCourseID() {
		return CourseID;
	}


	public void setCourseID(int courseID) {
		CourseID = courseID;
	}


	public int getPrereqID() {
		return prereqID;
	}


	public void setPrereqID(int prereqID) {
		this.prereqID = prereqID;
	}


	
}
