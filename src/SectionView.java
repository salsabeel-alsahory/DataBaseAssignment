import java.sql.Date;
import java.sql.Time;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SectionView extends VBox{
   
	int cours_id;
	int sec_id;
	String semester;
	Date year;
	int room_num;
	Time time_slot;
	

	public SectionView() {
		Label label1 = new Label("COURS_ID:");
		TextField textF1 = new TextField ();
		
		HBox hb1 = new HBox(label1,textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		
		Label label2 = new Label("SEC_ID");
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
		
		Label label5 = new Label("BUILDING");
		TextField textF5 = new TextField ();
		HBox hb5 = new HBox(label5,textF5);
		this.getChildren().addAll(hb5);
		hb5.setSpacing(10);
		hb5.setAlignment(Pos.CENTER);
		
		Label label6 = new Label("ROOM_NUMBER");
		TextField textF6 = new TextField ();
		HBox hb6 = new HBox(label6,textF6);
		this.getChildren().addAll(hb6);
		hb6.setSpacing(10);
		hb6.setAlignment(Pos.CENTER);
		
		Label label7 = new Label("TIME_SLOT_ID");
		TextField textF7 = new TextField ();
		HBox hb7 = new HBox(label7,textF7);
		this.getChildren().addAll(hb7);
		hb7.setSpacing(10);
		hb7.setAlignment(Pos.CENTER);
		
		Button button1 =new Button("INSERT");
		Button button2 =new Button("SEARCH");
		
		button1.setAlignment(Pos.BASELINE_RIGHT);
		button2.setAlignment(Pos.CENTER);
		
		HBox hb8 =new HBox(button1,button2);
		this.getChildren().add(hb8);
		hb8.setSpacing(10);
	}


	public int getCours_id() {
		return cours_id;
	}


	public void setCours_id(int cours_id) {
		this.cours_id = cours_id;
	}


	public int getSec_id() {
		return sec_id;
	}


	public void setSec_id(int sec_id) {
		this.sec_id = sec_id;
	}


	public String getSemester() {
		return semester;
	}


	public void setSemester(String semester) {
		this.semester = semester;
	}


	public Date getYear() {
		return year;
	}


	public void setYear(Date year) {
		this.year = year;
	}


	public int getRoom_num() {
		return room_num;
	}


	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}


	public Time getTime_slot() {
		return time_slot;
	}


	public void setTime_slot(Time time_slot) {
		this.time_slot = time_slot;
	}
	
}
