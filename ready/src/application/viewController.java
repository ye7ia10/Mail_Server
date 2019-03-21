package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Linked;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class viewController implements Initializable{


	public static String line1;
	public static String line2;
	public static String line3;
	public static String line4;
	public static int index;
	public static ArrayList<String> files = new ArrayList<>();
	public static ArrayList<String> names = new ArrayList<>();



	public MailServer x = new MailServer();
	public static int q;

	public static String foldername;
    @FXML
    private Label page;
	@FXML
	private Label exit;
	@FXML
	private Label min;
	@FXML
	private Label compose;
	@FXML
	private JFXButton inbox;
	@FXML
	public JFXListView<String> listview;
	@FXML
	public JFXListView<String> datview;
	@FXML
	public JFXListView<String> dels;
	@FXML
	public JFXListView<String> subview;
	@FXML
	public JFXListView<Integer> attview;
	@FXML
	public JFXListView<Integer> perview;
	@FXML
	public JFXListView<Integer> nomview;
	@FXML
	public JFXComboBox<String> sorts;
	@FXML
	public JFXComboBox<String> searchs;
	@FXML
	public JFXComboBox<String> trashes;
	@FXML
	private JFXButton ref;
	@FXML
	private Label lbl2;

	public static String str;
    public int flag = 0;
    public int flag1 = 0;
    public int flag2 = 0;
    public int flag3 = 0;

	@FXML
	public void INbox(ActionEvent event) {
		ref.setDisable(false);
		dels.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		MailServer.sortby = null;
		MailServer.Sfor = null;
		listview.getItems().clear();
		datview.getItems().clear();
		subview.getItems().clear();
		nomview.getItems().clear();
		attview.getItems().clear();
		dels.getItems().clear();
		perview.getItems().clear();
		ArrayList<String> p = new ArrayList<>();
		ArrayList<String> del = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();
		ArrayList<String> sub = new ArrayList<>();
		ArrayList<Integer> att = new ArrayList<>();
		ArrayList<Integer> per = new ArrayList<>();
		ArrayList<Integer> nom = new ArrayList<>();
		p.clear();
		MailServer.place = inbox.getText();
		Email[] show = null;
		if (flag == 1) {
	   show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
	     flag = 0;
		} else if (flag == 0){
			page.setText("1");
			 show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
		}
	   for (int i = 0; i < show.length; i++) {
	    	 Email u = new Email();
        	 u = show[i];
        	 System.out.println(u.pers());
        	 String str = u.pers();
        	 String dat = u.d();
        	 p.add(str);
        	 date.add(dat);
        	 sub.add(u.subject());
        	 att.add(u.attach());
        	 per.add(u.periority());
        	 nom.add(u.rkm());
        	 del.add("Delete");
	    }
	   ObservableList<String> dell = FXCollections.observableArrayList(del);
	    ObservableList<String> list = FXCollections.observableArrayList(p);
	    ObservableList<String> listd = FXCollections.observableArrayList(date);
	    ObservableList<String> lists = FXCollections.observableArrayList(sub);
	    ObservableList<Integer> listdat = FXCollections.observableArrayList(att);
	    ObservableList<Integer> listp = FXCollections.observableArrayList(per);
	    ObservableList<Integer> listr = FXCollections.observableArrayList(nom);
	    listview.setItems(list);
	    datview.setItems(listd);
	    subview.setItems(lists);
	    attview.setItems(listdat);
	    nomview.setItems(listr);
	    perview.setItems(listp);
	    dels.setItems(dell);
	}

	@FXML
	public void Sentmails(ActionEvent event) {
		ref.setDisable(false);
		MailServer.sortby = null;
		MailServer.Sfor = null;
		listview.getItems().clear();
		datview.getItems().clear();
		subview.getItems().clear();
		nomview.getItems().clear();
		attview.getItems().clear();
		dels.getItems().clear();
		perview.getItems().clear();
		ArrayList<String> del = new ArrayList<>();
		ArrayList<String> p = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();
		ArrayList<String> sub = new ArrayList<>();
		ArrayList<Integer> att = new ArrayList<>();
		ArrayList<Integer> per = new ArrayList<>();
		ArrayList<Integer> nom = new ArrayList<>();
		p.clear();
		MailServer.place = "Sent Mails";
		Email[] show = null;
		if (flag1 == 1) {
	   show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
	     flag1 = 0;
		} else if (flag1 == 0){
			page.setText("1");
			 show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
		}
	   for (int i = 0; i < show.length; i++) {
	    	 Email u = new Email();
        	 u = show[i];
        	 System.out.println(u.pers());
        	 String str = u.pers();
        	 String dat = u.d();
        	 p.add(str);
        	 date.add(dat);
        	 sub.add(u.subject());
        	 att.add(u.attach());
        	 per.add(u.periority());
        	 nom.add(u.rkm());
        	 del.add("Delete");
	    }
	   ObservableList<String> dell = FXCollections.observableArrayList(del);
	   ObservableList<String> list = FXCollections.observableArrayList(p);
	    ObservableList<String> listd = FXCollections.observableArrayList(date);
	    ObservableList<String> lists = FXCollections.observableArrayList(sub);
	    ObservableList<Integer> listdat = FXCollections.observableArrayList(att);
	    ObservableList<Integer> listp = FXCollections.observableArrayList(per);
	    ObservableList<Integer> listr = FXCollections.observableArrayList(nom);
	    listview.setItems(list);
	    datview.setItems(listd);
	    subview.setItems(lists);
	    attview.setItems(listdat);
	    nomview.setItems(listr);
	    perview.setItems(listp);
	    dels.setItems(dell);
	}


	@FXML
	public void Trash(ActionEvent event) {
		ref.setDisable(false);
		MailServer.sortby = null;
		MailServer.Sfor = null;
		listview.getItems().clear();
		datview.getItems().clear();
		subview.getItems().clear();
		nomview.getItems().clear();
		attview.getItems().clear();
		dels.getItems().clear();
		perview.getItems().clear();
		ArrayList<String> del = new ArrayList<>();
		ArrayList<String> p = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();
		ArrayList<String> sub = new ArrayList<>();
		ArrayList<Integer> att = new ArrayList<>();
		ArrayList<Integer> per = new ArrayList<>();
		ArrayList<Integer> nom = new ArrayList<>();
		p.clear();
		MailServer.place = "Trash/" + trashes.getValue();
		Email[] show = null;
		if (flag3 == 1) {
	   show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
	     flag3 = 0;
		} else if (flag3 == 0){
			page.setText("1");
			 show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
		}
	   for (int i = 0; i < show.length; i++) {
	    	 Email u = new Email();
        	 u = show[i];
        	 System.out.println(u.pers());
        	 String str = u.pers();
        	 String dat = u.d();
        	 p.add(str);
        	 date.add(dat);
        	 sub.add(u.subject());
        	 att.add(u.attach());
        	 per.add(u.periority());
        	 nom.add(u.rkm());
        	 del.add("Delete");
	    }
	    ObservableList<String> list = FXCollections.observableArrayList(p);
	    ObservableList<String> listd = FXCollections.observableArrayList(date);
	    ObservableList<String> lists = FXCollections.observableArrayList(sub);
	    ObservableList<Integer> listdat = FXCollections.observableArrayList(att);
	    ObservableList<Integer> listp = FXCollections.observableArrayList(per);
	    ObservableList<Integer> listr = FXCollections.observableArrayList(nom);
	    ObservableList<String> dell = FXCollections.observableArrayList(del);
	    listview.setItems(list);
	    datview.setItems(listd);
	    subview.setItems(lists);
	    attview.setItems(listdat);
	    nomview.setItems(listr);
	    perview.setItems(listp);
	    dels.setItems(dell);
	}

	@FXML
	public void Drafts(ActionEvent event) {
		ref.setDisable(false);
		MailServer.sortby = null;
		MailServer.Sfor = null;
		listview.getItems().clear();
		datview.getItems().clear();
		subview.getItems().clear();
		nomview.getItems().clear();
		attview.getItems().clear();
		dels.getItems().clear();
		perview.getItems().clear();
		ArrayList<String> del = new ArrayList<>();
		ArrayList<String> p = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();
		ArrayList<String> sub = new ArrayList<>();
		ArrayList<Integer> att = new ArrayList<>();
		ArrayList<Integer> per = new ArrayList<>();
		ArrayList<Integer> nom = new ArrayList<>();
		p.clear();
		MailServer.place = "Drafts";
		Email[] show = null;
		if (flag2 == 1) {
	   show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
	     flag2 = 0;
		} else if (flag2 == 0){
			page.setText("1");
			 show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
		}
	   for (int i = 0; i < show.length; i++) {
	    	 Email u = new Email();
        	 u = show[i];
        	 System.out.println(u.pers());
        	 String str = u.pers();
        	 String dat = u.d();
        	 p.add(str);
        	 date.add(dat);
        	 sub.add(u.subject());
        	 att.add(u.attach());
        	 per.add(u.periority());
        	 nom.add(u.rkm());
        	 del.add("Delete");
	    }
	    ObservableList<String> list = FXCollections.observableArrayList(p);
	    ObservableList<String> listd = FXCollections.observableArrayList(date);
	    ObservableList<String> lists = FXCollections.observableArrayList(sub);
	    ObservableList<Integer> listdat = FXCollections.observableArrayList(att);
	    ObservableList<Integer> listp = FXCollections.observableArrayList(per);
	    ObservableList<Integer> listr = FXCollections.observableArrayList(nom);
	    ObservableList<String> dell = FXCollections.observableArrayList(del);
	    listview.setItems(list);
	    datview.setItems(listd);
	    subview.setItems(lists);
	    attview.setItems(listdat);
	    nomview.setItems(listr);
	    perview.setItems(listp);
	    dels.setItems(dell);
	}

	@FXML
	public void handclose(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	public void delete(ActionEvent event) {
		ObservableList<Integer> s = dels.getSelectionModel().getSelectedIndices();
		System.out.println(s.size());

	}

	@FXML
	public void Mini(MouseEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
	}


	@FXML
	public void tosend(MouseEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
		 try{
			    sendController.flag = 0;
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("send.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stages = new Stage();
	            stages.initModality(Modality.APPLICATION_MODAL);
	            stages.initStyle(StageStyle.UNDECORATED);
	            stages.setScene(new Scene(root1));
	            stages.show();

	          } catch (Exception e){

	          }

	}

	@FXML
	public void showinfo(ActionEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Information.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stages = new Stage();
	            stages.initModality(Modality.APPLICATION_MODAL);
	            stages.initStyle(StageStyle.UNDECORATED);
	            stages.setScene(new Scene(root1));
	            open();
	            stages.show();
	          } catch (Exception e){

	          }

	}

	@FXML
	public void change (ActionEvent e){
		int x = Integer.parseInt(page.getText());
		if (MailServer.all.size() - x * 10 > 0) {
		x++;
		page.setText(String.valueOf(x));
		System.out.println(MailServer.all.size());
		System.out.println(x);
		if (MailServer.place.equals("Inbox")) {
			if (MailServer.sortby != null || MailServer.Sfor != null) {
				method();
			}
			else {INbox(e);
					flag = 1;
			}

		} else if (MailServer.place.equals("Sent Mails")) {
			System.out.println(MailServer.sortby);
			System.out.println(MailServer.Sfor);
			if (MailServer.sortby != null || MailServer.Sfor != null) {
				method();
			}
			else {Sentmails(e);
					flag1 = 1;
			}
		}
		else if (MailServer.place.equals("Drafts")) {
			if (MailServer.sortby != null || MailServer.Sfor != null) {
				method();
			}
			else {Drafts(e);
					flag2 = 1;
			}
		} else if (MailServer.place.equals("Trash")) {

			if (MailServer.sortby != null || MailServer.Sfor != null) {
				method();
			}
			else {Trash(e);
					flag3 = 1;
			}
		}
		}
		}


	@FXML
	public void logout(ActionEvent event) {
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.hide(); //minimize the window
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stages = new Stage();
	            stages.initModality(Modality.APPLICATION_MODAL);
	            stages.initStyle(StageStyle.UNDECORATED);
	            stages.setScene(new Scene(root1));
	            stages.show();
	          } catch (Exception ex){

	          }

	}

	@FXML
	public void decrease (ActionEvent e){
		int x = Integer.parseInt(page.getText());
		if (x > 1) {
		x--;
		page.setText(String.valueOf(x));
		if (MailServer.place.equals("Inbox")) {
			if (MailServer.sortby != null || MailServer.Sfor != null) {
				method();
			}
			else {INbox(e);
					flag = 1;
			}
		} else if (MailServer.place.equals("Sent Mails")) {
			if (MailServer.sortby != null || MailServer.Sfor != null) {
				method();
			}
			else {Sentmails(e);
					flag1 = 1;
			}
		}
		else if (MailServer.place.equals("Drafts")) {
			if (MailServer.sortby != null || MailServer.Sfor != null) {
				method();
			}
			else {Drafts(e);
					flag2= 1;
			}
		}
		else if (MailServer.place.equals("Trash")) {
			if (MailServer.sortby != null || MailServer.Sfor != null) {
				method();
			}
			else {Drafts(e);
					flag3 = 1;
			}
		}
		}
	}

	@FXML
	public void showFilter(ActionEvent e) {
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Filter.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stages = new Stage();
	            stages.initModality(Modality.APPLICATION_MODAL);
	            stages.initStyle(StageStyle.UNDECORATED);
	            stages.setScene(new Scene(root1));
	            stages.show();
	          } catch (Exception ex){

	          }
	}


	@FXML
	public void sort(ActionEvent event) {
		MailServer.search = null;
		MailServer.Sfor = null;
		MailServer.sortby = sorts.getValue();
		listview.getItems().clear();
		datview.getItems().clear();
		subview.getItems().clear();
		nomview.getItems().clear();
		attview.getItems().clear();
		dels.getItems().clear();
		perview.getItems().clear();
		ArrayList<String> p = new ArrayList<>();
		ArrayList<String> del = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();
		ArrayList<String> sub = new ArrayList<>();
		ArrayList<Integer> att = new ArrayList<>();
		ArrayList<Integer> per = new ArrayList<>();
		ArrayList<Integer> nom = new ArrayList<>();
		p.clear();
	    Email[] show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
	   for (int i = 0; i < show.length; i++) {
	    	 Email u = new Email();
        	 u = show[i];
        	 System.out.println(u.pers());
        	 String str = u.pers();
        	 String dat = u.d();
        	 p.add(str);
        	 date.add(dat);
        	 sub.add(u.subject());
        	 att.add(u.attach());
        	 per.add(u.periority());
        	 nom.add(u.rkm());
        	 del.add("Delete");
	    }
	   ObservableList<String> dell = FXCollections.observableArrayList(del);
	    ObservableList<String> list = FXCollections.observableArrayList(p);
	    ObservableList<String> listd = FXCollections.observableArrayList(date);
	    ObservableList<String> lists = FXCollections.observableArrayList(sub);
	    ObservableList<Integer> listdat = FXCollections.observableArrayList(att);
	    ObservableList<Integer> listp = FXCollections.observableArrayList(per);
	    ObservableList<Integer> listr = FXCollections.observableArrayList(nom);
	    listview.setItems(list);
	    datview.setItems(listd);
	    subview.setItems(lists);
	    attview.setItems(listdat);
	    nomview.setItems(listr);
	    perview.setItems(listp);
	    dels.setItems(dell);
	}

	@FXML
	public void deleting (MouseEvent event) {
		Linked mail = new Linked();
		int x = dels.getSelectionModel().getSelectedIndex();
		Email m = (Email) MailServer.all.get(x * Integer.parseInt(page.getText()));
		mail.add(m);
		System.out.println(m.pers());
		System.out.println(MailServer.all.size());
		MailServer.inout = MailServer.place;
		MailServer h = new MailServer();
		h.deleteEmails(mail);
		method();
	}



	@FXML
	public void showMessage(MouseEvent event) {
		try {
			str = read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		index = listview.getSelectionModel().getSelectedIndex();
		int q = ( (Integer.parseInt(page.getText()) - 1 ) * 10);
		Email a = new Email();
		a = (Email) MailServer.all.get(index + ( (Integer.parseInt(page.getText()) - 1 ) * 10));
		if (a.attach() > 0) {
		File folder = new File("server/"+MailServer.userin+"/"+MailServer.place+"/"+
				  a.pers()+"/"+a.rkm()+"/Attachment");
		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        files.add(listOfFiles[i].getName());
		      }
		    }
		}
        ShowmessagesController.flag = 0;
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
	@FXML
	private JFXTextField sea;
	@FXML
	public void search(ActionEvent e) {
		MailServer.search = searchs.getValue();
		MailServer.Sfor = sea.getText();
		MailServer.sortby = null;
		if (searchs.getValue().equals("date")) {
			setD(sea.getText());
		}
		MailServer.sortby = null;
		listview.getItems().clear();
		datview.getItems().clear();
		subview.getItems().clear();
		nomview.getItems().clear();
		attview.getItems().clear();
		dels.getItems().clear();
		perview.getItems().clear();
		ArrayList<String> p = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();
		ArrayList<String> sub = new ArrayList<>();
		ArrayList<String> del = new ArrayList<>();
		ArrayList<Integer> att = new ArrayList<>();
		ArrayList<Integer> per = new ArrayList<>();
		ArrayList<Integer> nom = new ArrayList<>();
		p.clear();
	    Email[] show = (Email[]) x.listEmails(Integer.parseInt(page.getText()));
	   for (int i = 0; i < show.length; i++) {
	    	 Email u = new Email();
        	 u = show[i];
        	 System.out.println(u.pers());
        	 String str = u.pers();
        	 String dat = u.d();
        	 p.add(str);
        	 date.add(dat);
        	 sub.add(u.subject());
        	 att.add(u.attach());
        	 per.add(u.periority());
        	 nom.add(u.rkm());
        	 del.add("Delete");
	    }
	   ObservableList<String> dell = FXCollections.observableArrayList(del);

	    ObservableList<String> list = FXCollections.observableArrayList(p);
	    ObservableList<String> listd = FXCollections.observableArrayList(date);
	    ObservableList<String> lists = FXCollections.observableArrayList(sub);
	    ObservableList<Integer> listdat = FXCollections.observableArrayList(att);
	    ObservableList<Integer> listp = FXCollections.observableArrayList(per);
	    ObservableList<Integer> listr = FXCollections.observableArrayList(nom);
	    listview.setItems(list);
	    datview.setItems(listd);
	    subview.setItems(lists);
	    attview.setItems(listdat);
	    nomview.setItems(listr);
	    perview.setItems(listp);
	    dels.setItems(dell);
	}


	void open() throws IOException{
		File file = new File("server/" + MailServer.userin + "/User/data.txt");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			try {
				line1 = br.readLine();
				line2 = br.readLine();
				line3 = br.readLine();
				line4 = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} finally {
		    br.close();
		}
	 }

	 public String read() throws IOException{
		 String line = null;
		  index = listview.getSelectionModel().getSelectedIndex();
		  Email a = new Email();
		  a = (Email) MailServer.all.get(index);
		   File file = new File("Server/"+MailServer.userin+"/"+MailServer.place+"/"+
		  a.pers()+"/"+a.rkm()+"/mail.txt");
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


	 ObservableList<String> list = FXCollections.observableArrayList("name", "subject" , "attachment"
			                       , "periority", "date");
	 ObservableList<String> lists = FXCollections.observableArrayList("name", "subject"
             , "periority", "date");
	 ObservableList<String> listss = FXCollections.observableArrayList("Inbox", "Sent Mails"
             , "Drafts");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		sorts.setItems(list);
		searchs.setItems(lists);
		trashes.setItems(listss);
		lbl2.setText(MailServer.userin);
	}


	public void method() {
		listview.getItems().clear();
		listview.getItems().clear();
		datview.getItems().clear();
		subview.getItems().clear();
		nomview.getItems().clear();
		attview.getItems().clear();
		dels.getItems().clear();
		perview.getItems().clear();
		ArrayList<String> p = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();
		ArrayList<String> sub = new ArrayList<>();
		ArrayList<Integer> att = new ArrayList<>();
		ArrayList<Integer> per = new ArrayList<>();
		ArrayList<String> del = new ArrayList<>();
		ArrayList<Integer> nom = new ArrayList<>();
		p.clear();
		int size = Integer.parseInt(page.getText());
		int z = 0;
		if (MailServer.all.size() < size * 10) {
			z = MailServer.all.size();
		} else {
			z = size * 10;
		}
	   for (int i = (size - 1) * 10; i < z; i++) {
	    	 Email u = new Email();
        	 u = (Email) MailServer.all.get(i);
        	 System.out.println(u.pers());
        	 String str = u.pers();
        	 String dat = u.d();
        	 p.add(str);
        	 date.add(dat);
        	 sub.add(u.subject());
        	 att.add(u.attach());
        	 per.add(u.periority());
        	 nom.add(u.rkm());
        	 del.add("Delete");
	    }
	   ObservableList<String> dell = FXCollections.observableArrayList(del);
	    ObservableList<String> list = FXCollections.observableArrayList(p);
	    ObservableList<String> listd = FXCollections.observableArrayList(date);
	    ObservableList<String> lists = FXCollections.observableArrayList(sub);
	    ObservableList<Integer> listdat = FXCollections.observableArrayList(att);
	    ObservableList<Integer> listp = FXCollections.observableArrayList(per);
	    ObservableList<Integer> listr = FXCollections.observableArrayList(nom);
	    listview.setItems(list);
	    datview.setItems(listd);
	    subview.setItems(lists);
	    attview.setItems(listdat);
	    nomview.setItems(listr);
	    perview.setItems(listp);
	    dels.setItems(dell);
	}




	public Linked showcontact() {
		Linked c = new Linked();
		c.clear();
		File folder = new File("Server/"+MailServer.userin+"/Inbox");
		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isDirectory()) {
		        c.add(listOfFiles[i].getName());
		      }
		    }
		    File folder1 = new File("Server/"+MailServer.userin+"/Sent Mails");
			File[] listOfFiles1 = folder1.listFiles();
			    for (int i = 0; i < listOfFiles1.length; i++) {
			      if (listOfFiles1[i].isDirectory() && !c.contains(listOfFiles1[i].getName())) {
			        c.add(listOfFiles1[i].getName());
			      }
			    }
		return c;
	}




	@FXML
	public void showcon(ActionEvent e) {
		names.clear();
		Linked d = showcontact();
		for (int i = 0; i < d.size(); i++) {
			names.add((String)d.get(i));
		}
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		stage.setIconified(true); //minimize the window
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("contacts.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stages = new Stage();
	            stages.initModality(Modality.APPLICATION_MODAL);
	            stages.initStyle(StageStyle.UNDECORATED);
	            stages.setScene(new Scene(root1));
	            stages.show();
	          } catch (Exception ex){

	          }
	}


	@FXML
	public void refresh(ActionEvent event) {
	//	method();
	}

	public void setD(String d) {
		String a ="";
		int flag=0;
		for(int j = 0; j < d.length(); j++ ) {
			if(d.charAt(j) != '/') {
				a+=d.charAt(j);
			} else {
				MailServer.year = a;
				a = "";
				for( j++; j < d.length(); j++ ) {
    				if(d.charAt(j) != '/') {
    					a+=d.charAt(j);
    				} else {
    					MailServer.month = a;
    					a = "";
    					for( j++; j < d.length(); j++ ) {
		    				if(d.charAt(j) != ' ' && d.length() - j > 1) {
		    					a+=d.charAt(j);
		    				} else {
		    					a+=d.charAt(j);
		    					MailServer.day = a;
		    					a = "";
		    					flag = 1;
		    					break;
		    				}

    				}
			}
    				if(flag == 1) {
						break;
					}
		}
	}
			if(flag == 1) {
				break;
			}
		}
	}
}
