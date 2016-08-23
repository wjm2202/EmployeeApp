package employee.db;

import java.sql.Date;

public class Certificate {

	private int certID;
	private int empID;
	private String certNum;
	private String certPro;
	private String certType;
	private String certDesc;
	private Date certStart;
	private Date certExpire;
	private Date rebook;
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getCertNum() {
		return certNum;
	}
	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}
	public String getCertPro() {
		return certPro;
	}
	public void setCertPro(String certPro) {
		this.certPro = certPro;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertDesc() {
		return certDesc;
	}
	public void setCertDesc(String certDesc) {
		this.certDesc = certDesc;
	}
	public Date getCertStart() {
		return certStart;
	}
	public void setCertStart(Date certStart) {
		this.certStart = certStart;
	}
	public Date getCertExpire() {
		return certExpire;
	}
	public void setCertExpire(Date certExpire) {
		this.certExpire = certExpire;
	}
	public Date getRebook() {
		return rebook;
	}
	public void setRebook(Date rebook) {
		this.rebook = rebook;
	}
	public int getCertID() {
		return certID;
	}
	public void setCertID(int certID) {
		this.certID = certID;
	}
}
