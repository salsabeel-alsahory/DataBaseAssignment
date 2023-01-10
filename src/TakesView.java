import java.sql.Date;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TakesView extends VBox{
	int taskID;
	int courseID;
	String Semester;
	Date Year;
	Double Grade;
	
	public TakesView() {
		Label label1 = new Label("TASK_ID:");
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
		

		
		Label label6 = new Label("GRADE");
		TextField textF6 = new TextField ();
		HBox hb6 = new HBox(label6,textF6);
		this.getChildren().addAll(hb6);
		hb6.setSpacing(10);
		hb6.setAlignment(Pos.CENTER);
		
		Button button1 =new Button("INSER");
		Button button2 =new Button("SEARCH");
		Button button3 = new Button("DELET");
		HBox hb7 = new HBox(button1,button2,button3);
		hb7.setSpacing(10);
		hb7.setAlignment(Pos.CENTER);
		
	
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public Date getYear() {
		return Year;
	}

	public void setYear(Date year) {
		Year = year;
	}

	public Double getGrade() {
		return Grade;
	}

	public void setGrade(Double grade) {
		Grade = grade;
	}

	
}
