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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
	static Connection con;
	static ResultSet resultSet;
    static private GridPane advisorViewPane;
   // TabPane tabPane = new TabPane();


//    public GridPane getDepartmentViewPane() {
//        return advisorViewPane;
//    }
//    
	public AdvisorView() throws ClassNotFoundException, SQLException {
		
		//-----------connection-----------
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "");
		Statement stmt= con.createStatement();
//		
//		//-----------use tabPane----------
////		advisorViewPane =new GridPane();
////		Tab tab1 = new Tab("advisor");
////		tab1.setClosable(false);
//		
//		
//		//-----------Deceleration labels and textF
//		Label label1 = new Label("STUDENT ID");
//		TextField textF1 = new TextField();
//		
//		//-------using tab pane-------------------
////		Tab tab2 = new Tab("S_ID");
////		tab2.setClosable(false);
////        tab2.setContent(advisorViewPane);
//        
//		HBox hb1 = new HBox(label1, textF1);
//		this.getChildren().addAll(hb1);
//		hb1.setSpacing(10);
//		hb1.setAlignment(Pos.BASELINE_LEFT);
////		vb.getChildren().addAll(hb1);
////		vb.setPadding(new Insets(0, 20, 10, 20)); 
//		// ------------------------------------------
//
//		Label label2 = new Label("INSTRUCTOR ID");
//		TextField textF2 = new TextField();
//		//-------using tab pane-------------------
////		Tab tab3 = new Tab("I_ID");
////		tab3.setClosable(false);
////        tab3.setContent(advisorViewPane);
////
//		HBox hb2 = new HBox(label2, textF2);
//		this.getChildren().addAll(hb2);
//		hb2.setSpacing(10);
//		hb2.setAlignment(Pos.BASELINE_LEFT);
//        
//        
//		// ------------------------------------------
//
//       // tabPane.getTabs().addAll(tab2,tab3);
//        
//		Button insertbutton1 = new Button("INSERT");
//		Button searchbutton2 = new Button("SEARCH");
//
//		insertbutton1.setAlignment(Pos.BASELINE_RIGHT);
//		searchbutton2.setAlignment(Pos.CENTER);
//
//		HBox hb3 = new HBox(insertbutton1, searchbutton2);
//		this.getChildren().add(hb3);
//		this.getChildren().add(tableview);
//		tableview.setMinSize(700, 500);
//		hb3.setSpacing(10);
//
//		// ------------------Programming the buttons -------------------------------
		Label label1 = new Label("STUDENT ID");
		TextField textF1 = new TextField();

		HBox hb1 = new HBox(label1, textF1);
		this.getChildren().addAll(hb1);
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.BASELINE_LEFT);
		// ------------------------------------------
		
		// ------------------------------------------

		Label label2 = new Label("INSTRUCTOR ID");
		TextField textF2 = new TextField();

		HBox hb2 = new HBox(label2, textF2);
		this.getChildren().addAll(hb2);
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.BASELINE_LEFT);
		// ------------------------------------------
	

		Button insertbutton1 = new Button("INSERT");
		Button searchbutton2 = new Button("SEARCH");
		

		insertbutton1.setAlignment(Pos.BASELINE_RIGHT);
		searchbutton2.setAlignment(Pos.CENTER);
		

		HBox hb3 = new HBox(insertbutton1, searchbutton2);
		this.getChildren().add(hb3);
		this.getChildren().add(tableview);
		tableview.setMinSize(700, 500);
		hb3.setSpacing(10);

		// ------------------Programming the buttons -------------------------------

		insertbutton1.setOnAction(e -> {

			String instID = textF2.getText();
			String studentID = textF1.getText();

			// if (instID instanceof String) {
			if (!studentID.isEmpty() && !instID.isEmpty()) {
				try {
//					
					String qu = "INSERT into advisor (`s_ID`, `i_ID`) values('" + studentID + "','" + instID + "')";
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
							+ "\n You should insert student and instructor in the same department ";
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

		searchbutton2.setOnAction(e -> {
			String qu = "select * from advisor";
			ResultSet result = null;
			String instID = textF2.getText();
			String studentID = textF1.getText();
			
			if (!studentID.isEmpty()) {
				qu = "select * from advisor where s_ID ='" + studentID + "'";
			}
			if (!instID.isEmpty()) {
				qu = "select * from advisor where i_ID ='" + instID + "'";
			}
			if (!studentID.isEmpty() && !instID.isEmpty()) {
				qu = "select * from advisor where s_ID ='" + studentID + "' and i_ID ='" + instID + "'";
			}

			else {
				System.out.println("YOU TRY TO SEARCH ON NOT EXISTS DATA !!");
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