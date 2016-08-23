package employee.student;

import employee.db.DBaccess;
import employee.db.EmployeeBean;
import employee.db.PaperBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddPaperController {
	
	DBaccess dba = new DBaccess(); 
	
	@FXML TextField paperTxt;
	@FXML TextField codeTxt;
	@FXML TextField semesterTxt;
	@FXML TextField levelTxt;
	@FXML TextField percentTxt;
	@FXML TextField valueTxt;
	@FXML TextField weightTxt;
	@FXML TextField resultTxt;
	@FXML TextField projectedTxt;
	@FXML TextField a1vTxt;
	@FXML TextField a1wTxt;
	@FXML TextField a1rTxt;
	@FXML TextField a2vTxt;
	@FXML TextField a2wTxt;
	@FXML TextField a2rTxt;
	@FXML TextField a3vTxt;
	@FXML TextField a3wTxt;
	@FXML TextField a3rTxt;
	@FXML TextField a4vTxt;
	@FXML TextField a4wTxt;
	@FXML TextField a4rTxt;
	@FXML TextField midvTxt;
	@FXML TextField midwTxt;
	@FXML TextField midrTxt;
	@FXML TextField fvTxt;
	@FXML TextField fwTxt;
	@FXML TextField frTxt;
	@FXML Label a7vTxt;
	@FXML Label a7wTxt;
	@FXML Label a7rTxt;
	
	@FXML 
	public void save(){
		PaperBean pb = new PaperBean();
		pb.setPaper(paperTxt.getText());
		pb.setCode(codeTxt.getText());
		pb.setSemester(semesterTxt.getText());
		pb.setLevel(parseInt(levelTxt.getText()));
		pb.setPercent(parseInt(percentTxt.getText()));
		pb.setValue(parseInt(valueTxt.getText()));
		pb.setWeight(parseInt(weightTxt.getText()));
		pb.setResult(parseInt(resultTxt.getText()));
		pb.setProjected(projectedTxt.getText());
		pb.setA1v(parseInt(a1vTxt.getText()));
		pb.setA1w(parseInt(a1wTxt.getText()));
		pb.setA1r(parseInt(a1rTxt.getText()));
		pb.setA2v(parseInt(a2vTxt.getText()));
		pb.setA2w(parseInt(a2wTxt.getText()));
		pb.setA2r(parseInt(a2rTxt.getText()));
		pb.setA3v(parseInt(a3vTxt.getText()));
		pb.setA3w(parseInt(a3wTxt.getText()));
		pb.setA3r(parseInt(a3rTxt.getText()));
		pb.setA4v(parseInt(a4vTxt.getText()));
		pb.setA4w(parseInt(a4wTxt.getText()));
		pb.setA4r(parseInt(a4rTxt.getText()));
		pb.setMidv(parseInt(midvTxt.getText()));
		pb.setMidw(parseInt(midwTxt.getText()));
		pb.setMidr(parseInt(midrTxt.getText()));
		pb.setFv(parseInt(fvTxt.getText()));
		pb.setFw(parseInt(fwTxt.getText()));
		pb.setFr(parseInt(frTxt.getText()));
		
		int pid = dba.savePaper(pb);
		pb.setPaperID(pid);
		
	}
	public int parseInt(String input){
		int result=0;
		try{
			result = Integer.parseInt(input);
		}catch(NumberFormatException e){
			result = 1;
			System.out.println("failed to parse int from add paper");
		}
		return result;
	}

}
