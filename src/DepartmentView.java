import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DepartmentView extends VBox{
	String[] departmentName;
	String building;
	Double budget;
public DepartmentView() throws SQLException, ClassNotFoundException {
	Label label1 = new Label("DEPARTMENT:");
	ComboBox  co = new ComboBox ();
	
	HBox hb1 = new HBox(label1,co);
	this.getChildren().addAll(hb1);
	hb1.setSpacing(10);
	hb1.setAlignment(Pos.CENTER);
	
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/lab7","root",""); 
	
    //-----------------------------------------------------------------
	
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select dept_name from department");  
	while(rs.next())  {
		co.getItems().add(rs.getString(1));
	}
	
	
	
	
	
	
	
	
	Label label2 = new Label("BUILDING");
	TextField textF2 = new TextField ();

	HBox hb2 = new HBox(label2,textF2);
	this.getChildren().addAll(hb2);
	hb2.setSpacing(10);
	hb2.setAlignment(Pos.CENTER);
	
	
	Label label3 = new Label("BUDGET");
	TextField textF3 = new TextField ();

	HBox hb3 = new HBox(label3,textF3);
	this.getChildren().addAll(hb3);
	hb3.setSpacing(10);
	hb3.setAlignment(Pos.CENTER);
	
	Button button1 =new Button("INSERT");
	Button button2 =new Button("SEARCH");
	
	button1.setAlignment(Pos.BASELINE_RIGHT);
	button2.setAlignment(Pos.CENTER);
	
	HBox hb6 =new HBox(button1,button2);
	this.getChildren().add(hb6);
	hb6.setSpacing(10);
}
public String[] getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String[] departmentName) {
	this.departmentName = departmentName;
}
public String getBuilding() {
	return building;
}
public void setBuilding(String building) {
	this.building = building;
}
public Double getBudget() {
	return budget;
}
public void setBudget(Double budget) {
	this.budget = budget;
}

}
