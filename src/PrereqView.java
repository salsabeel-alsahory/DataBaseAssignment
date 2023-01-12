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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class PrereqView extends VBox{
//	
//	int CourseID;
//	int prereqID;
	TableView tableview = new TableView();
	static Connection con;
	static ResultSet resultSet;
	static Statement stmt;	
	
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
		this.getChildren().add(tableview);
		tableview.setMinSize(700, 500);
		hb6.setSpacing(10);
		
		 
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
		 
		 button1.setOnAction(e->{
			 
				String COURSE_ID = textF1.getText();
				String PREREQ_ID = textF2.getText();
			
				 if (COURSE_ID instanceof String && PREREQ_ID instanceof String) {
				if (!COURSE_ID.isEmpty() && !PREREQ_ID.isEmpty()) {
					try {
//						
						String qu = "INSERT into prereq values('" + COURSE_ID + "','" + PREREQ_ID + "')";
						System.out.println(qu);
						stmt.executeUpdate(qu);

						String string = "\n Inserted successfully "
								+ "\n ADDED SUCCESSFULLY ";
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("Student");
						alert.setHeaderText("");
						alert.setContentText(string);
						alert.showAndWait(); 
						
					} catch (SQLException e1) {
						
						String string = "\n Insert Error"
								+ "\n PLEASE ENTER EXISTS COURSE AND CHECK PREREQ-ID ";
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("Information");
						alert.setHeaderText("Error occurs ");
						alert.setContentText(string);
						alert.showAndWait();
					}
				}
				}
			});
		 
		 button2.setOnAction(e->{
				String query = "select * from prereq";
				String COURSE_id = textF1.getText();
				String PREREQ_id = textF2.getText();
				
				if (!COURSE_id.isEmpty() || !PREREQ_id.isEmpty()) {
					query += " where ";

					if (!COURSE_id.isEmpty()) {
						query += "course_id = '" + COURSE_id+ "' AND";
					}
					if (!PREREQ_id .isEmpty()) {
						query += " prereq_id = '" + PREREQ_id + "'";
					}
			

				}

				if (query.endsWith("AND")) {
					query = query.substring(0, query.lastIndexOf(" "));
				}
				
				System.out.println(query);
				fillTable(query);
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




public void fillTable(String q) {
	// --------------------------
	ObservableList<Object> data = FXCollections.observableArrayList();
	// is a list that can be observed for changes
	// and is commonly used in JavaFX to store data for display in a UI control such
	// as a table view.
	// ----------------------------------

	try {
		String SQL = q;
		Statement stmt = (Statement) con.createStatement();

		ResultSet rs = stmt.executeQuery(SQL);
		tableview.getItems().clear();
		tableview.getColumns().clear();
		/************
		 * TABLE COLUMN ADDED DYNAMICALLY *
		 ************/
		for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
			// We are using non property style for making dynamic table
			final int j = i;
			TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
			col.setCellValueFactory(
					new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
							return new SimpleStringProperty(param.getValue().get(j).toString());
						}
					});

			tableview.getColumns().addAll(col);
			System.out.println("Column [" + i + "] ");
		}

		/************
		 * Data added to ObservableList *
		 ************/
		while (rs.next()) {
			// Iterate Row
			ObservableList<String> row = FXCollections.observableArrayList();
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				// Iterate Column
				row.add(rs.getString(i));
			}
			System.out.println("Row [1] added " + row);
			data.add(row);

		}

		// FINALLY ADDED TO TableView
		tableview.setItems(data);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error on Building Data");
	}

}
	
}
