package employee.db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PaperBean {

	private final SimpleIntegerProperty paperID;
	private final SimpleStringProperty paper;
	private final SimpleStringProperty code;
	private final SimpleStringProperty semester;
	private final SimpleIntegerProperty level;
	private final SimpleIntegerProperty percent;
	private final SimpleIntegerProperty value;
	private final SimpleIntegerProperty weight;
	private final SimpleIntegerProperty result;
	private final SimpleStringProperty projected;
	private final SimpleIntegerProperty A1v;
	private final SimpleIntegerProperty A1w;
	private final SimpleIntegerProperty A1r;
	private final SimpleIntegerProperty A2v;
	private final SimpleIntegerProperty A2w;
	private final SimpleIntegerProperty A2r;
	private final SimpleIntegerProperty A3v;
	private final SimpleIntegerProperty A3w;
	private final SimpleIntegerProperty A3r;
	private final SimpleIntegerProperty A4v;
	private final SimpleIntegerProperty A4w;
	private final SimpleIntegerProperty A4r;
	private final SimpleIntegerProperty midv;
	private final SimpleIntegerProperty midw;
	private final SimpleIntegerProperty midr;
	private final SimpleIntegerProperty fv;
	private final SimpleIntegerProperty fw;
	private final SimpleIntegerProperty fr;
	private final SimpleIntegerProperty A7Vtotal;
	private final SimpleIntegerProperty A7Wtotal;
	private final SimpleIntegerProperty A7Rtotal;
	
	public PaperBean(){
		 this.paperID = new SimpleIntegerProperty(1);
		 this.paper = new SimpleStringProperty("paperCode");
		 this.code = new SimpleStringProperty( "adm");
		this.semester = new SimpleStringProperty("s1");
		this.level=new SimpleIntegerProperty(1);
		this.percent=new SimpleIntegerProperty(1);
		this.value=new SimpleIntegerProperty(1);
		this.weight=new SimpleIntegerProperty(1);
		this.result=new SimpleIntegerProperty(1);
		this.projected = new SimpleStringProperty("z");
		this.A1v=new SimpleIntegerProperty(1);
		this.A1w=new SimpleIntegerProperty(1);
		this.A1r=new SimpleIntegerProperty(1);
		this.A2v=new SimpleIntegerProperty(1);
		this.A2w=new SimpleIntegerProperty(1);
		this.A2r=new SimpleIntegerProperty(1);
		this.A3v=new SimpleIntegerProperty(1);
		this.A3w=new SimpleIntegerProperty(1);
		this.A3r=new SimpleIntegerProperty(1);
		this.A4v=new SimpleIntegerProperty(1);
		this.A4w=new SimpleIntegerProperty(1);
		this.A4r=new SimpleIntegerProperty(1);
		this.midv=new SimpleIntegerProperty(1);
		this.midw=new SimpleIntegerProperty(1);
		this.midr=new SimpleIntegerProperty(1);
		this.fv=new SimpleIntegerProperty(1);
		this.fw=new SimpleIntegerProperty(1);
		this.fr=new SimpleIntegerProperty(1);
		this.A7Vtotal=new SimpleIntegerProperty(1);
		this.A7Wtotal=new SimpleIntegerProperty(1);
		this.A7Rtotal=new SimpleIntegerProperty(1);
	}
	
	
	public Integer getPaperID(){
		return paperID.get();
	}
	public void setPaperID(int id){
		paperID.set(id);
	}
	public SimpleIntegerProperty paperIDProperty() {
		return paperID;
	}
	
	public String getPaper(){
		return paper.get();
	}
	public void setPaper(String pap){
		paper.set(pap);
	}
	public SimpleStringProperty paperProperty() {
		return paper;
	}
	
	public String getCode(){
		return code.get();
	}
	public void setCode(String co){
		code.set(co);
	}
	public SimpleStringProperty codeProperty(){
		return code;
	}
	
	public String getSemester(){
		return semester.get();
	}
	public void setSemester(String sem){
		semester.set(sem);
	}
	public SimpleStringProperty semesterProperty(){
		return semester;
	}
	
	public Integer getLevel(){
		return level.get();
	}
	public void setLevel(int lvl){
		level.set(lvl);
	}
	public SimpleIntegerProperty levelProperty(){
		return level;
	}
	
	public Integer getPercent(){
		return percent.get();
	}
	public void setPercent(int co){
		percent.set(co);
	}
	public SimpleIntegerProperty percentProperty(){
		return percent;
	}
	
	public Integer getValue(){
		return value.get();
	}
	public void setValue(int val){
		percent.set(val);
	}
	public SimpleIntegerProperty valueProperty(){
		return value;
	}
	
	public Integer getWeight(){
		return weight.get();
	}
	public void setWeight(int wei){
		weight.set(wei);
	}
	public SimpleIntegerProperty weightProperty(){
		return weight;
	}
	
	public Integer getResult(){
		return result.get();
	}
	public void setResult(int res){
		result.set(res);
	}
	public SimpleIntegerProperty resultProperty(){
		return result;
	}
	
	public String getProjected(){
		return projected.get();
	}
	public void setProjected(String proj){
		projected.set(proj);
	}
	public SimpleStringProperty projectedProperty(){
		return projected;
	}
	
	public Integer getA1v(){
		return A1v.get();
	}
	public void setA1v(int a1v){
		A1v.set(a1v);
	}
	public SimpleIntegerProperty A1vProperty(){
		return A1v;
	}
	
	public Integer getA1w(){
		return A1w.get();
	}
	public void setA1w(int a1w){
		A1w.set(a1w);
	}
	public SimpleIntegerProperty A1wProperty(){
		return A1w;
	}
	
	public Integer getA1r(){
		return A1r.get();
	}
	public void setA1r(int a1r){
		A1r.set(a1r);
	}
	public SimpleIntegerProperty A1rProperty(){
		return A1r;
	}
	
	public Integer getA2v(){
		return A2v.get();
	}
	public void setA2v(int a2v){
		A2v.set(a2v);
	}
	public SimpleIntegerProperty A2vProperty(){
		return A2v;
	}
	
	public Integer getA2w(){
		return A2w.get();
	}
	public void setA2w(int a2w){
		A2w.set(a2w);
	}
	public SimpleIntegerProperty A2wProperty(){
		return A2w;
	}
	
	public Integer getA2r(){
		return A2r.get();
	}
	public void setA2r(int a2r){
		A2r.set(a2r);
	}
	public SimpleIntegerProperty A2rProperty(){
		return A2r;
	}
	
	public Integer getA3v(){
		return A3v.get();
	}
	public void setA3v(int a3v){
		A3v.set(a3v);
	}
	public SimpleIntegerProperty A3vProperty(){
		return A3v;
	}
	
	public Integer getA3w(){
		return A3w.get();
	}
	public void setA3w(int a3w){
		A3w.set(a3w);
	}
	public SimpleIntegerProperty A3wProperty(){
		return A3w;
	}
	
	public Integer getA3r(){
		return A3r.get();
	}
	public void setA3r(int a3r){
		A3r.set(a3r);
	}
	public SimpleIntegerProperty A3rProperty(){
		return A3r;
	}
	
	public Integer getA4v(){
		return A4v.get();
	}
	public void setA4v(int a4v){
		A4v.set(a4v);
	}
	public SimpleIntegerProperty A4vProperty(){
		return A4v;
	}
	
	public Integer getA4w(){
		return A4w.get();
	}
	public void setA4w(int a4w){
		A4w.set(a4w);
	}
	public SimpleIntegerProperty A4wProperty(){
		return A4w;
	}
	
	public Integer getA4r(){
		return A4r.get();
	}
	public void setA4r(int a4r){
		A4r.set(a4r);
	}
	public SimpleIntegerProperty A4rProperty(){
		return A4r;
	}
	
	public Integer getMidv(){
		return midv.get();
	}
	public void setMidv(int mi){
		midv.set(mi);
	}
	public SimpleIntegerProperty midvProperty(){
		return midv;
	}
	
	public Integer getMidw(){
		return midw.get();
	}
	public void setMidw(int m){
		midw.set(m);
	}
	public SimpleIntegerProperty midwProperty(){
		return midw;
	}
	
	public Integer getMidr(){
		return midr.get();
	}
	public void setMidr(int mr){
		midr.set(mr);
	}
	public SimpleIntegerProperty midrProperty(){
		return midr;
	}
	
	public Integer getFv(){
		return fv.get();
	}
	public void setFv(int FV){
		fv.set(FV);
	}
	public SimpleIntegerProperty fvProperty(){
		return fv;
	}
	
	public Integer getFw(){
		return fw.get();
	}
	public void setFw(int FW){
		fw.set(FW);
	}
	public SimpleIntegerProperty fwProperty(){
		return fw;
	}
	
	public Integer getFr(){
		return fr.get();
	}
	public void setFr(int FR){
		fr.set(FR);
	}
	public SimpleIntegerProperty frProperty(){
		return fr;
	}
	
	public Integer getA7Vtotal(){
		return A7Vtotal.get();
	}
	public void setA7Vtotal(int a7vT){
		A7Vtotal.set(a7vT);
	}
	public SimpleIntegerProperty A7VtotalProperty(){
		return A7Vtotal;
	}
	
	public Integer getA7Wtotal(){
		return A7Wtotal.get();
	}
	public void setA7Wtotal(int a7WT){
		A7Wtotal.set(a7WT);
	}
	public SimpleIntegerProperty A7WtotalProperty(){
		return A7Wtotal;
	}
	
	public Integer getA7Rtotal(){
		return A7Rtotal.get();
	}
	public void setA7Rtotal(int A7rto){
		A7Rtotal.set(A7rto);
	}
	public SimpleIntegerProperty A7RtotalProperty(){
		return A7Rtotal;
	}
	
}
