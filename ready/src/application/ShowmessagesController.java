package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;

import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.Email;
import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.MailServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ShowmessagesController implements Initializable{


    public static int flag = 0;
	@FXML
	public JFXListView<String> view;
	@FXML
	private Label att;
	@FXML
	public JFXTextArea m;


	@FXML
	public void Mini(MouseEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
	}

	@FXML
	public void handclose(MouseEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if (flag == 0) {
		m.setText(viewController.str);
		ObservableList<String> list = FXCollections.observableArrayList(viewController.files);
		view.setItems(list);
		Email a = new Email();
		a = (Email) MailServer.all.get(viewController.index);
		if (a.attach() > 0) {
			att.setText("Attachments :");
		}
		} else {
			m.setText(FilterController.str);
			ObservableList<String> list = FXCollections.observableArrayList(FilterController.files);
			view.setItems(list);
			att.setText("Attachments :");

		}
	}

	@FXML
	public void showAtt(MouseEvent event) {
		String n = view.getSelectionModel().getSelectedItem();
		Desktop desktop = Desktop.getDesktop();
		Email a = new Email();
		a = (Email) MailServer.all.get(viewController.index);
		File f = new File ("server/"+MailServer.userin+"/"+MailServer.place+"/"+
				  a.pers()+"/"+a.rkm()+"/Attachment/"+n);
		try {
			desktop.open(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void moving (ActionEvent e) {
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tomove.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stages = new Stage();
	            stages.initModality(Modality.APPLICATION_MODAL);
	            stages.initStyle(StageStyle.UNDECORATED);
	            stages.setScene(new Scene(root1));
	            stages.show();
	          } catch (Exception ex){

	          }
	}
}
