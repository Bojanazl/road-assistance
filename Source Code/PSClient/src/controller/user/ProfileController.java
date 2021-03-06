package controller.user;

import java.util.ArrayList;

import client.ClientCommunication;
import controller.administrator.AddNewUserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.User;

public class ProfileController {

	private ClientCommunication clientComm;
	private User user;
	private double stageHeight;
	private double stageWidth;
	@FXML Button updateUserButton;
	@FXML HBox avatarBox;
	@FXML HBox infoBox;
	@FXML ImageView avatar;
	@FXML ImageView phoneImage;
	@FXML ImageView emailImage;
	@FXML ImageView mailImage;
	@FXML Label name;
	@FXML Label lastName;
	@FXML Label username;
	@FXML Label userType;
	@FXML Label qualification;
	@FXML VBox userDataBox;

	@FXML public void initialize() {
		if(user.getType() == "Supervizor")
			userDataBox.getChildren().remove(updateUserButton);
		resize();
		name.setText("Ime:                     " + user.getName());
		lastName.setText("Prezime:              " + user.getLastName());
		username.setText("Korisnicko ime:     " + user.getUsername());
		userType.setText("Tip korisnika:       " + user.getType());
		qualification.setText("Kvalifikacjia:        " + user.getQualification());
	}
	
	public ProfileController(ClientCommunication clientComm, User user, double stageWidth, double stageHeight) {
		this.clientComm = clientComm;
		this.user = user;
		this.stageWidth = stageWidth;
		this.stageHeight = stageHeight;
	}
	
	
	
	public void updateUser() {
		Stage updateUserStage = new Stage();
		ArrayList<User> userUpdate = new ArrayList<>();
		userUpdate.add(user);
		ObservableList<User> observableUser = FXCollections.observableArrayList(userUpdate);
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/administrator/AddNewUserForm.fxml"));
			loader.setControllerFactory(e -> new AddNewUserController(updateUserStage, clientComm, observableUser, true, stageWidth,
					stageHeight));
			Parent updateUserView = loader.load();
			updateUserStage.setScene(new Scene(updateUserView, stageWidth, stageHeight));
			updateUserStage.initModality(Modality.APPLICATION_MODAL);
			updateUserStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resize() {
		AnchorPane.setBottomAnchor(avatarBox, stageHeight * 0.8);
		avatar.setFitHeight(stageHeight * 0.8);
		avatar.setFitWidth(stageWidth * 0.5);
		mailImage.setFitHeight(stageHeight * 0.2);
		mailImage.setFitWidth(stageWidth * 0.25);
		AnchorPane.setTopAnchor(infoBox, stageHeight * 0.3);
		AnchorPane.setBottomAnchor(infoBox, stageHeight * 0.6);
		AnchorPane.setTopAnchor(userDataBox, stageHeight * 0.7);
	}
}