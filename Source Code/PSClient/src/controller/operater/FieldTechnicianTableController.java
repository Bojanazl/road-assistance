package controller.operater;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.FieldTechnician;

public class FieldTechnicianTableController {

	private ArrayList<FieldTechnician> technicians;
	@FXML AnchorPane tableAnchor;
	@FXML TableView<FieldTechnician> FieldTechnicianTable;
	
	@FXML public void initialize() {
		TableColumn<FieldTechnician, String> idColumn = new TableColumn<FieldTechnician, String>("Id");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		TableColumn<FieldTechnician, String> nameColumn = new TableColumn<FieldTechnician, String>("Ime");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<FieldTechnician, String> lastNameColumn = new TableColumn<FieldTechnician, String>("Prezime");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		TableColumn<FieldTechnician, String> stateColumn = new TableColumn<FieldTechnician, String>("Stanje");
		stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
		FieldTechnicianTable.getColumns().addAll(idColumn, nameColumn, lastNameColumn, stateColumn);
		FieldTechnicianTable.setItems(FXCollections.observableArrayList(technicians));
	}
	
	public FieldTechnicianTableController(ArrayList<FieldTechnician> technicians) {
		this.technicians = technicians;
	}
}
