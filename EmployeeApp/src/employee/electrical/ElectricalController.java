package employee.electrical;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Function;

import javax.swing.event.EventListenerList;

import employee.db.CertificateBean;
import employee.db.DBaccess;
import employee.db.Employee;
import employee.db.EmployeeBean;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class ElectricalController implements Initializable{
	
    ObservableList<EmployeeBean> empsB = FXCollections.observableArrayList();
    ObservableList<CertificateBean> certsB = FXCollections.observableArrayList();
	DBaccess dba = new DBaccess();
	ArrayList<EmployeeBean> eb = new ArrayList<>();
	protected EmployeeBean emp;
	protected CertificateBean ct;
	protected int empIndex=0;
	protected int certIndex=0;

	//employee display
	@FXML
	private TableView<EmployeeBean> tableEmp;
	@FXML
	private TableColumn<EmployeeBean, Integer> tableEmpID;
	@FXML
	private TableColumn<EmployeeBean, String> tableEmpName;
	@FXML
	private TableColumn<EmployeeBean, String> teAddress;
	@FXML
	private TableColumn<EmployeeBean, String> teCity;
	@FXML
	private TableColumn<EmployeeBean, String> tePhone;
	@FXML
	private TableColumn<EmployeeBean, String> teCell;
	@FXML
	private TableColumn<EmployeeBean, String> teEmail;
	@FXML
	private TableColumn<EmployeeBean, LocalDate> teDOB;
	@FXML
	private TableColumn<EmployeeBean, Integer> teAge;
	@FXML
	private TableColumn<EmployeeBean, String> teMarital;
	@FXML
	private TableColumn<EmployeeBean, String> teGender;
	@FXML
	private TableColumn<EmployeeBean, String> teDep;
	@FXML
	private TextField nameTxt;
	@FXML
	private TextField addressTxt;
	@FXML
	private TextField cellTxt;
	@FXML
	private TextField phoneTxt;
	@FXML
	private TextField emailTxt;
	@FXML
	private TextField cityTxt;
	@FXML
	private TextField dobTxt;
	@FXML
	private TextField ageTxt;
	@FXML
	private TextField maritalTxt;
	@FXML
	private TextField genderTxt;
	@FXML
	private TextField depTxt;
	@FXML
	private TextField numCertsTxt;
	@FXML
	private Button empNextBtn;
	@FXML
	private Button empPreviousBtn;
	@FXML
	private Button commitToDB;
	//certificate display
	@FXML
	private TextField empNumTxt;
	@FXML
	private TextField empNameTxt;
	@FXML
	private TextField certNumTxt;
	@FXML
	private TextField certTypeTxt;
	@FXML
	private TextField certProvTxt;
	@FXML
	private TextField certDescTxt;
	@FXML
	private TextField certStartTxt;
	@FXML
	private TextField certExpTxt;
	@FXML
	private TextField rebookTxt;
	@FXML
	private TextField certIDTxt;
	@FXML
	private Button certNextBtn;
	@FXML
	private Button certPreviousBtn;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		empsB = dba.getEmpAL("Electrical");
		tableEmpID.setCellValueFactory(new PropertyValueFactory<>("empID"));
		tableEmpName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		teAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
		teCity.setCellValueFactory(new PropertyValueFactory<>("City"));
		tePhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
		teCell.setCellValueFactory(new PropertyValueFactory<>("Cell"));
		teEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		teDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
		teAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
		teMarital.setCellValueFactory(new PropertyValueFactory<>("Marital"));
		teGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		teDep.setCellValueFactory(new PropertyValueFactory<>("Dep"));
		
		nameTxt.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()){
				case ENTER:
					empsB.get(empIndex).nameProperty().set(nameTxt.getText());
					tableEmpName.setVisible(false);
					tableEmpName.setVisible(true);break;
				case TAB:
					break;
				default:
					break;
				}	
			}

		});

		tableEmp.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
			//System.out.println(newValue);
			nameTxt.setText(newValue.getName());
			cellTxt.setText(newValue.getCell());
			addressTxt.setText(newValue.getAddress());
			phoneTxt.setText(newValue.getPhone());
			emailTxt.setText(newValue.getEmail());
			cityTxt.setText(newValue.getCity());
			dobTxt.setText(String.valueOf(newValue.getDob()));
			ageTxt.setText(String.valueOf(newValue.getAge()));
			maritalTxt.setText(newValue.getMarital());
			genderTxt.setText(newValue.getGender());
			depTxt.setText(newValue.getDep());  
			numCertsTxt.setText(String.valueOf(newValue.getCertsAL().size()));
		});
		
		tableEmp.setItems(empsB);
		tableEmp.setEditable(true);
		tableEmp.getSelectionModel().selectFirst();
		updateFeilds();
		tableEmp.setOnKeyPressed(event-> {
			switch (event.getCode()){
			case UP:
				employeePrevious();event.consume();
				certIndex=0;
				ct = emp.getCert(certIndex);
				break;
			case DOWN:
				employeeNext();event.consume();
				certIndex=0;
				ct = emp.getCert(certIndex);
				break;
			case RIGHT:
				System.out.println("RIGHT ARROW");event.consume();break;
			case LEFT:
				System.out.println("LEFT ARROW");event.consume();break;
			default:
				break;
			}	
		});
		
	}
	
	public void commit(){
		empsB.get(empIndex).nameProperty().set(nameTxt.getText());tableEmpName.setVisible(false);tableEmpName.setVisible(true);
		empsB.get(empIndex).addressProperty().set(addressTxt.getText());teAddress.setVisible(false);teAddress.setVisible(true);
		empsB.get(empIndex).cityProperty().set(cityTxt.getText());teCity.setVisible(false);teCity.setVisible(true);
		empsB.get(empIndex).phoneProperty().set(phoneTxt.getText());tePhone.setVisible(false);tePhone.setVisible(true);
		empsB.get(empIndex).cellProperty().set(cellTxt.getText());teCell.setVisible(false);teCell.setVisible(true);
		empsB.get(empIndex).emailProperty().set(emailTxt.getText());teEmail.setVisible(false);teEmail.setVisible(true);
		LocalDate date = LocalDate.parse(dobTxt.getText());
		empsB.get(empIndex).dobProperty().set(date);teDOB.setVisible(false);teDOB.setVisible(true);
		empsB.get(empIndex).maritalProperty().set(maritalTxt.getText());teMarital.setVisible(false);teMarital.setVisible(true);
		empsB.get(empIndex).genderProperty().set(genderTxt.getText());teGender.setVisible(false);teGender.setVisible(true);
		empsB.get(empIndex).depProperty().set(depTxt.getText());teDep.setVisible(false);teDep.setVisible(true);
		//update db here
		
		
	}
	
	public void addToTable(EmployeeBean addNew){
		empsB.add(addNew);
	}
	
	public void updateFeilds(){
		if(empsB.size()==0){
			
		}else{
			certIndex=0;
			empIndex = tableEmp.getSelectionModel().getSelectedIndex();
			
			
			emp = empsB.get(empIndex);
			nameTxt.setText(empsB.get(empIndex).getName());
			cellTxt.setText(empsB.get(empIndex).getCell());
			addressTxt.setText(empsB.get(empIndex).getAddress());
			phoneTxt.setText(empsB.get(empIndex).getPhone());
			emailTxt.setText(empsB.get(empIndex).getEmail());
			cityTxt.setText(empsB.get(empIndex).getCity());
			dobTxt.setText(empsB.get(empIndex).getDob().toString());
			ageTxt.setText(""+empsB.get(empIndex).getAge());
			maritalTxt.setText(empsB.get(empIndex).getMarital());
			genderTxt.setText(empsB.get(empIndex).getGender());
			depTxt.setText(empsB.get(empIndex).getDep());  
			numCertsTxt.setText(""+empsB.get(empIndex).getCertsAL().size());
			ct = emp.getCert(0);
			empNumTxt.setText(""+empsB.get(empIndex).getEmpID());
			empNameTxt.setText(empsB.get(empIndex).getName());
			certNumTxt.setText(ct.getCertNum());
			certTypeTxt.setText(ct.getCertType());
			certProvTxt.setText(ct.getCertProv());
			certDescTxt.setText(ct.getCertDesc());
			certStartTxt.setText(ct.getCertStart().toString());
			certExpTxt.setText(ct.getCertExp().toString());
			rebookTxt.setText(ct.getRebook().toString());
			certIDTxt.setText(""+ct.getCertID());
		}
	}
	
	public void setEmpFeilds(){
		updateFeilds();
		
	}
	public void employeeNext(){
		if(empIndex<empsB.size()-1){
			empIndex++;
			tableEmp.getSelectionModel().select(empIndex);
			tableEmp.scrollTo(empIndex);
		}		
		updateFeilds();
	}
	public void employeePrevious(){
		if(empIndex>0){
			empIndex--;
			tableEmp.getSelectionModel().select(empIndex);
			tableEmp.scrollTo(empIndex);
		}		
		updateFeilds();

	}
	
	public void updateCert(){
		ct = emp.getCert(certIndex);
		empNumTxt.setText(""+emp.getEmpID());
		empNameTxt.setText(emp.getName());
		certNumTxt.setText(ct.getCertNum());
		certTypeTxt.setText(ct.getCertType());
		certProvTxt.setText(ct.getCertProv());
		certDescTxt.setText(ct.getCertDesc());
		certStartTxt.setText(ct.getCertStart().toString());
		certExpTxt.setText(ct.getCertExp().toString());
		rebookTxt.setText(ct.getRebook().toString());
		certIDTxt.setText(""+ct.getCertID());
	}
	
	public void cetificateNext(){
		if(certIndex<emp.getCertsAL().size()-1){
			certIndex++;
		}
		updateCert();
	}
	public void cetificatePrevious(){
		if(certIndex>0){
			certIndex--;
		}
		updateCert();
	}
}
