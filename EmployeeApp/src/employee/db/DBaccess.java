package employee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBaccess {

	//database must be disconnected for code to function
	
	public Connection getCon(){
		Connection conn = null;
		String dbURL = "jdbc:derby:empDB;create=true";
		String user = "wjm2202";
		String password = "UnrealNetworkCoding22";
		
		try {
			conn = DriverManager.getConnection(dbURL, user, password);
		//System.out.println("conn success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	private ArrayList<Integer> getAllCertIDs(int empID){
		ArrayList<Integer> cb = new ArrayList<>();
		Connection conn = getCon();
		ResultSet rs = null;
		String sqlS = "select * from APP.EMPCERT Where  empID= ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sqlS);
			ps.setInt(1, empID);
			rs = ps.executeQuery();
			while(rs.next()){
				cb.add(rs.getInt(1));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cb;
	}
	
	public ArrayList<CertificateBean> getCertAL(int eid){
		ArrayList<CertificateBean> results = new ArrayList<>();
		//System.out.println("in dba in getcertal  eid  "+eid);
		Connection conn = getCon();
		ResultSet rs = null;
		String sqlS = "select * from APP.Cert Where  empID= ?";
		PreparedStatement ps;
		int testRS =1;
		try {
			ps = conn.prepareStatement(sqlS);
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			while(rs.next()){
				//System.out.println("inside get cert al  number of results "+testRS++ +"  eid  "+eid);
				CertificateBean cert = new CertificateBean();
				cert.setCertID(rs.getInt(1));
				cert.setEmpID(rs.getInt(2));
				cert.setCertNum(rs.getString(3));
				cert.setCertProv(rs.getString(4));
				cert.setCertType(rs.getString(5));
				//System.out.println("get cert all  certNum "+rs.getString(3));
				cert.setCertDesc(rs.getString(6));
				cert.setCertStart(convertToLocalDate(rs.getDate(7)));
				cert.setCertExp(convertToLocalDate(rs.getDate(8)) );
				cert.setRebook(convertToLocalDate(rs.getDate(9)) );
				results.add(cert);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public ObservableList<EmployeeBean> getEmpAL(String dep){
		ObservableList<EmployeeBean> emps = FXCollections.observableArrayList();
		ArrayList<Integer> certNums = new ArrayList<>();
		Connection conn = getCon();
		ResultSet rs = null;
		String sqlS = "select * from APP.EMPLOYEE Where DEP = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sqlS);
			ps.setString(1, dep);
			rs = ps.executeQuery();
			while(rs.next()){
				EmployeeBean emp = new EmployeeBean();
				emp.setEmpID(rs.getInt("empID"));
				//System.out.println("emp id in getEmpAL    "+emp.getEmpID());
				emp.setName(rs.getString("name"));
				emp.setAddress(rs.getString("address"));
				emp.setCity(rs.getString("city"));
				emp.setPhone(rs.getString("phone"));
				emp.setCell(rs.getString("cell"));
				emp.setEmail(rs.getString("email"));
				//System.out.println("in dba in getEmpAL  email  "+rs.getString(7));
				emp.setDob(convertToLocalDate(rs.getDate("D_O_B")));
				emp.setAge(rs.getInt("age"));
				emp.setMarital(rs.getString("marital"));
				emp.setGender(rs.getString("gender"));
				emp.setDep(rs.getString("dep"));
				emp.setCertsAl(getCertAL(emp.getEmpID()));
				emps.add(emp);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}
	
	public LocalDate convertToLocalDate(java.sql.Date date2){
		LocalDate lDate = LocalDate.of(2014, Month.JANUARY, 1);
		if(date2==null){
			return lDate;
		}else{
			lDate = date2.toLocalDate();
			return lDate;
		}
	}

	public void testEID(){
		Connection conn = getCon();
		ResultSet rs = null;
		String sqlS = "select * from APP.EMPLOYEE";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sqlS);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("empID"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void recreateAllTables(){
		//dropTables();
		//System.out.println("tables dropped");
		makeTableEmp();
		makeTableCert();
		makeTableEmpCert();
		makeTableStudent();
		//System.out.println("tables recreated");
		
	}
	
/*	public void dropTables(){
		Connection conn = getCon();
		String sqlS = "DROP TABLE APP.EMPLOYEE";
		String sq ="DROP table APP.Student";
		String sql = "DROP TABLE APP.CERT";
		PreparedStatement ps;
		try {
			//ps = conn.prepareStatement(sqlS);
			//ps.execute();
			//ps = conn.prepareStatement(sq);
			//ps.execute();
			//makeTableStudent();
			//ps = conn.prepareStatement(sql);
			//ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}                                                     */
	
	public boolean makeTableEmpCert(){
		Connection conn = getCon();
		PreparedStatement ps=null;
		String sqlS="";
		if(conn!=null){
			try {
				java.sql.DatabaseMetaData dbmd = conn.getMetaData();
				ResultSet rs = dbmd.getTables(null, null, "APP.EMPCERT", null);
				if(rs.next()){
					System.out.println("table exists");
				}else{
					sqlS = "create table APP.EMPCERT"+
							"(empID INT not Null, certID int not NULL)";
							ps = conn.prepareStatement(sqlS);
							ps.execute();
							System.out.println("new table created");
				}
			} catch (SQLException e) {
				System.out.println("table create failed");
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean makeTableStudent(){
		Connection conn = getCon();
		PreparedStatement ps=null;
		String sqlS="";
		if(conn!=null){
			try {
				java.sql.DatabaseMetaData dbmd = conn.getMetaData();
				ResultSet rs = dbmd.getTables(null, null, "APP.STUDENT", null);
				if(rs.next()){
					System.out.println("table exists");
				}else{
					sqlS = "create table APP.Student"+
							"(paperID INT not Null Generated ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+ 
							"paper varchar(26),code varchar(20),"+
							"semester varchar(30),level INT,"+
							"percent INT,value INT,weight INT, result INT,"+
							"projected varchar(5),"+
							"A1v INT,A1w INT,A1r INT,"+
							"A2v INT,A2w INT,A2r INT,"+
							"A3v INT,A3w INT,A3r INT,"+
							"A4v INT,A4w INT,A4r INT,"+
							"A5v INT,A5w INT,A5r INT,"+
							"A6v INT,A6w INT,A6r INT,"+
							"valueTotal INT, weightTotal INT, resultTotal INT)";
							ps = conn.prepareStatement(sqlS);
							ps.execute();
							System.out.println("new table created");
				}
			} catch (SQLException e) {
				System.out.println("table create failed");
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean makeTableEmp(){
		Connection conn = getCon();
		PreparedStatement ps=null;
		String sqlS="";
		if(conn!=null){
			try {
				java.sql.DatabaseMetaData dbmd = conn.getMetaData();
				ResultSet rs = dbmd.getTables(null, null, "APP.EMPLOYEE", null);
				if(rs.next()){
					System.out.println("table exists");
				}else{
					sqlS = "create table APP.EMPLOYEE"+
							"(empID INT not Null Generated ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+ 
							"name varchar(26),address varchar(100),"+
							"city varchar(30),phone varchar(20),"+
							"cell varchar(20),email varchar(30),"+
							"D_O_B DATE,age int,marital varchar(10),"+
							"gender varchar(10),dep varchar(20))";
							ps = conn.prepareStatement(sqlS);
							ps.execute();
							System.out.println("new table created");
				}
			} catch (SQLException e) {
				System.out.println("table create failed");
				e.printStackTrace();
			}
		}
		return true;
	}
	public boolean makeTableCert(){
		Connection conn = getCon();
		PreparedStatement ps=null;
		String sqlS="";
		if(conn!=null){
			try {
				java.sql.DatabaseMetaData dbmd = conn.getMetaData();
				ResultSet rs = dbmd.getTables(null, null, "APP.CERT", null);
				if(rs.next()){
					System.out.println("table exists");
				}else{
					sqlS = "create table APP.CERT"+
							"(certID INT not Null Generated ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
							"empID int,certNum varchar(30),"+
							"certProv varchar(50),certType varchar(20),"+
							"certDesc varchar(20),certStart DATE,"+
							"certExpire DATE,rebook DATE)";
							ps = conn.prepareStatement(sqlS);
							ps.execute();
							System.out.println("new table created");
				}
			} catch (SQLException e) {
				System.out.println("table create failed");
				e.printStackTrace();
			}
		}
		
		
		return true;
	}
	
	public ObservableList<PaperBean> getPaper(){ 						// Saves the users current score to the database
		int eid=0;
		ResultSet rs=null;
		Connection conn = getCon();
		ObservableList<PaperBean> papers = FXCollections.observableArrayList();
		
		String sqlS = "Select paperID,paper,code,semester,level,percent,value,weight,result,projected,"+
		"A1v,A1w,A1r,"+
		"A2v,A2w,A2r,"+
		"A3v,A3w,A3r,"+
		"A4v,A4w,A4r,"+
		"A5v,A5w,A5r,"+
		"A6v,A6w,A6r,"+
		"valueTotal,weightTotal,resultTotal"+
		" from APP.Student";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlS);
			rs = ps.executeQuery();
			
			while(rs.next()){
				PaperBean pb = new PaperBean();
				pb.setPaperID(rs.getInt(1));
				pb.setPaper(rs.getString(2));
				pb.setCode(rs.getString(3));
				pb.setSemester(rs.getString(4));
				pb.setLevel(rs.getInt(5));
				pb.setPercent(rs.getInt(6));
				pb.setValue(rs.getInt(7));
				pb.setWeight(rs.getInt(8));
				pb.setResult(rs.getInt(9));
				pb.setProjected(rs.getString(10));
				pb.setA1v(rs.getInt(11));
				pb.setA1w(rs.getInt(12));
				pb.setA1r(rs.getInt(13));
				pb.setA2v(rs.getInt(14));
				pb.setA2w(rs.getInt(15));
				pb.setA2r(rs.getInt(16));
				pb.setA3v(rs.getInt(17));
				pb.setA3w(rs.getInt(18));
				pb.setA3r(rs.getInt(19));
				pb.setA4v(rs.getInt(20));
				pb.setA4w(rs.getInt(21));
				pb.setA4r(rs.getInt(22));
				pb.setMidv(rs.getInt(23));
				pb.setMidw(rs.getInt(24));
				pb.setMidr(rs.getInt(25));
				pb.setFv(rs.getInt(26));
				pb.setFw(rs.getInt(27));
				pb.setFr(rs.getInt(28));
				pb.setA7Vtotal(rs.getInt(29));
				pb.setA7Wtotal(rs.getInt(30));
				pb.setA7Rtotal(rs.getInt(31));
				
				papers.add(pb);
			
			
			}
			
			conn.close();
			ps.close();
			//System.out.println("getPaper  success   " +eid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return papers;
	}
	
	public void updatePaper(PaperBean pb){ 						// Saves the users current score to the database
		int eid=0;
		ResultSet rs=null;
		Connection conn = getCon();
		String sqlS = "UPDATE APP.Student set paper=?,code=?,semester=?,level=?,percent=?,value=?,weight=?,result=?,projected=?,"+
		"A1v=?,A1w=?,A1r=?,"+
		"A2v=?,A2w=?,A2r=?,"+
		"A3v=?,A3w=?,A3r=?,"+
		"A4v=?,A4w=?,A4r=?,"+
		"A5v=?,A5w=?,A5r=?,"+
		"A6v=?,A6w=?,A6r=?,"+
		"valueTotal=?,weightTotal=?,resultTotal=? "+
		"where paperID=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlS);
			ps.setString(1, pb.getPaper());
			ps.setString(2, pb.getCode());
			ps.setString(3, pb.getSemester());
			ps.setInt(4, pb.getLevel());
			ps.setInt(5, pb.getPercent());
			ps.setInt(6, pb.getValue());
			ps.setInt(7, pb.getWeight());
			ps.setInt(8, pb.getResult());
			ps.setString(9, pb.getProjected());
			ps.setInt(10, pb.getA1v());
			ps.setInt(11, pb.getA1w());
			ps.setInt(12, pb.getA1r());
			ps.setInt(13, pb.getA2v());
			ps.setInt(14, pb.getA2w());
			ps.setInt(15, pb.getA2r());
			ps.setInt(16, pb.getA3v());
			ps.setInt(17, pb.getA3w());
			ps.setInt(18, pb.getA3r());
			ps.setInt(19, pb.getA4v());
			ps.setInt(20, pb.getA4w());
			ps.setInt(21, pb.getA4r());
			ps.setInt(22, pb.getMidv());
			ps.setInt(23, pb.getMidw());
			ps.setInt(24, pb.getMidr());
			ps.setInt(25, pb.getFv());
			ps.setInt(26, pb.getFw());
			ps.setInt(27, pb.getFr());
			ps.setInt(28, pb.getA7Vtotal());
			ps.setInt(29, pb.getA7Wtotal());
			ps.setInt(30, pb.getA7Rtotal());
			ps.setInt(31, pb.getPaperID());
			ps.executeUpdate();

			conn.close();
			ps.close();
			//System.out.println("update paper success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int savePaper(PaperBean pb){ 						// Saves the users current score to the database
		int eid=0;
		ResultSet rs=null;
		Connection conn = getCon();
		String sqlS = "INSERT into APP.Student (paper,code,semester,level,percent,value,weight,result,projected,"+
		"A1v,A1w,A1r,"+
		"A2v,A2w,A2r,"+
		"A3v,A3w,A3r,"+
		"A4v,A4w,A4r,"+
		"A5v,A5w,A5r,"+
		"A6v,A6w,A6r,"+
		"valueTotal,weightTotal,resultTotal)"+
		"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlS, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pb.getPaper());
			ps.setString(2, pb.getCode());
			ps.setString(3, pb.getSemester());
			ps.setInt(4, pb.getLevel());
			ps.setInt(5, pb.getPercent());
			ps.setInt(6, pb.getValue());
			ps.setInt(7, pb.getWeight());
			ps.setInt(8, pb.getResult());
			ps.setString(9, pb.getProjected());
			ps.setInt(10, pb.getA1v());
			ps.setInt(11, pb.getA1w());
			ps.setInt(12, pb.getA1r());
			ps.setInt(13, pb.getA2v());
			ps.setInt(14, pb.getA2w());
			ps.setInt(15, pb.getA2r());
			ps.setInt(16, pb.getA3v());
			ps.setInt(17, pb.getA3w());
			ps.setInt(18, pb.getA3r());
			ps.setInt(19, pb.getA4v());
			ps.setInt(20, pb.getA4w());
			ps.setInt(21, pb.getA4r());
			ps.setInt(22, pb.getMidv());
			ps.setInt(23, pb.getMidw());
			ps.setInt(24, pb.getMidr());
			ps.setInt(25, pb.getFv());
			ps.setInt(26, pb.getFw());
			ps.setInt(27, pb.getFr());
			ps.setInt(28, pb.getA7Vtotal());
			ps.setInt(29, pb.getA7Wtotal());
			ps.setInt(30, pb.getA7Rtotal());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			eid = rs.getInt(1);
			conn.close();
			ps.close();
			//System.out.println("save paper success   " +eid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eid;
	}
	
	public int saveEmployee(EmployeeBean emp){ 						// Saves the users current score to the database
		int eid=0;
		ResultSet rs=null;
		Connection conn = getCon();
		String sqlS = "INSERT into APP.EMPLOYEE (name, address, city, phone, cell, email, D_O_B, age, marital, gender, dep) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlS, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getAddress());
			ps.setString(3, emp.getCity());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getCell());
			ps.setString(6, emp.getEmail());
			//System.out.println("in save employee in dba   "+emp.getEmail());
			ps.setDate(7, java.sql.Date.valueOf(emp.getDob()));
			ps.setInt(8, emp.getAge());
			ps.setString(9, emp.getMarital());
			ps.setString(10, emp.getGender());
			ps.setString(11, emp.getDep());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			eid = rs.getInt(1);
			conn.close();
			ps.close();
			//System.out.println("save employee success   " +eid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eid;
	}
	public int saveCertificate(CertificateBean cert){ 						// Saves the users current score to the database
		int cid=0;
		ResultSet rs=null;
		Connection conn = getCon();
		String sqlS = "INSERT into APP.CERT (empID, certNum, certProv, certType, certDesc, certStart, certExpire, rebook) values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlS, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cert.getEmpID());
			ps.setString(2, cert.getCertNum());
			//System.out.println("in save cert in dba  cerNum  "+cert.getCertNum());
			ps.setString(3, cert.getCertProv());
			ps.setString(4, cert.getCertType());
			ps.setString(5, cert.getCertDesc());
			ps.setDate(6, java.sql.Date.valueOf(cert.getCertStart()));
			ps.setDate(7, java.sql.Date.valueOf(cert.getCertExp()));
			ps.setDate(8, java.sql.Date.valueOf(cert.getRebook()));
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			cid = rs.getInt(1);
			conn.close();
			ps.close();
			//System.out.println("save cert success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cid;
	}
	public int saveEmpCert(int eid, int cid){ 						// Saves the users current score to the database
		
		Connection conn = getCon();
		String sqlS = "INSERT into APP.EMPCERT (empID, certID) values (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlS);
			ps.setInt(1, eid);
			ps.setInt(2, cid);
			ps.executeUpdate();
			conn.close();
			ps.close();
			//System.out.println("save empcert success   ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eid;
	}
}
