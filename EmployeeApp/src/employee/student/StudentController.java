package employee.student;

import java.util.*;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import employee.Main;
import employee.db.DBaccess;
import employee.db.EmployeeBean;
import employee.db.PaperBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class StudentController implements Initializable{
	
	Main main;
	DBaccess dba = new DBaccess();
	int paperIndex =0;
	double Percent=0.0;
	double Failed=0.0;
	double Empty=0.0;
	
	@FXML
	private void addPaper() throws IOException{
		main.showAddPaperStage();
	}

	//pie chart
	@FXML
	PieChart pieChart;
	@FXML
	Label pieLbl;
	
	//line chart
	@FXML
	LineChart<String, Number> lineChart;
	@FXML
	Label lbl;
	
	//table view
	@FXML
	private TableView<PaperBean> table;
	@FXML
	private TableColumn<PaperBean, String> TcolPaper;
	@FXML
	private TableColumn<PaperBean, String> TcolCode;
	@FXML
	private TableColumn<PaperBean, String> TcolSemester;
	@FXML
	private TableColumn<PaperBean, Integer> TcolLevel;
	@FXML
	private TableColumn<PaperBean, Integer> TcolPercent;
	@FXML
	private TableColumn<PaperBean, Integer> TcolValue;
	@FXML
	private TableColumn<PaperBean, Integer> TcolWeight;
	@FXML
	private TableColumn<PaperBean, Integer> TcolResult;
	@FXML
	private TableColumn<PaperBean, String> TcolProjected;
	
	//result box right
	@FXML
	private TextField A1v;
	@FXML
	private TextField A1w;
	@FXML
	private TextField A1r;
	@FXML
	private TextField A2v;
	@FXML
	private TextField A2w;
	@FXML
	private TextField A2r;
	@FXML
	private TextField A3v;
	@FXML
	private TextField A3w;
	@FXML
	private TextField A3r;
	@FXML
	private TextField A4v;
	@FXML
	private TextField A4w;
	@FXML
	private TextField A4r;
	@FXML
	private TextField A5v;
	@FXML
	private TextField A5w;
	@FXML
	private TextField A5r;
	@FXML
	private TextField A6v;
	@FXML
	private TextField A6w;
	@FXML
	private TextField A6r;
	@FXML
	private Label A7Vtotal;
	@FXML
	private Label A7Wtotal;
	@FXML
	private Label A7Rtotal;
	@FXML
	private Button commitUp;
	@FXML
	private Button delete;
	
	public ObservableList<PaperBean> paperB = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		paperB = dba.getPaper();
		TcolPaper.setCellValueFactory(new PropertyValueFactory<PaperBean, String>("paper"));
		TcolPaper.setPrefWidth(150);
		TcolCode.setCellValueFactory(new PropertyValueFactory<PaperBean, String>("code"));
		TcolSemester.setCellValueFactory(new PropertyValueFactory<PaperBean, String>("semester"));
		TcolLevel.setCellValueFactory(new PropertyValueFactory<PaperBean, Integer>("level"));
		TcolPercent.setCellValueFactory(new PropertyValueFactory<PaperBean, Integer>("percent"));
		TcolValue.setCellValueFactory(new PropertyValueFactory<PaperBean, Integer>("value"));
		TcolWeight.setCellValueFactory(new PropertyValueFactory<PaperBean, Integer>("weight"));
		TcolResult.setCellValueFactory(new PropertyValueFactory<PaperBean, Integer>("result"));
		TcolProjected.setCellValueFactory(new PropertyValueFactory<PaperBean, String>("projected"));
        table.setItems(paperB);
        table.getSelectionModel().select(paperIndex);
		table.scrollTo(paperIndex);
		showResultsBox();
		calPieChart();
		showPieChart();
		showLineChart();
		

		//paperB.forEach(e->{ 
		//	System.out.println(e.getPaper());
		//});

		table.setOnMouseClicked(event ->{
			paperIndex = table.getSelectionModel().getSelectedIndex();
			showResultsBox();
			calPieChart();
			showPieChart();
			showLineChart();
		});
		
		table.setOnKeyPressed(event-> {
			switch (event.getCode()){
			case UP:
				moveUpTable();
				showResultsBox();
				showLineChart();
				showPieChart();
				event.consume();
				
				break;
			case DOWN:
				moveDownTable();
				showResultsBox();
				showLineChart();
				showPieChart();
				event.consume();

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
	public void moveUpTable(){
		if(paperIndex>0){
			paperIndex--;
			//System.out.println(paperIndex+" after up arrow");
			table.getSelectionModel().select(paperIndex);
			table.scrollTo(paperIndex);
			
		}
	}
	public void moveDownTable(){
		if(paperB.size()-1>paperIndex){
			paperIndex++;
			//System.out.println(paperIndex+" after Down arrow");
			table.getSelectionModel().select(paperIndex);
			table.scrollTo(paperIndex);
		}
	}
	
	public void showResultsBox(){
		
		A1v.setText(paperB.get(paperIndex).getA1v().toString());
		A1w.setText(paperB.get(paperIndex).getA1w().toString());
		A1r.setText(paperB.get(paperIndex).getA1r().toString());
		
		A2v.setText(paperB.get(paperIndex).getA2v().toString());
		A2w.setText(paperB.get(paperIndex).getA2w().toString());
		A2r.setText(paperB.get(paperIndex).getA2r().toString());
		
		A3v.setText(paperB.get(paperIndex).getA3v().toString());
		A3w.setText(paperB.get(paperIndex).getA3w().toString());
		A3r.setText(paperB.get(paperIndex).getA3r().toString());
		
		A4v.setText(paperB.get(paperIndex).getA4v().toString());
		A4w.setText(paperB.get(paperIndex).getA4w().toString());
		A4r.setText(paperB.get(paperIndex).getA4r().toString());
		
		A5v.setText(paperB.get(paperIndex).getMidv().toString());
		A5w.setText(paperB.get(paperIndex).getMidw().toString());
		A5r.setText(paperB.get(paperIndex).getMidr().toString());
		
		A6v.setText(paperB.get(paperIndex).getFv().toString());
		A6w.setText(paperB.get(paperIndex).getFw().toString());
		A6r.setText(paperB.get(paperIndex).getFr().toString());
		
		calculate();
		
	}
	
	public void showLineChart(){
		lineChart.getData().clear();
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.getData().add(new XYChart.Data<String, Number>("A1",paperB.get(paperIndex).getA1r()));
		series1.getData().add(new XYChart.Data<String, Number>("A2",paperB.get(paperIndex).getA2r()));
		series1.getData().add(new XYChart.Data<String, Number>("Mid",paperB.get(paperIndex).getMidr()));
		series1.getData().add(new XYChart.Data<String, Number>("A3",paperB.get(paperIndex).getA3r()));
		series1.getData().add(new XYChart.Data<String, Number>("A4",paperB.get(paperIndex).getA4r()));
		series1.getData().add(new XYChart.Data<String, Number>("Final",paperB.get(paperIndex).getFr()));
		series1.setName("Paper Marks");
		
		lineChart.getData().addAll(series1);
		
		for(final XYChart.Data<String, Number> data : series1.getData()){
			data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED,new javafx.event.EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					lbl.setText("X : "+data.getXValue()+" Y : "+String.valueOf(data.getYValue()));
					Tooltip.install(data.getNode(), new Tooltip("X : "+data.getXValue()+" Y : "+String.valueOf(data.getYValue())));
				}
			});
		}
	}
	
	public void calPieChart(){
		double Total=100.0;
		double Weight=0.0;
		double Value=0.0;
		double Result=0.0;
		
		
		if(((paperB.get(paperIndex).getA1r()!=0)&&(paperB.get(paperIndex).getA1v()!=0)&&(paperB.get(paperIndex).getA1w()!=0))){
			Result += paperB.get(paperIndex).getA1r();
			Weight += paperB.get(paperIndex).getA1w();
			Value += paperB.get(paperIndex).getA1v();
		}
		if(((paperB.get(paperIndex).getA2r()!=0)&&(paperB.get(paperIndex).getA2v()!=0)&&(paperB.get(paperIndex).getA2w()!=0))){
			Result += paperB.get(paperIndex).getA2r();
			Weight += paperB.get(paperIndex).getA2w();
			Value += paperB.get(paperIndex).getA2v();
		}
		if(((paperB.get(paperIndex).getA3r()!=0)&&(paperB.get(paperIndex).getA3v()!=0)&&(paperB.get(paperIndex).getA3w()!=0))){
			Result += paperB.get(paperIndex).getA3r();
			Weight += paperB.get(paperIndex).getA3w();
			Value += paperB.get(paperIndex).getA3v();
		}
		if(((paperB.get(paperIndex).getA4r()!=0)&&(paperB.get(paperIndex).getA4v()!=0)&&(paperB.get(paperIndex).getA4w()!=0))){
			Result += paperB.get(paperIndex).getA4r();
			Weight += paperB.get(paperIndex).getA4w();
			Value += paperB.get(paperIndex).getA4v();
		}
		if(((paperB.get(paperIndex).getMidr()!=0)&&(paperB.get(paperIndex).getMidv()!=0)&&(paperB.get(paperIndex).getMidw()!=0))){
			Result += paperB.get(paperIndex).getMidr();
			Weight += paperB.get(paperIndex).getMidw();
			Value += paperB.get(paperIndex).getMidv();
		}
		if(((paperB.get(paperIndex).getFr()!=0)&&(paperB.get(paperIndex).getFv()!=0)&&(paperB.get(paperIndex).getFw()!=0))){
			Result += paperB.get(paperIndex).getFr();
			Weight += paperB.get(paperIndex).getFw();
			Value += paperB.get(paperIndex).getFv();
		}
		Percent = ((100/Value)*Result);
		Empty = 100-Weight;
		Failed = Total-(Percent+Empty);
	}
	
	public void showPieChart(){
		calPieChart();
		ObservableList<Data> pieList =  FXCollections.observableArrayList(
				new PieChart.Data("Percent Passed", Percent),
				new PieChart.Data("Not Completed", Empty),
				new PieChart.Data("Percent Failed", Failed)
				
				);
		
		pieChart.setData(pieList);
		for(final PieChart.Data data: pieChart.getData()){
			data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new javafx.event.EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					pieLbl.setText(String.valueOf(data.getPieValue())+"%");
					
				}
			});
		}
	}
	public void commitUpdate(){
		
		PaperBean pbSave = paperB.get(paperIndex);
		pbSave.setPaperID(paperB.get(paperIndex).getPaperID());
		pbSave.setA1v(getInt(A1v.getText()));
		pbSave.setA1w(getInt(A1w.getText()));
		pbSave.setA1r(getInt(A1r.getText()));
		pbSave.setA2v(getInt(A2v.getText()));
		pbSave.setA2w(getInt(A2w.getText()));
		pbSave.setA2r(getInt(A2r.getText()));
		pbSave.setA3v(getInt(A3v.getText()));
		pbSave.setA3w(getInt(A3w.getText()));
		pbSave.setA3r(getInt(A3r.getText()));
		pbSave.setA4v(getInt(A4v.getText()));
		pbSave.setA4w(getInt(A4w.getText()));
		pbSave.setA4r(getInt(A4r.getText()));
		pbSave.setMidv(getInt(A5v.getText()));
		pbSave.setMidw(getInt(A5w.getText()));
		pbSave.setMidr(getInt(A5r.getText()));
		pbSave.setFv(getInt(A6v.getText()));
		pbSave.setFw(getInt(A6w.getText()));
		pbSave.setFr(getInt(A6r.getText()));
		pbSave.setValue(getInt(A7Vtotal.getText()));
		pbSave.setWeight(getInt(A7Wtotal.getText()));
		pbSave.setValue(getInt(A7Rtotal.getText()));
		dba.updatePaper(paperB.get(paperIndex));
	}
	public int getInt(String input){
		int answer=0;
		try{
			answer = Integer.parseInt(input);
		}catch(NumberFormatException e){
			answer =0;
		}
		return answer;
	}
	public void calculate(){
		double weight=0;
		double value=0;
		double result=0.0;
		double percent=0.0;
		
		value += paperB.get(paperIndex).getA1v();
		value += paperB.get(paperIndex).getA2v();
		value += paperB.get(paperIndex).getA3v();
		value += paperB.get(paperIndex).getA4v();
		value += paperB.get(paperIndex).getMidv();
		value += paperB.get(paperIndex).getFv();
		A7Vtotal.setText(String.valueOf(value));
		paperB.get(paperIndex).setValue((int)value);
		weight += paperB.get(paperIndex).getA1w();
		weight += paperB.get(paperIndex).getA2w();
		weight += paperB.get(paperIndex).getA3w();
		weight += paperB.get(paperIndex).getA4w();
		weight += paperB.get(paperIndex).getMidw();
		weight += paperB.get(paperIndex).getFw();
		A7Wtotal.setText(String.valueOf(weight));
		paperB.get(paperIndex).setWeight((int)weight);
		result += paperB.get(paperIndex).getA1r();
		result += paperB.get(paperIndex).getA2r();
		result += paperB.get(paperIndex).getA3r();
		result += paperB.get(paperIndex).getA4r();
		result += paperB.get(paperIndex).getMidr();
		result += paperB.get(paperIndex).getFr();
		percent = ((100/value)*result);
		A7Rtotal.setText(String.valueOf(percent));
		paperB.get(paperIndex).setResult((int)percent);
		
	}
	public void deleteRow(){
		System.out.println("delete row"+ paperIndex);
		System.out.println("paper id to delete "+paperB.get(paperIndex).getPaperID());
	}
	
	
}
