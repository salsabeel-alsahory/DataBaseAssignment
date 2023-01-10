import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdvisorView<T> extends VBox {
	TableView tableview = new TableView();
	Connection con;
	Statement statement;
	ResultSet resultSet;


	public void connectDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "");
	}

	public AdvisorView() throws ClassNotFoundException, SQLException {
		connectDB();
		
		
		Label label1 = new Label("STUDENT ID");
		TextField textF1 = new TextField();

		HBox hb1 = new HBox(label1, textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		// ------------------------------------------
		
		// ------------------------------------------

		Label label2 = new Label("INSTRUCTOR ID");
		TextField textF2 = new TextField();

		HBox hb2 = new HBox(label2, textF2);
		this.getChildren().addAll(hb2);
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.CENTER);
		// ------------------------------------------
		// ------------------------------------------

		Button insertbutton1 = new Button("INSERT");
		Button searchbutton2 = new Button("SEARCH");
		Button button3 = new Button("DELETE");

		insertbutton1.setAlignment(Pos.BASELINE_RIGHT);
		searchbutton2.setAlignment(Pos.CENTER);
		button3.setAlignment(Pos.BASELINE_LEFT);

		HBox hb3 = new HBox(insertbutton1, searchbutton2, button3);
		this.getChildren().add(hb3);
		this.getChildren().add(tableview);
		hb3.setSpacing(10);

		// ------------------Programming the buttons -------------------------------

		insertbutton1.setOnAction(e -> {
			
			String instID = textF2.getText();
			String studentID = textF1.getText();
			
			if (instID instanceof String) {
//				if(instID.equals(e)) {
			
//			}
		
			try {
		    String check =  "SELECT count(*) FROM advisor WHERE s_ID =? '"+instID+"'"+ "and i_ID = ?'"+studentID+"'" ;
		  
		    java.sql.PreparedStatement statement = con.prepareStatement(check);
		    //A prepared statement or a parameterized statement 
		    //is used to execute the same statement repeatedly with high efficiency.
		    statement.setString(1, studentID);
		    statement.setString(2, instID);
		    ResultSet result = statement.executeQuery();
		    int count = 0;
		    while(result.next()) {
		        count = result.getInt(1);
		    }
		    if (count > 0) {
		        System.out.println("Record exists in advisor table");
		    } else {
		    	
		        System.out.println("Record doesn't exist in advisor table");
		    	String qu = "insert into student values(" + studentID + ",'" + instID + ")";
				System.out.println(qu);
		    }
		} catch (SQLException s) {
		    s.printStackTrace();
		}
			}
		});

		searchbutton2.setOnAction(e -> {
			String qu = "select * from advisor";
			ResultSet result = null;
			String instID = textF2.getText();
			String studentID = textF1.getText();
			if (!studentID.isEmpty()) {
				qu = "select * from advisor where s_ID ='" + studentID+"'";
			}
			if (!instID.isEmpty()) {
				qu = "select * from advisor where i_ID ='" + instID+"'";
			}
			if (!studentID.isEmpty() && !instID.isEmpty()) {
				qu = "select * from advisor where s_ID ='" + studentID +"' and i_ID ='" + instID+"'";
			}
			
			else {
				System.out.println("Pleas enter exists data !!");
			}

			System.out.println(qu);
			fillTable(qu);
		});

	}
//
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
       /**********************************
        * TABLE COLUMN ADDED DYNAMICALLY *
        **********************************/
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

       /********************************
        * Data added to ObservableList *
        ********************************/
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