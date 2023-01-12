import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MAinView extends Application {

	public void connectDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "");

	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox vb = new VBox();
		vb.setSpacing(20);
//		 final ImageView selectedImage = new ImageView();  
//
//
//	        vb.getChildren().addAll(selectedImage);

		Pane viewsPane = new Pane();

		// viewsPane.setStyle("-fx-background-color: #E4F6F8 ;");

		// -----------------------------------------------------------------------
		Button button1 = new Button("About the Developer ");

		button1.setOnAction(e -> {
			String aboutDev = "\n Bethlehem University" + "\n Student ID: 202006388\n\n" + "\n Salsabeel Alsahoury ";

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("About the Developer ");
			alert.setContentText(aboutDev);
			alert.showAndWait();
		});

		Button button2 = new Button("About the DataBase ");

		button2.setOnAction(e -> {
			String aboutDB = "\n Bethlehem University DataBase"
					+ "\n This DataBase for students at Bethlehem University ";
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("About the DataBase ");
			alert.setContentText(aboutDB);
			alert.showAndWait();
		});

		// ------------------connect DataBase with the code-------

		// ------------------Defined object from classes----------
		StudentsView studentsView = new StudentsView();
		SectionView sectionView = new SectionView();
		InstructorsView instructorsView = new InstructorsView();
		PrereqView prereqView = new PrereqView();
		TakesView takesView = new TakesView();
		TeachesView teachesView = new TeachesView();
		CourseView courseView = new CourseView();
		TimeSlotView timeSlotView = new TimeSlotView();
		AdvisorView advisorView = new AdvisorView();
		ClassRoomVIew classRoomVIew = new ClassRoomVIew();
		DepartmentView departmentView = new DepartmentView();

		// --------------------------defined list-----------------
		@SuppressWarnings("rawtypes")
		final ComboBox<String> tablesComboBox = new ComboBox();

		// setPopupSide(Side.TOP);
		// -----------------style the button & combobox----------
		HBox hb2 = new HBox(button1, button2, tablesComboBox);
		hb2.setSpacing(10);
		vb.getChildren().add(hb2);

		HBox hbox = new HBox();

		Image image = new Image(new FileInputStream("C:\\Users\\actc\\Desktop\\1.jpg"));
		ImageView selectedImage = new ImageView(image);

		selectedImage.setFitHeight(400);
		selectedImage.setFitWidth(700);
		selectedImage.setImage(image);

		hbox.getChildren().add(selectedImage);
		vb.getChildren().add(hbox);
		// -------------create combobox item-------------------
		tablesComboBox.getItems().addAll("Students", "Instructors", "Courses", "classroom", "prereq", "section",
				"teaches", "time-slot", "advisor", "department", "takes");

		tablesComboBox.setValue("Students");// Default value

		// -----------------------------------defined listener------------------
		tablesComboBox.valueProperty().addListener(new ChangeListener<String>() {

			// ------------------------comboBox choices---------------------
			@Override
			public void changed(ObservableValue ov, String t, String newVal) {
				if (newVal.equals("Students")) {
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(studentsView);
					viewsPane.setStyle("-fx-background-color:  #E4F6F8 ;");

				}

				if (newVal.equals("Instructors")) {

					selectedImage.setManaged(false);// to hide the image
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(instructorsView);
					viewsPane.setStyle("-fx-background-color: #fff0f3 ;");

				}

				if (newVal.equals("Courses")) {
					selectedImage.setManaged(false);
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(courseView);

					viewsPane.setStyle("-fx-background-color: #F6CDD2;");
				}

				if (newVal.equals("classroom")) {
					selectedImage.setManaged(false);
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(classRoomVIew);
					viewsPane.setStyle("-fx-background-color: #F8CBD1;");

					// viewsPane.setStyle("-fx-background-color: #C4BFDB;");
				}

				if (newVal.equals("prereq")) {
					selectedImage.setManaged(false);
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(prereqView);
					viewsPane.setStyle("-fx-background-color: #F4DBD9;");
				}

				if (newVal.equals("section")) {
					selectedImage.setManaged(false);
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(sectionView);
					viewsPane.setStyle("-fx-background-color: #ffb7ce ;");
				}

				if (newVal.equals("teaches")) {
					selectedImage.setManaged(false);
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(teachesView);
					viewsPane.setStyle("-fx-background-color: #F3DADB ;");
				}

				if (newVal.equals("time-slot")) {
					selectedImage.setManaged(false);
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(timeSlotView);
					viewsPane.setStyle("-fx-background-color:#E4CEA7;");

				}
				if (newVal.equals("advisor")) {
					selectedImage.setManaged(false);
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(advisorView);
					viewsPane.setStyle("-fx-background-color:#AFE4D3;");

				}
				if (newVal.equals("department")) {
					selectedImage.setManaged(false);
					selectedImage.setVisible(false);
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(departmentView);
					viewsPane.setStyle("-fx-background-color:#606391;");
				}
				if (newVal.equals("takes")) {
					viewsPane.getChildren().clear();
					viewsPane.getChildren().add(takesView);
					viewsPane.setStyle("-fx-background-color: #ca9bf7;");
				}
				/*
				 * else { System.out.println("please choose one choice from the list "); }
				 */
			}
		});

		// -----------------------------------------------------------------------
		vb.getChildren().addAll(viewsPane);
		vb.setSpacing(20);

		Scene s = new Scene(vb, 700, 700);
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}