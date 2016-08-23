package employee.db;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeBean {
	
	private final SimpleIntegerProperty empID;
	private final SimpleStringProperty name;
	private final SimpleStringProperty address;
	private final SimpleStringProperty city;
	private final SimpleStringProperty phone;
	private final SimpleStringProperty cell;
	private final SimpleStringProperty email;
	private final SimpleObjectProperty<LocalDate> dob;
	private final SimpleIntegerProperty age;
	private final SimpleStringProperty marital;
	private final SimpleStringProperty gender;
	private final SimpleStringProperty dep;
	//make cert collection here
	private ArrayList<CertificateBean> certs = new ArrayList<>();
	DBaccess dba = new DBaccess();
	
	public EmployeeBean(){
		this.empID = new SimpleIntegerProperty(1);
		this.name = new SimpleStringProperty("name");
		this.address = new SimpleStringProperty("address");
		this.city = new SimpleStringProperty("city");
		this.phone = new SimpleStringProperty("phone");
		this.cell = new SimpleStringProperty("cell");
		this.email = new SimpleStringProperty("email");
		this.dob = new SimpleObjectProperty<LocalDate>(LocalDate.of(2016, 5, 22));
		this.age = new SimpleIntegerProperty(22);
		this.marital = new SimpleStringProperty("marital");
		this.gender = new SimpleStringProperty("gender");
		this.dep = new SimpleStringProperty("electrical");
	}
	public ArrayList<CertificateBean> getCertsAL(){
		return certs;
	}
	public void setCertsAl(ArrayList<CertificateBean> cert){
		certs = cert;
	}
	public CertificateBean getCert(int index){
		if(certs.size()==0){
			return new CertificateBean();
		}else{
			return certs.get(index);
		}
		
		
	}
	
	public int getEmpID() {
		return empID.get();
	}
	public void setEmpID(int empid){
		this.empID.set(empid);
	}
	public SimpleIntegerProperty empIDProperty(){
		return empID;
	}
	public String getName(){
		return name.get();
	}
	public void setName(String name){
		this.name.set(name);
	}
	public SimpleStringProperty nameProperty(){
		return name;
	}
	
	public String getAddress(){
		return address.get();
	}
	public void setAddress(String ad){
		this.address.set(ad);
	}
	public SimpleStringProperty addressProperty(){
		return address;
	}
	
	
	public String getCity(){
		return city.get();
	}
	public void setCity(String ci){
		this.city.set(ci);
	}
	public SimpleStringProperty cityProperty(){
		return city;
	}
	
	public String getPhone(){
		return phone.get();
	}
	public void setPhone(String ph){
		this.phone.set(ph);
	}
	public SimpleStringProperty phoneProperty(){
		return phone;
	}
	
	
	public String getCell(){
		return cell.get();
	}
	public void setCell(String cell){
		this.cell.set(cell);
	}
	public SimpleStringProperty cellProperty(){
		return cell;
	}
	
	
	public String getEmail(){
		return email.get();
	}
	public void setEmail(String e){
		this.email.set(e);
	}
	public SimpleStringProperty emailProperty(){
		return email;
	}
	
	public LocalDate  getDob(){
		return dob.get();
	}
	public void setDob(LocalDate date){
		this.dob.set(date);
	}
	public SimpleObjectProperty<LocalDate> dobProperty(){
		return dob;
	}
	
	public int getAge(){
		return age.get();
	}
	public void setAge(int e){
		this.age.set(e);
	}
	public SimpleIntegerProperty ageProperty(){
		return age;
	}
	
	public String getMarital(){
		return marital.get();
	}
	public void setMarital(String m){
		this.marital.set(m);
	}
	public SimpleStringProperty maritalProperty(){
		return marital;
	}
	
	
	public String getGender(){
		return gender.get();
	}
	public void setGender(String g){
		this.gender.set(g);
	}
	public SimpleStringProperty genderProperty(){
		return gender;
	}
	
	public String getDep(){
		return dep.get();
	}
	public void setDep(String d){
		this.dep.set(d);
	}
	public SimpleStringProperty depProperty(){
		return dep;
	}
	
}
