package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class contactsController implements Initializable {
	public static String str;

	@FXML
	public JFXListView<String> l;

	@FXML
	public void Mini(MouseEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); // minimize the window
	}

	@FXML
	public void handclose(MouseEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		l.getItems().clear();
		ObservableList<String> list = FXCollections.observableArrayList(viewController.names);
		l.setItems(list);
	}

	@FXML
	public void sender(MouseEvent event) {
		str = l.getSelectionModel().getSelectedItem();
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); // minimize the window
		try {
			sendController.flag = 1;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("send.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stages = new Stage();
			stages.initModality(Modality.APPLICATION_MODAL);
			stages.initStyle(StageStyle.UNDECORATED);
			stages.setScene(new Scene(root1));
			stages.show();
		} catch (Exception ex) {

		}

	}

}
