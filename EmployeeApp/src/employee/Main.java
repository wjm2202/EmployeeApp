package employee;

import java.io.IOException;

import employee.db.DBaccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	public static DBaccess dba = new DBaccess();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Employee Application");
		
		try {
			showMainView();
			showMainItems();
		} catch (IOException e) {
			System.out.println("error in showMainView");
			e.printStackTrace();
		}
	}
	//add new fxml add paper here
	public static void showAddPaperStage() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("student/AddPaper.fxml"));
		BorderPane addNewPaper = loader.load();
		Stage addPaperStage = new Stage();
		addPaperStage.setTitle("Add New Employee");
		addPaperStage.initModality(Modality.WINDOW_MODAL);
		addPaperStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewPaper);
		addPaperStage.setScene(scene);
		addPaperStage.showAndWait();
		
		
	}
	
	public static void showAddStage() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddNewEmployee.fxml"));
		BorderPane addNewEmployee = loader.load();
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add New Employee");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewEmployee);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
		
		
	}
	
	public static void showAssetScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("assets/Assets.fxml"));
		BorderPane assets = loader.load();
		mainLayout.setCenter(assets);
	}
	
	public static void showMechanicalScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("mechanical/MechanicalDep.fxml"));
		BorderPane mechanicalDep = loader.load();
		mainLayout.setCenter(mechanicalDep);
	}
	
	public static void showStudentScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("student/Student.fxml"));
		BorderPane student = loader.load();
		mainLayout.setCenter(student);
	}
	
	public static void showEqupmentScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("equipment/Equipment.fxml"));
		BorderPane equipment = loader.load();
		mainLayout.setCenter(equipment);
	}
	
	public static void showElectricalScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("electrical/ElectricalDep.fxml"));
		BorderPane electricalDep = loader.load();
		mainLayout.setCenter(electricalDep);
	}
	
	public static void showMainItems() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}

	public void showMainView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout,800,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		
		launch(args);
	}
}
