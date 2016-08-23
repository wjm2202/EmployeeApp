package employee.db;

import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CertificateBean {
	
	private final IntegerProperty certID;
	private final IntegerProperty empID;
	private final StringProperty certNum;
	private final StringProperty certProv;
	private final StringProperty certType;
	private final StringProperty certDesc;
	private final ObjectProperty<LocalDate> certStart;
	private final ObjectProperty<LocalDate> certExp;
	private final ObjectProperty<LocalDate> rebook;
	
	public CertificateBean(){
		this.certID = new SimpleIntegerProperty(1);
		this.empID = new SimpleIntegerProperty(1);
		this.certNum = new SimpleStringProperty("certNum");
		this.certProv = new SimpleStringProperty("provider");
		this.certType = new SimpleStringProperty("type");
		this.certDesc = new SimpleStringProperty("description");
		this.certStart = new SimpleObjectProperty<LocalDate>(LocalDate.of(2016, 5, 23));
		this.certExp = new SimpleObjectProperty<LocalDate>(LocalDate.of(2016, 10, 23));
		this.rebook = new SimpleObjectProperty<LocalDate>(LocalDate.of(2016, 7, 23));
		
	}

	public int getCertID(){
		return certID.get();
	}
	public void setCertID(int cid){
		this.certID.set(cid);
	}
	public IntegerProperty certIDProperty(){
		return certID;
	}
	
	public int getEmpID(){
		return empID.get();
	}
	public void setEmpID(int eid){
		this.empID.set(eid);
	}
	public IntegerProperty empIDProperty(){
		return empID;
	}
	
	public String getCertNum(){
		return certNum.get();
	}
	public void setCertNum(String cn){
		this.certNum.set(cn);
	}
	public StringProperty certNumProperty(){
		return certNum;
	}
	
	
	public String getCertProv(){
		return certProv.get();
	}
	public void setCertProv(String cp){
		this.certProv.set(cp);
	}
	public StringProperty certProvProperty(){
		return certProv;
	}
	
	public String getCertType(){
		return certType.get();
	}
	public void setCertType(String cp){
		this.certType.set(cp);
	}
	public StringProperty certTypeProperty(){
		return certType;
	}
	
	
	public String getCertDesc(){
		return certDesc.get();
	}
	public void setCertDesc(String cd){
		this.certDesc.set(cd);
	}
	public StringProperty CertDescProperty(){
		return certDesc;
	}

	
	public LocalDate getCertStart(){
		return certStart.get();
	}
	public void setCertStart(LocalDate date){
		this.certStart.set(date);
	}
	public ObjectProperty<LocalDate> certStartProperty(){
		return certStart;
	}

	
	
	public LocalDate getCertExp(){
		return certExp.get();
	}
	public void setCertExp(LocalDate ce){
		this.certExp.set(ce);
	}
	public ObjectProperty<LocalDate> certExpProperty(){
		return certExp;
	}
	
	
	
	public LocalDate getRebook(){
		return rebook.get();
	}
	public void setRebook(LocalDate rb){
		this.rebook.set(rb);
	}
	public ObjectProperty<LocalDate> rebbokProperty(){
		return rebook;
	}
}
