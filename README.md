# JavaFX Database Application

This is a JavaFX application that provides a graphical user interface for interacting with a MySQL database. It allows users to view and manipulate data in various tables of the database.

## Prerequisites

- Java Development Kit (JDK)
- MySQL database
- MySQL Connector/J (JDBC driver)

## Getting Started

1. Clone the repository.

2. Import the project into your favorite Java IDE.

3. Install the necessary dependencies (JavaFX, MySQL Connector/J) using the build tool of your choice (e.g., Maven, Gradle).

4. Update the database connection details in the `connectDB` method of the `MAinView` class. Modify the JDBC URL, username, and password according to your MySQL database configuration.

5. Run the `MAinView` class to start the application.

## Usage

Upon launching the application, a graphical interface will appear with the following components:

- "About the Developer" button: Displays information about the developer in an alert dialog.
- "About the DataBase" button: Displays information about the database in an alert dialog.
- ComboBox: Allows selecting a table from the database.
- ImageView: Displays an image related to the selected table (if available).
- Views Pane: Displays the selected table's view, where users can interact with the data (e.g., view, add, edit, delete records).

To interact with the application, follow these steps:

1. Click on the "About the Developer" button to learn more about the developer.
2. Click on the "About the DataBase" button to get information about the database.
3. Use the ComboBox to select a table from the database.
4. The ImageView will display an image related to the selected table (if available).
5. The Views Pane will show the selected table's view, allowing you to perform various operations on the data.
