package employee.view;

import java.io.IOException;

import employee.Main;
import javafx.fxml.FXML;

public class MainViewController {

	private Main main;
	
	@FXML
	private void goStudent() throws IOException{
		main.showStudentScene();
	}
	
	@FXML
	private void goHome() throws IOException{
		main.showMainItems();
	}
	@FXML
	private void addBtn() throws IOException{
		main.showAddStage();
	}
	@FXML
	private void close(){
		System.exit(0);
	}
	@FXML
	private void save(){
		//save changed items here
	}
}
