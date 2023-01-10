import java.sql.ResultSet;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ClassRoomVIew extends VBox{
	String building;
	String room_number;
	String capacity;
	
	public ClassRoomVIew() {
		Label label1 = new Label("BUILDING");
		TextField textF1 = new TextField ();
      this.building=textF1.getText();
		
		HBox hb1 = new HBox(label1,textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		
		Label label2 = new Label("ROOM_NUM");
		TextField textF2 = new TextField ();
        this.room_number=textF2.getText();
		
		HBox hb2 = new HBox(label2,textF2);
		this.getChildren().addAll(hb2);
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.CENTER);
		
		
		Label label3 = new Label("CAPACITY");
		TextField textF3 = new TextField ();
        this.capacity=textF3.getText();
		
		HBox hb3 = new HBox(label3,textF3);
		this.getChildren().addAll(hb3);
		hb3.setSpacing(10);
		hb3.setAlignment(Pos.CENTER);
		
		Button button1 =new Button("INSERT");
		Button button2 =new Button("SEARCH");
		
		button1.setAlignment(Pos.BASELINE_RIGHT);
		button2.setAlignment(Pos.CENTER);
		
		HBox hb4 =new HBox(button1,button2);
		this.getChildren().add(hb4);
		hb4.setSpacing(10);
		
		button2.setOnAction(e->{
			String query="select * from classroom ";
			  
			  
			  if(!building.isEmpty() || !room_number.isEmpty() || !capacity.isEmpty()) {
				  query+= "where ";
				  
				  if (!building.isEmpty())
					  query+= "building = '" + building+ "' AND";
				  if (!room_number.isEmpty())
					  query+= " room_number = " + room_number+ " AND";
				  if (!capacity.isEmpty())
					  query+= " capacity = " + capacity;
				  
			  }

			  
			  if(query.endsWith("AND")) {
				  query = query.substring(0,query.lastIndexOf(" "));
			  }
			  System.out.println(query);
			  
//			  try {
//				  ResultSet rs = stmt.executeQuery(SQL);
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		});
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoomNum() {
		return room_number;
	}
	public void setRoomNum(String roomNum) {
		room_number = roomNum;
	}
//	public Double getCapacity() {
//		return capacity;
//	}
//	public void setCapacity(Double capacity) {
//		this.capacity = capacity;
//	}
	

}
