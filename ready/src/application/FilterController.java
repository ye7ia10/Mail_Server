package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Linked;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FilterController  implements Initializable {

    public static String str;
    public static int index;
	public  Linked aa = new Linked();
	public  Linked at = new Linked();

    static ArrayList<String> files  = new ArrayList<>();

    @FXML
    private JFXTextField k;
    @FXML
    public JFXComboBox<String> combo;
    @FXML
    public JFXComboBox<String> combo1;
    @FXML
    public JFXListView<String> l;


	@FXML
	public void Mini(MouseEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
	}

	@FXML
	public void handclose(MouseEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();

	}

    ObservableList<String> list = FXCollections.observableArrayList("name", "subject");


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combo.setItems(list);
		combo1.setItems(list);
	}

	@FXML
	public void write(ActionEvent e) {
		String s = combo.getValue();
		File fff = null ;
		if (s.equals("name")) {
		fff = new File("Server" + File.separator + MailServer.userin + File.separator + "Filters" + File.separator + "name.txt");
		 PrintWriter writer = null;
			try {
				writer= new PrintWriter(new FileOutputStream("Server" + File.separator + MailServer.userin +
						File.separator + "Filters" + File.separator + "name.txt", true));
			} catch (FileNotFoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			 writer.println(k.getText());
			 writer.close();
		} else if (s.equals("subject")) {
		fff = new File("Server" + File.separator + MailServer.userin +
				File.separator + "Filters" + File.separator + "subject.txt");
		 PrintWriter writer = null;
			try {
				writer= new PrintWriter(new FileOutputStream("Server" + File.separator + MailServer.userin +
						File.separator + "Filters" + File.separator + "subject.txt", true));
			} catch (FileNotFoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			 writer.println(k.getText());
			 writer.close();

		}
		fff.getParentFile().mkdirs();
		try {
			fff.createNewFile();
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	}
	@FXML
	private JFXTextField ku;

	@FXML
	public void showFiltres(ActionEvent e) {
		ArrayList<String> y  = new ArrayList<>();
		MailServer .po = "Server/"+ MailServer.userin+"/Filters/"+ combo1.getValue() +
				"/" + ku.getText() + "/index.txt";
		File file = new File("Server/"+ MailServer.userin+"/Filters/"+ combo1.getValue() +
				"/" + ku.getText() + "/index.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		try {
		    String line = null;
			try {
				line = br.readLine();
				y.add(line);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		    while (line != null) {
		    	try {
					br.readLine();
					br.readLine();
			    	at.add(br.readLine());
			    	br.readLine();
			    	aa.add(br.readLine());
			    	line = br.readLine();
			    	if(line != null) {
			    		y.add(line);
		            }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


		    }
		} finally {
		    try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		    ObservableList<String> list = FXCollections.observableArrayList(y);
		    l.setItems(list);
	}


	@FXML
	public void showMessage(MouseEvent event) {
		try {
			str = read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		index = l.getSelectionModel().getSelectedIndex();
		int yu = Integer.parseInt((String)at.get(index));
		if (yu> 0) {
		File folder = null;
		 if (combo1.getValue().equals("subject")) {
			   folder = new File("Server/"+ MailServer.userin+"/Filters/"+ combo1.getValue() +
						"/" + ku.getText() +"/" +
						  l.getSelectionModel().getSelectedItem()+"/"+ aa.get(index)+"/Attachment");
			  } else if (combo1.getValue().equals("name")) {
				   folder = new File("Server/"+ MailServer.userin+"/Filters/"+ combo1.getValue() +
							"/" + ku.getText() +"/"+ aa.get(index)+"/Attachment");
	}
		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        files.add(listOfFiles[i].getName());
		      }
		    }
		}

        ShowmessagesController.flag = 1;
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Showmessages.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stages = new Stage();
	            stages.initModality(Modality.APPLICATION_MODAL);
	            stages.initStyle(StageStyle.UNDECORATED);
	            stages.setScene(new Scene(root1));
	            stages.show();
	          } catch (Exception e){

	          }
      }


	 public String read() throws IOException{
		 String line = null;
		  index = l.getSelectionModel().getSelectedIndex();
		  File file = null;
		  if (combo1.getValue().equals("subject")) {
		   file = new File("Server/"+ MailServer.userin+"/Filters/"+ combo1.getValue() +
					"/" + ku.getText() +"/" +
					  l.getSelectionModel().getSelectedItem()+"/"+ aa.get(index)+"/mail.txt");
		  } else if (combo1.getValue().equals("name")) {
			   file = new File("Server/"+ MailServer.userin+"/Filters/"+ combo1.getValue() +
						"/" + ku.getText() + "/" + aa.get(index)+"/mail.txt");
		  }
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {

			    String linee = null;
				try {
					line = br.readLine();
					linee = line;
				} catch (IOException e) {
					e.printStackTrace();
				}
			    while ((linee = br.readLine()) != null ) {

			        line += linee;
			    }
			} finally {
			    br.close();
			}
			return line;
		 }
}
