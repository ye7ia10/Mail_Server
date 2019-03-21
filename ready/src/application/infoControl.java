package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.MailServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class infoControl {

	@FXML
	private JFXTextField first;
    @FXML
    private Label lbl;
	@FXML
	private JFXTextField last;
	@FXML
	private JFXTextField email;
	@FXML
	private JFXTextField pass;
	@FXML
	private Label exit;
	@FXML
	private Label min;
	@FXML
	private JFXButton edit;
	@FXML
	private JFXButton save;


	@FXML
	public void handclose(MouseEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.hide();
	}

	@FXML
	public void Mini(MouseEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
	}

	@FXML
	public void show(ActionEvent event) {
		first.setText(viewController.line1);
		last.setText(viewController.line2);
		email.setText(viewController.line3);
		pass.setText(viewController.line4);
		edit.setDisable(false);
	}

	@FXML
	public void edit(ActionEvent event) {
		first.setEditable(true);
		last.setEditable(true);
		pass.setEditable(true);
		save.setDisable(false);
	}

	@FXML
	public void save() {
	    try
        {
        File file = new File("server/" + MailServer.userin + "/User/data.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "", oldtext = "";
        while((line = reader.readLine()) != null)
            {
            oldtext += line + "\r\n";
        }
        reader.close();
        String newtext = oldtext.replaceAll(viewController.line2, last.getText());
        String newtext2 = newtext.replaceAll(viewController.line1, first.getText());
        String newtext3 = newtext2.replaceAll(viewController.line4, pass.getText());
        MailServer.setpass(pass.getText());
        FileWriter writer = new FileWriter("server/" + MailServer.userin + "/User/data.txt");
        writer.write(newtext3);
        writer.close();
        first.setEditable(false);
		last.setEditable(false);
		pass.setEditable(false);
    }
    catch (IOException ioe)
        {
        ioe.printStackTrace();
    }
	}






}
