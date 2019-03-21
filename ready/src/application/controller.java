package application;

import java.io.IOException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.MailServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class controller {

	@FXML
	private Label label;
	@FXML
	private JFXPasswordField pass;
	@FXML
	private JFXTextField user;
	@FXML
	private Label min;

	public controller() {

	}

	@FXML
	public void handclose(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	public void sign(ActionEvent event) throws IOException {
		String u = user.getText();
		String p = pass.getText();
		MailServer x = new MailServer();
		if (x.signin(u, p)) {
			Stage stages = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stages.hide();
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viewing.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setScene(new Scene(root1));
				stage.show();
				Main.window.hide();
			} catch (Exception e) {

			}

		} else {
			System.out.println("Do not match");
		}

	}

	@FXML
	public void show(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Maintwo.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(new Scene(root1));
			stage.show();
			Main.window.hide();
		} catch (Exception e) {

		}
	}

	@FXML
	public void Mini(MouseEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); // minimize the window
	}

}
