package application;

import java.io.File;

import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Linked;
import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.Email;
import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.MailServer;
import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.folds;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class tomoveController {

	@FXML
	public void handclose(MouseEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.hide();
	}

	@FXML
	public void Mini(MouseEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); // minimize the window
	}

	@FXML
	public void drafts(ActionEvent event) {
		folds a = new folds();
		int s = viewController.index;
		int z = viewController.q;
		Email u = (Email) MailServer.all.get(s + z);
		String str = String.valueOf(u.rkm());
		a.folders("Drafts");
		a.setdelete("Server/" + MailServer.userin + "/" + MailServer.place + "/" + u.pers() + "/" + str);
		Linked l = new Linked();
		l.add(u);
		(new File("Server/" + MailServer.userin + "/Drafts/" + u.pers())).mkdirs();
		a.setback("Server/" + MailServer.userin + "/Drafts/" + u.pers() + "/" + u.rkm());

		MailServer x = new MailServer();
		String[] arr = new String[1];
		arr[0] = u.pers();
		u.rec = arr.clone();
		MailServer.all.remove(s);
		x.moveEmails(l, a);

		// "Server/"+ MailServer.userin + "/Drafts/index.txt"
	}

}
