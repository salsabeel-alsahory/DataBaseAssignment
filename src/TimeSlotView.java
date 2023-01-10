import java.sql.Time;
import java.time.DayOfWeek;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TimeSlotView extends VBox{
	Time time;
	DayOfWeek day;
	Time sHour;
	Time eHour;
	Time sMinuts;
	Time eMinuts;
	
public TimeSlotView() {
	
	Button button1 =new Button("INSER");
	Button button2 =new Button("SEARCH");
	Button button3 = new Button("DELET");
	HBox hb7 = new HBox(button1,button2,button3);
	hb7.setSpacing(10);
	hb7.setAlignment(Pos.CENTER);
	
	
	Label label1 = new Label("TIME_SOLT_ID");
	TextField textF1 = new TextField ();

	HBox hb1 = new HBox(label1,textF1);
	this.getChildren().addAll(hb1);
	hb1.setSpacing(10);
	hb1.setAlignment(Pos.CENTER);
	
	Label label2 = new Label("DAY");
	TextField textF2 = new TextField ();

	HBox hb2 = new HBox(label2,textF2);
	this.getChildren().addAll(hb2);
	hb2.setSpacing(10);
	hb2.setAlignment(Pos.CENTER);
	
	Label label3 = new Label("START_HR");
	TextField textF3 = new TextField ();

	HBox hb3 = new HBox(label3,textF3);
	this.getChildren().addAll(hb3);
	hb3.setSpacing(10);
	hb3.setAlignment(Pos.CENTER);
	
	
	Label label4 = new Label("START_MIN");
	TextField textF4 = new TextField ();

	HBox hb4 = new HBox(label4,textF4);
	this.getChildren().addAll(hb4);
	hb4.setSpacing(10);
	hb4.setAlignment(Pos.CENTER);
	
	Label label5 = new Label("END_HR");
	TextField textF5 = new TextField ();
	HBox hb5 = new HBox(label5,textF5);
	this.getChildren().addAll(hb5);
	hb5.setSpacing(10);
	hb5.setAlignment(Pos.CENTER);
	
	Label label6 = new Label("END_MIN");
	TextField textF6 = new TextField ();
	HBox hb6 = new HBox(label6,textF6);
	this.getChildren().addAll(hb6);
	hb6.setSpacing(10);
	hb6.setAlignment(Pos.CENTER);
}

public Time getTime() {
	return time;
}

public void setTime(Time time) {
	this.time = time;
}

public DayOfWeek getDay() {
	return day;
}

public void setDay(DayOfWeek day) {
	this.day = day;
}

public Time getsHour() {
	return sHour;
}

public void setsHour(Time sHour) {
	this.sHour = sHour;
}

public Time geteHour() {
	return eHour;
}

public void seteHour(Time eHour) {
	this.eHour = eHour;
}

public Time getsMinuts() {
	return sMinuts;
}

public void setsMinuts(Time sMinuts) {
	this.sMinuts = sMinuts;
}

public Time geteMinuts() {
	return eMinuts;
}

public void seteMinuts(Time eMinuts) {
	this.eMinuts = eMinuts;
}

}
