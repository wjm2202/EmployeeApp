package employee.view;

import java.sql.Date;
import java.util.Calendar;

import employee.db.Certificate;
import employee.db.CertificateBean;
import employee.db.DBaccess;
import employee.db.Employee;
import employee.db.EmployeeBean;
import employee.electrical.ElectricalController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

public class AddNewEmployeeController {
	
	DBaccess dba = new DBaccess();
	EmployeeBean emp;
	CertificateBean cert;
	ElectricalController ec;

	ObservableList<String> maritalStatusList = FXCollections.observableArrayList("Single", "Married", "Divorced");
	ObservableList<String> mainDepartmentList = FXCollections.observableArrayList("Electrical", "Mecanical");
	// contact information

	@FXML
	private TextField nameFeild;
	@FXML
	private TextField addressFeild;
	@FXML
	private TextField cityFeild;
	@FXML
	private TextField phoneFeild;
	@FXML
	private TextField cellFeild;
	@FXML
	private TextField emailFeild;
	// Personal information
	@FXML
	private DatePicker dateOfBirth;
	@FXML
	private TextField ageFeild;
	@FXML
	private ChoiceBox<String> maritalStatusBox;
	@FXML
	private RadioButton maleBtn;
	@FXML
	private RadioButton femaleBtn;
	@FXML
	private ComboBox<String> mainDepartmentBox;

	// cert feilds
	@FXML
	private TextField certNum;
	@FXML
	private TextField cerProv;
	@FXML
	private TextField certType;
	@FXML
	private TextField certDesc;
	@FXML
	private DatePicker certStart;
	@FXML
	private DatePicker certExp;
	@FXML
	private DatePicker rebook;
	@FXML
	private Button save;

	@FXML
	private void initialize() {
		maritalStatusBox.setValue("Single");
		maritalStatusBox.setItems(maritalStatusList);
		
		mainDepartmentBox.setValue("Electrical");
		mainDepartmentBox.setItems(mainDepartmentList);
		
	}

	@FXML
	private void showAge() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int birthYear = (dateOfBirth.getValue().getYear());
		int age = year - birthYear;
		ageFeild.setText(Integer.toString(age));
	}
	@FXML
	private void saveEmployee(){
		int eid =0;
		int cid =0;
		emp = new EmployeeBean();
		emp.setName(nameFeild.getText());
		emp.setAddress(addressFeild.getText());
		emp.setCity(cityFeild.getText());
		emp.setPhone(phoneFeild.getText());
		emp.setCell(cellFeild.getText());
		emp.setEmail(emailFeild.getText());
		//System.out.println("emailFeild in save employee in add new employee   "+emailFeild.getText());
		emp.setDob(dateOfBirth.getValue());
		emp.setAge(Integer.parseInt(ageFeild.getText()));
		emp.setMarital(maritalStatusBox.getValue());
		emp.setDep(mainDepartmentBox.getValue());
		eid = dba.saveEmployee(emp);
		System.out.println("returned from save emp  in addnewemployee in save employee  eid   "+ eid );
		emp.setEmpID(eid);
		System.out.println("set in emp.setEmpId(eid)   " + emp.getEmpID());
		cert = new CertificateBean();
		cert.setEmpID(emp.getEmpID());
		System.out.println("saved eid in cert  "+ cert.getEmpID());
		cert.setCertNum(certNum.getText());
		cert.setCertProv(cerProv.getText());
		cert.setCertType(certType.getText());
		cert.setCertDesc(certDesc.getText());
		cert.setCertStart(certStart.getValue());
		cert.setCertExp(certExp.getValue());
		cert.setRebook(rebook.getValue());
		cid = dba.saveCertificate(cert);
		dba.saveEmpCert(eid, cid);
		//ec.addToTable(emp);
		//System.out.println(cert.getCertDesc()+ "  cert desc");
		
	}

}
