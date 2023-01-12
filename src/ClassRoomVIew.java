import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class ClassRoomVIew extends VBox {
	TableView tableview = new TableView();
	static Connection con;
	static ResultSet resultSet;
	

	public void connectDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "");
	}

	public ClassRoomVIew() throws ClassNotFoundException, SQLException {
		connectDB();
		
		Statement stmt;
		Label label1 = new Label("BUILDING");
		TextField textF1 = new TextField();

		HBox hb1 = new HBox(label1, textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.BASELINE_LEFT);

		Label label2 = new Label("ROOM_NUM");
		TextField textF2 = new TextField();

		HBox hb2 = new HBox(label2, textF2);
		this.getChildren().addAll(hb2);
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.BASELINE_LEFT);

		Label label3 = new Label("CAPACITY");
		TextField textF3 = new TextField();

		HBox hb3 = new HBox(label3, textF3);
		this.getChildren().addAll(hb3);
		hb3.setSpacing(10);
		hb3.setAlignment(Pos.BASELINE_LEFT);

		Button insertButton = new Button("INSERT");
		Button searchButton = new Button("SEARCH");

		insertButton.setAlignment(Pos.BASELINE_RIGHT);
		searchButton.setAlignment(Pos.CENTER);

		HBox hb4 = new HBox(insertButton, searchButton);
		this.getChildren().add(hb4);
		this.getChildren().add(tableview);
		tableview.setMinSize(700, 500);
		hb4.setSpacing(10);

//		//--------------------------------------------
//		  HBox.setHgrow(insertButton, Priority.ALWAYS);
//		    HBox.setHgrow(searchButton , Priority.ALWAYS);
//		    insertButton.setMaxWidth(Double.MAX_VALUE);
//		    searchButton .setMaxWidth(Double.MAX_VALUE);
//		    hb4.getChildren().addAll(insertButton, searchButton );
//		    
//		    hb4.setPrefWidth(400);
//		    //-----------------------------------------
		Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/lab7","root",""); 
			 stmt= con.createStatement();
		// ------------------Programming the buttons -------------------------------

		insertButton.setOnAction(e -> {

			String building = textF1.getText();
			String roomNum = textF2.getText();
			String capacity = textF3.getText();
			
			// if (instID instanceof String) {
			if (!building.isEmpty() && !roomNum.isEmpty()&& !capacity.isEmpty()) {
				try {
//					
					String qu = "INSERT into classroom values('" + building +
							                                  "','" +  roomNum   
							                                   + "','" + capacity + "')";
					
					String string1 = "\n Inserted successfully "
							+ "\n ADDED SUCCESSFULLY ";
					Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
					alert1.setTitle("Student");
					alert1.setHeaderText("");
					alert1.setContentText(string1);
					alert1.showAndWait(); 
					
					System.out.println(qu);
					stmt.executeUpdate(qu);
				} catch (SQLException e1) {
					
					String string = "\n Insert Error"
							+ "\n PLEASE ENTER  CORRECT DATA";
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText("Error occurs ");
					alert.setContentText(string);
					alert.showAndWait();
				}
			}

//				        // Create a prepared statement
//				        String sql = "INSERT INTO student (s_ID, i_ID) VALUES (?, ?)";
//				     
//						try {
//							stmt = con.prepareStatement(sql);
//							
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//
//				  
//}
		});

		searchButton.setOnAction(e -> {
			String query = "select * from classroom ";
			String bulding = textF1.getText();
			String roomNum = textF2.getText();
			String capacity = textF3.getText();

			if (!bulding.isEmpty() || !roomNum.isEmpty() || !capacity.isEmpty()) {
				query += " where ";

				if (!bulding.isEmpty()) {
					query += "building = '" + bulding + "' AND";
				}
				if (!roomNum.isEmpty()) {
					query += "room_number = " + roomNum + " AND";
				}
				if (!capacity.isEmpty()) {
					query += "capacity = " + capacity;
				}

			}

			if (query.endsWith("AND")) {
				query = query.substring(0, query.lastIndexOf(" "));
			}
			
//			System.out.println(query);
//			fillTable(query);
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
