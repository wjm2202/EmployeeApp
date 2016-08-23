package employee.view;

import java.io.IOException;

import employee.Main;
import employee.db.DBaccess;
import javafx.fxml.FXML;

//allow the button methods to switch content

public class MainItemsController {
	
	private Main main;
	DBaccess dba = new DBaccess();

	@FXML
	private void goStudent() throws IOException{
		main.showStudentScene();
	}
	
	@FXML
	private void goElectrical() throws IOException{
		main.showElectricalScene();
	}
	@FXML
	private void goMechanical() throws IOException{
		main.showMechanicalScene();
	}
	@FXML
	private void goEquipment() throws IOException{
		main.showEqupmentScene();
	}
	@FXML
	private void goAsset() throws IOException{
		main.showAssetScene();
	}
	@FXML
	private void newTables(){
		//dba.dropTables();
	}
}
