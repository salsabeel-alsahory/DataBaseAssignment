import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class CourseView extends VBox{
	TableView tableview = new TableView();
	Connection con;
	Statement statement;
	ResultSet resultSet;
	
	public void connectDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "");
	}
	
	public CourseView() throws ClassNotFoundException, SQLException {
		connectDB();
		
		Label label1 = new Label("COURSE_ID:");
		TextField textF1 = new TextField ();
		
		Label label2 = new Label("TITLE");
		TextField textF2 = new TextField ();
		
		HBox hb1 = new HBox(label1,textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.BASELINE_LEFT);
		
		

		HBox hb2 = new HBox(label2,textF2);
		this.getChildren().addAll(hb2);
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.BASELINE_LEFT);
		

		
	

		Label label4 = new Label("D_NAME");
		TextField textF4 = new TextField ();
		
//		HBox hb3 = new HBox(label3,textF3);
//		this.getChildren().addAll(hb3);
//		hb3.setSpacing(10);
//		hb3.setAlignment(Pos.BASELINE_LEFT);
//		
		
		HBox hb4 = new HBox(label4,textF4);
		this.getChildren().addAll(hb4);
		hb4.setSpacing(10);
		hb4.setAlignment(Pos.BASELINE_LEFT);
		
		
		Label label5 = new Label("CREDITS");
		TextField textF5 = new TextField ();
		HBox hb5 = new HBox(label5,textF5);
		this.getChildren().addAll(hb5);
		hb5.setSpacing(10);
		hb5.setAlignment(Pos.BASELINE_LEFT);
		
		Button button1 =new Button("INSERT");
		Button button2 =new Button("SEARCH");
		
		button1.setAlignment(Pos.BASELINE_RIGHT);
		button2.setAlignment(Pos.CENTER);
		
		HBox hb6 =new HBox(button1,button2);
		this.getChildren().add(hb6);
		hb6.setSpacing(10);
		
		this.getChildren().add(tableview);
		tableview.setMinSize(700, 500);
		
		button1.setOnAction(e->{
			String sID = textF1.getText();
			String tittle =textF2.getText();
		
			String dN =textF4.getText();

			try {
				String qu = "insert into course  values('" + sID + "','"
			                                               +  tittle +"','"
					                                       +  dN +")";
				  System.out.println(qu);
				  statement.executeUpdate(qu);
	    		  
	    	  }catch(SQLException e1) {
	    		  e1.printStackTrace();
	    	  }
		});
		
		button2.setOnAction(e->{
			String query="select * from course ";
		
			String sID = textF1.getText();
			String tittle =textF2.getText();
		
			String dN =textF4.getText();
			
			System.out.println(query);
			fillTable(query);
			 if(!sID.isEmpty() || !tittle.isEmpty() || !dN .isEmpty()) {
				  query+= "where ";
				  
				  if (!sID.isEmpty()) {
					  query+= "building = '" + sID+ "' AND";
				  }
				  if (!tittle.isEmpty()) {
					  query+= " room_number = " + tittle+ " AND";
				  }
					  
				  if (!dN.isEmpty()) {
					  query+= " capacity = " + dN;
				  
			  }

			  
			  if(query.endsWith("AND")) {
				  query = query.substring(0,query.lastIndexOf(" "));
			  }
			
			  try {
				  resultSet = statement.executeQuery(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 }
			 
			  System.out.println(query);
				fillTable(query);
		});
		
	}

	public void fillTable(String q) {
		// --------------------------
		ObservableList<Object> data = FXCollections.observableArrayList();
		// is a list that can be observed for changes
		// and is commonly used in JavaFX to store data for display in a UI control such
		// as a table view.
        //----------------------------------

		try {
		 String SQL = q;
		 Statement stmt=( Statement)con.createStatement();
		 
		ResultSet rs = stmt.executeQuery(SQL);
				tableview.getItems().clear();
				tableview.getColumns().clear();
       /************
        * TABLE COLUMN ADDED DYNAMICALLY *
        ************/
       for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
           //We are using non property style for making dynamic table
           final int j = i;                
           TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
           col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
					return new SimpleStringProperty(param.getValue().get(j).toString());
				}
			});
          
           tableview.getColumns().addAll(col); 
           System.out.println("Column ["+i+"] ");
       }

       /************
        * Data added to ObservableList *
        ************/
       while(rs.next()){
           //Iterate Row
           ObservableList<String> row = FXCollections.observableArrayList();
           for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
               //Iterate Column
               row.add(rs.getString(i));
           }
           System.out.println("Row [1] added "+row );
           data.add(row);

       }

       //FINALLY ADDED TO TableView
       tableview.setItems(data);
     }catch(Exception e){
         e.printStackTrace();
         System.out.println("Error on Building Data");             
     }

	}

}
