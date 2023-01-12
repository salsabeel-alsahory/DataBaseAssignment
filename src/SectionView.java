import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

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

public class SectionView extends VBox{
   
//	int cours_id;
//	int sec_id;
//	String semester;
//	Date year;
//	int room_num;
//	Time time_slot;
//	
	TableView tableview = new TableView();
	static Connection con;
	static ResultSet resultSet;
	static Statement stmt;	
	
	public SectionView() {
		Label label1 = new Label("COURS_ID:");
		TextField textF1 = new TextField ();
		
		HBox hb1 = new HBox(label1,textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.BASELINE_LEFT);
		
		Label label2 = new Label("SEC_ID");
		TextField textF2 = new TextField ();

		HBox hb2 = new HBox(label2,textF2);
		this.getChildren().addAll(hb2);
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.BASELINE_LEFT);
		

		
		Label label3 = new Label("SEMESTER:");
		TextField textF3 = new TextField ();
		HBox hb3 = new HBox(label3,textF3);
		this.getChildren().addAll(hb3);
		hb3.setSpacing(10);
		hb3.setAlignment(Pos.BASELINE_LEFT);
		
		Label label4 = new Label("YEAR");
		TextField textF4 = new TextField ();
		HBox hb4 = new HBox(label4,textF4);
		this.getChildren().addAll(hb4);
		hb4.setSpacing(10);
		hb4.setAlignment(Pos.BASELINE_LEFT);
		
		Label label5 = new Label("BUILDING");
		TextField textF5 = new TextField ();
		HBox hb5 = new HBox(label5,textF5);
		this.getChildren().addAll(hb5);
		hb5.setSpacing(10);
		hb5.setAlignment(Pos.BASELINE_LEFT);
		
		Label label6 = new Label("ROOM_NUMBER");
		TextField textF6 = new TextField ();
		HBox hb6 = new HBox(label6,textF6);
		this.getChildren().addAll(hb6);
		hb6.setSpacing(10);
		hb6.setAlignment(Pos.BASELINE_LEFT);
		
		Label label7 = new Label("TIME_SLOT_ID");
		TextField textF7 = new TextField ();
		HBox hb7 = new HBox(label7,textF7);
		this.getChildren().addAll(hb7);
		hb7.setSpacing(10);
		hb7.setAlignment(Pos.BASELINE_LEFT);
		
		Button button1 =new Button("INSERT");
		Button button2 =new Button("SEARCH");
		
		button1.setAlignment(Pos.BASELINE_RIGHT);
		button2.setAlignment(Pos.CENTER);
		
		HBox hb8 =new HBox(button1,button2);
		this.getChildren().add(hb8);
		this.getChildren().add(tableview);
		tableview.setMinSize(700, 500);
		hb8.setSpacing(10);
		
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
				String SECTION_ID = textF2.getText();
				String SEMESTER = textF3.getText();
				String YEAR = textF4.getText();
				String BUILDING = textF5.getText();
				String ROOM_NUM = textF6.getText();
				String TIME_SLOT = textF7.getText();
			
				 if (COURSE_ID instanceof String && SECTION_ID instanceof String && SEMESTER instanceof String && YEAR instanceof String && BUILDING instanceof String && ROOM_NUM instanceof String&& TIME_SLOT instanceof String) {
				if (!COURSE_ID.isEmpty() || SECTION_ID.isEmpty() || SEMESTER.isEmpty() || YEAR.isEmpty() || BUILDING.isEmpty() || ROOM_NUM.isEmpty() || TIME_SLOT.isEmpty()) {
					try {
//						
						String qu = "INSERT into prereq values('" + COURSE_ID + "','" + SECTION_ID 
								                            + "','" + SEMESTER     
								                             + "','" + YEAR 
								                              + "','" + BUILDING 
								                              + "','" + ROOM_NUM
								                              + "','" + TIME_SLOT + "')";
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
								+ "\n CHECK SECTION INFORMATION PLEASE ";
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
			String query = "select * from section";
			String COURSE_ID = textF1.getText();
			String SECTION_ID = textF2.getText();
			String SEMESTER = textF3.getText();
			String YEAR = textF4.getText();
			String BUILDING = textF5.getText();
			String ROOM_NUM = textF6.getText();
			String TIME_SLOT = textF7.getText();
			
			if (!COURSE_ID.isEmpty() || !SECTION_ID.isEmpty()|| !SEMESTER .isEmpty()|| !YEAR.isEmpty()||!BUILDING.isEmpty()|| !ROOM_NUM.isEmpty()|| !TIME_SLOT.isEmpty()) {
				query += " where ";

				if (!COURSE_ID.isEmpty()) {
					query += "course_id = '" + COURSE_ID+ "' AND";
				}
				if (!SECTION_ID.isEmpty()) {
					query += "sec_id = '" + SECTION_ID + "' AND";
				}
				if (!SEMESTER.isEmpty()) {
					query += "semester = '" + SEMESTER+ "' AND";
				}
				if (!YEAR.isEmpty()) {
					query += "year = '" + YEAR + "' AND";
				}
				if (!BUILDING.isEmpty()) {
					query += "building = '" + BUILDING + "' AND";
				}
				if (!ROOM_NUM.isEmpty()) {
					query += "room_num = '" + ROOM_NUM   + "' AND";
				}
				if (!TIME_SLOT .isEmpty()) {
					query += "time_slot_id = '" + TIME_SLOT  + "' ";
				}
			}

			if (query.endsWith("AND")) {
				query = query.substring(0, query.lastIndexOf(" "));
			}
			
			System.out.println(query);
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
			stmt = (Statement) con.createStatement();

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