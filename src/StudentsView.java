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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class StudentsView<T> extends VBox {
    
//	int StudentID;
//	String name;
//	String dept;

	TableView tableview = new TableView();
	static Connection con;
	static ResultSet resultSet;
	static 	Statement stmt;
	
	public StudentsView() throws SQLException{
	
		 //-----------------------------------------
		 try {
			 Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/lab7","root","");
			stmt= con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Label label1 = new Label("ID:");
		TextField textF1 = new TextField();
		HBox hb1 = new HBox(label1,textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		
		Label label2 = new Label("NAME");
		TextField textF2 = new TextField();

		HBox hb2 = new HBox(label2,textF2);
		hb2.setAlignment(Pos.CENTER);
		this.getChildren().addAll(hb2);
		hb2.setSpacing(10);
		
		

		
		Label label3 = new Label("DEPARTMENT:");
		ComboBox  co = new ComboBox ();
		HBox hb3 = new HBox(label3,co);
		this.getChildren().addAll(hb3);
		hb3.setSpacing(10);
		hb3.setAlignment(Pos.CENTER);
		//----------------------------------------------------
		
//		ResultSet rs=stmt.executeQuery("select dept_name from department");  
//		while(rs.next())  {
//			co.getItems().addAll(rs.getString(1));
//		}
		
		String SQL = "SELECT dept_name from department";
        ResultSet rs;
		try {
			rs = con.createStatement().executeQuery(SQL);
	          while(rs.next()) {
	        	  co.getItems().addAll(rs.getString(1));
	          }
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//----------------------------------------------------
		
		
		Label label4 = new Label("CH");
		TextField textF3 = new TextField ();
		HBox hb4 = new HBox(label4,textF3);
		this.getChildren().addAll(hb4);
		hb4.setSpacing(10);
		hb4.setAlignment(Pos.CENTER);
		
		Button button1 =new Button("INSERT");
		Button button2 =new Button("SEARCH");
		
		button1.setAlignment(Pos.BASELINE_RIGHT);
		button2.setAlignment(Pos.CENTER);
		
		HBox hb6 =new HBox(button1,button2);
		this.getChildren().add(hb6);
		this.getChildren().add(tableview);
		tableview.setMinSize(700, 500);
		hb6.setSpacing(10);
	

		 
		//-----------------------------------------
		button1.setOnAction(e->{
			
			String  Id= textF1.getText();
			String  name= textF2.getText();
			String  department= (String)co.getSelectionModel().getSelectedItem();
			String  CH= textF3.getText();
        
			String qu = "insert into student values(" + Id + ",'" + name + "','" + department + "',"+ CH +")" ;
			
			String string1 = "\n Inserted successfully "
					+ "\n ADDED SUCCESSFULLY ";
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Student");
			alert1.setHeaderText("");
			alert1.setContentText(string1);
			alert1.showAndWait();  
			System.out.println(qu);
			 try {
				stmt .executeUpdate(qu);
				 
			 }
			 catch (SQLException el) {
					String string = "\n Insert Error"
							+ "\n PLEASE CHECK THE DATA";
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText("Error occurs ");
					alert.setContentText(string);
					alert.showAndWait();
			 }
	});
			 
			 button2.setOnAction(e->{
				 String query = "select * from student";
				 String  Id= textF1.getText();
					String  name= textF2.getText();
					String  department= (String)co.getSelectionModel().getSelectedItem();
					String  CH= textF3.getText();
					
					if (!Id.isEmpty() || !name.isEmpty()|| co.getValue()!= null|| !CH.isEmpty()) {
						query += " where ";

						if (!Id.isEmpty()) {
							query += " ID = '" + Id+ "' AND";
						}
						if (!name.isEmpty()) {
							query += " name = '" + name+ "' AND";
						}
						 if (!department.isEmpty()) {
							query+= " dept_name = '" + department+ "' AND";}
						 
						if (!CH.isEmpty()) {
							query += " tot_cred = " + CH + " ";
						}
				

					}

					if (query.endsWith("AND")) {
						query = query.substring(0, query.lastIndexOf(" "));
					}
					
					System.out.println(query);
					//fillTable(query);
					try {
						resultSet = stmt.executeQuery(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//-------------------------------------------------
					
					try {
						  Statement stmt2=(Statement)con.createStatement();
						  ResultSet rs2=stmt2.executeQuery(query);
						  
						  tableview.getColumns().clear();
						  tableview.getItems().clear();
						  
					        ObservableList<Object> data = FXCollections.observableArrayList();

						  for (int i = 0; i < rs2.getMetaData().getColumnCount(); i++) {
				                //We are using non property style for making dynamic table
				                final int j = i;
				                TableColumn col = new TableColumn(rs2.getMetaData().getColumnName(i + 1));
				                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
				                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
				                        return new SimpleStringProperty(param.getValue().get(j).toString());
				                    }
				                });
				 
				                tableview.getColumns().addAll(col);
				                System.out.println("Column [" + i + "] ");
				            }
				 
				            /**
				             * **********
				             * Data added to ObservableList *
				             ***********
				             */
				            while (rs2.next()) {
				                //Iterate Row
				                ObservableList<String> row = FXCollections.observableArrayList();
				                for (int i = 1; i <= rs2.getMetaData().getColumnCount(); i++) {
				                    //Iterate Column
				                    row.add(rs2.getString(i));
				                }
				                System.out.println("Row [1] added " + row);
				                data.add(row);
				 
				            }
				 
				            //FINALLY ADDED TO TableView
				            tableview.setItems(data);
						  
						  
					   }catch(SQLException e1) {
						   System.out.println("");
					   }
					
			 });

	}
	
//	dept_name.getValue() != null
//			 if (dept_name.getValue() != null)
//				query+= " dept_name = '" + dept_name.getValue()+ "' AND";

	
}
