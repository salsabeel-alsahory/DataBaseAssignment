import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CourseView extends VBox{
	int courseID;
	String title;
	String dept_name;
	int credit;
	
	public CourseView() {
		
		
		Label label1 = new Label("COURSE_ID:");
		TextField textF1 = new TextField ();
		
		HBox hb1 = new HBox(label1,textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		
		Label label2 = new Label("TITLE");
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
		
		Label label4 = new Label("DEPT_NAME");
		TextField textF4 = new TextField ();
		HBox hb4 = new HBox(label4,textF4);
		this.getChildren().addAll(hb4);
		hb4.setSpacing(10);
		hb4.setAlignment(Pos.CENTER);
		
		
		Label label5 = new Label("CREDITS");
		TextField textF5 = new TextField ();
		HBox hb5 = new HBox(label5,textF5);
		this.getChildren().addAll(hb5);
		hb5.setSpacing(10);
		hb5.setAlignment(Pos.CENTER);
		
		Button button1 =new Button("INSERT");
		Button button2 =new Button("SEARCH");
		
		button1.setAlignment(Pos.BASELINE_RIGHT);
		button2.setAlignment(Pos.CENTER);
		
		HBox hb6 =new HBox(button1,button2);
		this.getChildren().add(hb6);
		hb6.setSpacing(10);
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
}
