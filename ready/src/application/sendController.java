package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Double;
import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Linked;
import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.Email;
import eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08.MailServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class sendController implements Initializable{
	public static int flag = 0;
	Email y = new Email();
    private Linked att = new Linked();
	@FXML
	JFXButton g;
	@FXML
	private Label exit;
	@FXML
	private Label min;
	@FXML
	private JFXTextField to;
	@FXML
	private JFXTextField sub;
	@FXML
	private JFXTextArea mes;

    @FXML
    public JFXComboBox<Integer> combo;

    ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combo.setItems(list);
		if (flag == 1) {
			to.setText(contactsController.str);
		}

	}



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


	public sendController() {

	}

    @FXML
	public void shoe(ActionEvent event) {
		 FileChooser chooser = new FileChooser();
		    chooser.setTitle("Open File");
		   File f = chooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
		   if (f != null) {
			   String p = f.getAbsolutePath();
			   att.add(p);
		   }

    }

    @FXML
    public void send(ActionEvent event) throws IOException {
    	if (to.getText().length() == 0) {
    		JOptionPane.showMessageDialog(null, "You should enter an email address!");
    		return;
    	}
    	String [] arr =  split(to.getText());
    	if(mes.getText().length() == 0) {
    		y.body = " ";
    	} else {
    		y.body = mes.getText();
    	}

        if (att.size() > 0) {
        String [] atts = new String[att.size()]; //receiver
        for (int i = 0; i < att.size(); i++) {
        	atts[i] = (String)att.get(i);
        }
        y.att = atts.clone();
        y.attch = att.size();
        }
        y.rec = arr.clone();
        if (combo.getValue() != null) {
        y.per = combo.getValue();
        } else {
        	y.per = 5;
        }
        if (sub.getText().length() == 0) {
        	y.sub = "";
        } else {
        y.sub = sub.getText();
        }
        MailServer x = new MailServer();
        x.test( y);
        att.clear();

    }

	public String[] split(String a) {
		Double c = new Double();
		String b = "";
		for(int i = 0; i< a.length() ; i++) {

			if(a.charAt(i) == ',' || i+1 == a.length()) {
				if(i+1 == a.length()) {
					b = b+ a.charAt(i);
				}
				c.add(b);
				b= "";
			} else {
				b = b+ a.charAt(i);
			}
		}
		String[] arr = new String[c.size()];
		for(int i = 0 ; i< c.size() ; i++) {

			arr[i] = (String) c.get(i);
		}

		return arr;

	}


}
