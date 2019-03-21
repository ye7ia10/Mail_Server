package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.Details;
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

public class MaintwoController {

	@FXML
	private Label label;
	@FXML
	private JFXTextField mail;
	@FXML
	private JFXPasswordField pass;
	@FXML
	private JFXTextField First;
	@FXML
	private JFXTextField Last;
	@FXML
	private JFXPasswordField repass;
	@FXML
	private Label min;
	@FXML
	private JFXTextField exist;




	public MaintwoController() {

	}

	@FXML
	public void Mini(MouseEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
	}

	@FXML
	public void handclose(MouseEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();

		} catch (Exception e) {

		}

	}

	@FXML
	public void make (ActionEvent event) {
		if (mail.getText().length() == 0 || pass.getText().length() == 0 ||
				First.getText().length() == 0 || Last.getText().length() == 0 ||
				repass.getText().length() == 0) {
			JOptionPane.showMessageDialog(null,"Please fill all cells");
		}else if (pass.getText().length() < 8){
			JOptionPane.showMessageDialog(null,"Password should be more than 8 digits");
		}
		else if (!repass.getText().equals(pass.getText())) {
			JOptionPane.showMessageDialog(null,"Password does not Identical");
		} else {
		Details a  = new Details();
		a.name = mail.getText();
		a.pass = pass.getText();
		a.Finame = First.getText();
		a.Laname = Last.getText();
		MailServer B = new MailServer();
		if (exist.getText().length() > 0) {
		  try {
			  if(B.checkname(a.name)) {
				  JOptionPane.showMessageDialog(null,"Your mail is exist");
				  return;
			  }
			if ( B.checkname(exist.getText())	) {
				B.twoemails(a.name, exist.getText());
			  } else {
				  JOptionPane.showMessageDialog(null,"You entered not valid mail");
				  return;
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if (B.signup(a)) {
		JOptionPane.showMessageDialog(null,"Your mail is made");
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();

		} catch (Exception e) {

		}

		} else {
			JOptionPane.showMessageDialog(null,"Your mail is exist");

		}
		}
	}






}
