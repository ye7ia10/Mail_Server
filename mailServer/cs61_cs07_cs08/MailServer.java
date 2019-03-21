package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Double;
import eg.edu.alexu.csd.datastructure.mailServer.IApp;
import eg.edu.alexu.csd.datastructure.mailServer.IContact;
import eg.edu.alexu.csd.datastructure.mailServer.IFilter;
import eg.edu.alexu.csd.datastructure.mailServer.IFolder;
import eg.edu.alexu.csd.datastructure.mailServer.IMail;
import eg.edu.alexu.csd.datastructure.mailServer.ISort;

public class MailServer implements IApp {
	public static String userin;
	public static String place;
	public static String inout;
	public static String Sfor;
	public static String sortby = null;
	public static int Sper;
	public static int z;
	public static Double all = new Double();
	public static Double alls = new Double();
	public static String search;
	public static String year;
	public static String month;
	public static String day;
	int flag12 = 0;
	public static String po;

	/**
	 * this class contains the main interface and all interfaces. every interface
	 * have a class implements it. Icontact is implemented in class called details
	 * that contains two methods returns name and password to be in interface
	 */
	/**
	 * this method get the name and password and check if exist return true.
	 *
	 * @throws IOException
	 */
	@Override
	public boolean signin(String email, String password) {
		// TODO Auto-generated method stub
		userin = email;
		try {
			if (open(email, password)) {
				try {
					del1();
					del2();
					System.out.println("|d5lllllllllll");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean signup(IContact contact) {
		// TODO Auto-generated method stub
		String folder = "Server";
		boolean server;
		server = (new File(folder)).mkdirs();
		if (server) {
			System.out.println("trueeee");
			try {
				CreatAccount(contact);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// ****************server found
		// check that there is no sign up with the same email
		if (!server) {
			File f = new File(folder + File.separator + "Names file.txt");
			Scanner sc = null;
			try {
				sc = new Scanner(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (sc.hasNextLine()) {
				if (sc.nextLine().equals(contact.name())) {
					System.out.println("You have signed up before" + "you can sign in instead!");
					return false;
				}
			}
			try {
				CreatAccount(contact);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return true;

	}

	/*********************************** call in sign up ************************/
	public void CreatAccount(IContact contact) throws IOException {

		String folder = "Server";
		(new File(folder)).mkdirs();

		// **********creating text file of names of contacts
		// Use relative path for Unix systems
		File f = new File(folder + File.separator + "Names file.txt");
		f.getParentFile().mkdirs();
		f.createNewFile();

		// *******writing name in a text file
		// PrintWriter writer = new PrintWriter("Server" + File.separator
		// + "Names file.txt","UTF-8");
		PrintWriter writer = new PrintWriter(new FileOutputStream("Server" + File.separator + "Names file.txt", true));
		writer.println(contact.name());
		writer.println(contact.pass());
		writer.write("\n");
		writer.close();

		// *********creating folders
		// make folder
		(new File(folder + File.separator + contact.name())).mkdirs();
		(new File(folder + File.separator + contact.name() + File.separator + "Inbox")).mkdirs();

		(new File(folder + File.separator + contact.name() + File.separator + "Trash")).mkdirs();
		(new File(folder + File.separator + contact.name() + File.separator + "Filters")).mkdirs();
		(new File(folder + File.separator + contact.name() + File.separator + "Sent Mails")).mkdirs();
		(new File(folder + File.separator + contact.name() + File.separator + "Drafts")).mkdirs();
		(new File(folder + File.separator + contact.name() + File.separator + "User")).mkdirs();
		File ff = new File(
				folder + File.separator + contact.name() + File.separator + "User" + File.separator + "data.txt");
		ff.getParentFile().mkdirs();
		ff.createNewFile();
		PrintWriter writers = new PrintWriter(new FileOutputStream(
				"Server" + File.separator + contact.name() + File.separator + "User" + File.separator + "data.txt",
				true));
		writers.println(contact.Fname());
		writers.println(contact.Lname());
		writers.println(contact.name());
		writers.println(contact.pass());
		writers.write("\n");
		writers.close();

	}

	@Override
	public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
		// TODO Auto-generated method stub
		all.clear();
		folder.read();
		if (filter != null && sort == null) {
			sort a = new sort();
			if (filter.FilterName().equals("name")) {
				a.set("name");
				a.sorting(all);
				all = filter.namesearch(all, Sfor);
			} else if (filter.FilterName().equals("subject")) {
				a.set("subject");
				a.sorting(all);
				all = filter.subjectsearch(all, Sfor);
			} else if (filter.FilterName().equals("periority")) {
				a.set("periority");
				a.per(all);
				all = filter.persearch(all, Integer.parseInt(Sfor));
			} else if (filter.FilterName().equals("date")) {
				all = searchdate(year, month, day);
			}
		} else if (filter == null && sort != null) {

			if (sort.get().equals("name")) {
				sort.set("name");
				sort.sorting(all);
			} else if (sort.get().equals("date")) {
				sort.date(all);
			} else if (sort.get().equals("periority")) {
				sort.set("periority");
				sort.per(all);
			} else if (sort.get().equals("subject")) {
				sort.set("subject");
				sort.sorting(all);
			} else if (sort.get().equals("attachment")) {
				sort.set("attachment");
				sort.sorting(all);
			}
		}

	}

	@Override
	public IMail[] listEmails(int page) {
		folds o = new folds();
		sort so = new sort();
		Filter fi = new Filter();
		if (Sfor == null) {
			fi = null;
		} else {
			fi.setF(search);
		}
		if (sortby == null) {
			so = null;
		} else {
			so.set(sortby);
		}
		o.folders(place);
		setViewingOptions(o, fi, so);
		int j = 0;
		Email[] instances = new Email[10];
		if (all.size() < page * 10) {
			instances = new Email[all.size() - ((page - 1) * 10)];
		}
		int i = 0;
		for (i = page * 10 - 10; (i < all.size()) && (i < page * 10); i++) {
			if (all.get(i).equals(null)) {
				break;
			}
			instances[j] = (Email) all.get(i);
			j++;
		}
		z = i;

		return instances;
	}

	@Override
	public void deleteEmails(ILinkedList mails) {
		// TODO Auto-generated method stub
		/******** copy email **************/
		if (mails.size() != 0) {
			int size = mails.size();
			for (int j = size - 1; j >= 0; j--) {
				System.out.println(mails.size());
				Email a = new Email();
				a = (Email) mails.get(j);
				(new File("Server" + File.separator + userin // sender name
						+ File.separator + "Trash" + File.separator + inout)).mkdirs();
				(new File("Server" + File.separator + userin // sender name
						+ File.separator + "Trash" + File.separator + inout + File.separator + a.person)).mkdirs();
				String str = String.valueOf(a.srkm);
				/**
				 * String pathu = "Server/" + userin + "/Trash/" + inout + "/"+ a.person + "/";
				 * File f2 = new File("Server/" + userin +"/" + inout + "/" + a.person + "/" +
				 * str ); try { Files.copy(f2.toPath(), (new File(pathu +
				 * f2.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING); } catch
				 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
				 **/

				(new File("Server" + File.separator + userin // sender name
						+ File.separator + "Trash" + File.separator + inout + File.separator + a.person + File.separator
						+ str)).mkdirs();
				String source = "Server/" + userin + "/" + inout + "/" + a.person + "/" + str;
				File srcDir = new File(source);

				String destination = "Server/" + userin + "/Trash/" + inout + "/" + a.person + "/" + str;
				File destDir = new File(destination);

				try {
					FileUtils.copyDirectory(srcDir, destDir);
				} catch (IOException e) {
					e.printStackTrace();
				}
				/********** write in index ********************/
				PrintWriter writer;
				try {
					writer = new PrintWriter(new FileOutputStream("Server" + File.separator + userin + File.separator
							+ "trash" + File.separator + inout + File.separator + "index.txt", true));
					writer.println(a.person);
					writer.println(a.dat);
					writer.println(a.sub);
					writer.println(a.attch);
					writer.println(a.per);
					writer.println(a.srkm);
					writer.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/************* delete file and from index ******************/
				for (int k = 0; k < all.size(); k++) {
					Email b = (Email) mails.get(k);
					if (b.person.equals(a.person) && b.srkm == a.srkm) {
						all.remove(k);
						break;
					}
				}

				File directory = new File("Server/" + userin + "/" + inout + "/" + a.person + "/" + str);

				try {

					delete(directory);

				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			PrintWriter writer;
			try {
				writer = new PrintWriter(new FileOutputStream(
						"Server" + File.separator + userin + File.separator + inout + File.separator + "index.txt"));
				for (int l = 0; l < all.size(); l++) {
					Email a = (Email) all.get(l);
					writer.println(a.person);
					writer.println(a.dat);
					writer.println(a.sub);
					writer.println(a.attch);
					writer.println(a.per);
					writer.println(a.srkm);
				}
				writer.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * move emails from folder to another.
	 */
	@Override
	public void moveEmails(ILinkedList mails, IFolder des) {
		// TODO Auto-generated method stub
		/******** copy email **************/
		if (des.getFolder().equals("Drafts")) {

			File directory = new File(des.getdelete());
			String source = des.getdelete();
			File srcDir = new File(source);

			String destination = des.getback();
			File destDir = new File(destination);

			try {
				FileUtils.copyDirectory(srcDir, destDir);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {

				delete(directory);

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
			/**
			 * PrintWriter writer; try { writer = new PrintWriter(new
			 * FileOutputStream(des.getback())); for(int l = 0; l < all.size(); l++) { Email
			 * a = (Email) all.get(l); writer.println(a.person); writer.println(a.dat);
			 * writer.println(a.sub); writer.println(a.attch); writer.println(a.per);
			 * writer.println(a.srkm);
			 *
			 * } writer.close();
			 *
			 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 **/
			flag12 = 1;
			draft((IMail) mails.get(0));
			PrintWriter writer = null;
			String p = place;
			if (p.equals("Filters")) {
				p = p + "/" + des.getcheck();
			}

			try {
				writer = new PrintWriter(new FileOutputStream(
						"Server" + File.separator + userin + File.separator + p + File.separator + "index.txt"));
				for (int i = 0; i < all.size(); i++) {
					Email a = new Email();
					a = (Email) all.get(i);
					writer.println(a.pers());
					writer.println(a.d());
					writer.println(a.subject());
					writer.println(a.attach());
					writer.println(a.periority());
					writer.println(a.rkm());

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.close();
			return;
		} else if (des.getFolder().equals("Sent Mails")) {
			compose((IMail) mails.get(0));
			File directory = new File(des.getdelete());

			try {

				delete(directory);

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
			PrintWriter writer;
			try {
				writer = new PrintWriter(new FileOutputStream(des.getback()));
				for (int l = 0; l < all.size(); l++) {
					Email a = (Email) all.get(l);
					writer.println(a.person);
					writer.println(a.dat);
					writer.println(a.sub);
					writer.println(a.attch);
					writer.println(a.per);
					writer.println(a.srkm);

				}
				writer.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		} else if (des.getFolder().equals("Inbox")) {
			Email a = (Email) mails.get(0);
			String b = userin;
			userin = a.person;
			compose(a);
			userin = b;

			File directory = new File(des.getdelete());

			try {

				delete(directory);

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
			PrintWriter writer;
			try {
				writer = new PrintWriter(new FileOutputStream(des.getback()));
				for (int l = 0; l < all.size(); l++) {
					Email d = (Email) all.get(l);
					writer.println(d.person);
					writer.println(d.dat);
					writer.println(d.sub);
					writer.println(d.attch);
					writer.println(d.per);
					writer.println(d.srkm);

				}
				writer.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		} else if (des.getFolder().equals("Filters")) {
			filter(des.getcheck(), (IMail) mails.get(0));
			File directory = new File(des.getdelete());

			try {

				delete(directory);

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
			PrintWriter writer;
			try {
				writer = new PrintWriter(new FileOutputStream(des.getback()));
				for (int l = 0; l < all.size(); l++) {
					Email a = (Email) all.get(l);
					writer.println(a.person);
					writer.println(a.dat);
					writer.println(a.sub);
					writer.println(a.attch);
					writer.println(a.per);
					writer.println(a.srkm);

				}
				writer.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		} else if (des.getFolder().equals("Trash")) {
			deleteEmails(mails);
			File directory = new File(des.getdelete());

			try {

				delete(directory);

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
			PrintWriter writer;
			try {
				writer = new PrintWriter(new FileOutputStream(des.getback()));
				for (int l = 0; l < all.size(); l++) {
					Email a = (Email) all.get(l);
					writer.println(a.person);
					writer.println(a.dat);
					writer.println(a.sub);
					writer.println(a.attch);
					writer.println(a.per);
					writer.println(a.srkm);

				}
				writer.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		if (mails.size() != 0) {
			int size = mails.size();
			for (int j = size - 1; j >= 0; j--) {
				System.out.println(mails.size());
				Email a = new Email();
				a = (Email) mails.get(j);
				(new File("Server" + File.separator + userin // sender name
						+ File.separator + des.getFolder() + File.separator + inout)).mkdirs();
				(new File("Server" + File.separator + userin // sender name
						+ File.separator + des.getFolder() + File.separator + inout + File.separator + a.person))
								.mkdirs();
				String str = String.valueOf(a.srkm);
				/**
				 * String pathu = "Server/" + userin + "/Trash/" + inout + "/"+ a.person + "/";
				 * File f2 = new File("Server/" + userin +"/" + inout + "/" + a.person + "/" +
				 * str ); try { Files.copy(f2.toPath(), (new File(pathu +
				 * f2.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING); } catch
				 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
				 **/

				(new File("Server" + File.separator + userin // sender name
						+ File.separator + des.getFolder() + File.separator + inout + File.separator + a.person
						+ File.separator + str)).mkdirs();
				String source = "Server/" + userin + "/" + inout + "/" + a.person + "/" + str;
				File srcDir = new File(source);

				String destination = "Server/" + userin + "/Trash/" + inout + "/" + a.person + "/" + str;
				File destDir = new File(destination);

				try {
					FileUtils.copyDirectory(srcDir, destDir);
				} catch (IOException e) {
					e.printStackTrace();
				}
				/********** write in index ********************/
				PrintWriter writer;
				try {
					writer = new PrintWriter(new FileOutputStream("Server" + File.separator + userin + File.separator
							+ des.getFolder() + File.separator + inout + File.separator + "index.txt", true));
					writer.println(a.person);
					writer.println(a.dat);
					writer.println(a.sub);
					writer.println(a.attch);
					writer.println(a.per);
					writer.println(a.srkm);
					writer.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/************* delete file and from index ******************/
				for (int k = 0; k < all.size(); k++) {
					Email b = (Email) mails.get(k);
					if (b.person.equals(a.person) && b.srkm == a.srkm) {
						all.remove(k);
						break;
					}
				}

				File directory = new File("Server/" + userin + "/" + inout + "/" + a.person + "/" + str);

				try {

					delete(directory);

				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			PrintWriter writer;
			try {
				writer = new PrintWriter(new FileOutputStream(
						"Server" + File.separator + userin + File.separator + inout + File.separator + "index.txt"));
				for (int l = 0; l < all.size(); l++) {
					Email a = (Email) all.get(l);
					writer.println(a.person);
					writer.println(a.dat);
					writer.println(a.sub);
					writer.println(a.attch);
					writer.println(a.per);
					writer.println(a.srkm);
					writer.close();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**************************
	 * compose to send email and attachment
	 *****************/
	@Override
	public boolean compose(IMail email) {
		// TODO Auto-generated method stub
		for (int i = 0; i < email.names().length; i++) {
			// create folder for the sender in sent folder.
			// v is the name of reciever
			String v = email.names()[i];
			try {
				if (rightn(v, userin)) {
					filter("name", email);
				}
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			try {
				if (rights(v, email.subject())) {
					filter("subject", email);
				}
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}

			(new File("Server" + File.separator + userin // sender name
					+ File.separator + "Sent Mails" + File.separator + v)).mkdirs();

			// make text file
			File fff = new File("Server" + File.separator + userin // sender name
					+ File.separator + "Sent Mails" + File.separator + v + File.separator + "index.txt");
			fff.getParentFile().mkdirs();
			try {
				fff.createNewFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			int rkm = 0;
			File f = new File("Server" + File.separator + userin // sender name
					+ File.separator + "Sent Mails" + File.separator + v + File.separator + "index.txt");
			Scanner sc = null;
			try {
				sc = new Scanner(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (sc.hasNextLine()) {
				rkm = sc.nextInt();
				rkm++;
			}

			if (rkm == 0) {
				rkm = 1;
			}
			String srkm = String.valueOf(rkm);
			(new File("Server" + File.separator + userin // sender name
					+ File.separator + "Sent Mails" + File.separator + v + File.separator + srkm)).mkdirs();

			PrintWriter writer = null;
			try {
				writer = new PrintWriter("Server" + File.separator + userin // sender name
						+ File.separator + "Sent Mails" + File.separator + v + File.separator + "index.txt", "UTF-8");
			} catch (FileNotFoundException | UnsupportedEncodingException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			writer.println(rkm);
			writer.close();

			// sender
			File fis = new File(
					"Server" + File.separator + userin + File.separator + "Sent Mails" + File.separator + "index.txt");

			try {
				fis.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			PrintWriter writerss;
			try {
				writerss = new PrintWriter(new FileOutputStream("Server" + File.separator + userin + File.separator
						+ "Sent Mails" + File.separator + "index.txt", true));

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				writerss.println(v);
				writerss.println(dtf.format(now));
				writerss.println(email.subject());
				writerss.println(email.attach());
				writerss.println(email.periority());
				writerss.println(srkm);
				writerss.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// create file contain mail data.
			File f22 = new File("Server" + File.separator + userin + File.separator + "Sent Mails" + File.separator + v
					+ File.separator + srkm + File.separator + "mail.txt");
			f22.getParentFile().mkdirs();
			try {
				f22.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/************* write the sent mail here *****************/
			PrintWriter writer12;
			try {
				writer12 = new PrintWriter(
						new FileOutputStream("Server" + File.separator + userin + File.separator + "Sent Mails"
								+ File.separator + v + File.separator + srkm + File.separator + "mail.txt", true));
				writer12.println(email.body());
				writer12.write("\n");
				writer12.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// the receiver
			// make a file of the sender if not exist and make index file contain the
			// information of the message//
			(new File("Server" + File.separator + v + File.separator + "Inbox" + File.separator + userin)).mkdirs();

			File fff1 = new File("Server" + File.separator + v + File.separator + "Inbox" + File.separator + userin
					+ File.separator + "index.txt");
			fff1.getParentFile().mkdirs();
			try {
				fff1.createNewFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			File fiss = new File(
					"Server" + File.separator + v + File.separator + "Inbox" + File.separator + "index.txt");

			try {
				fiss.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/// write the information of the sent email
			PrintWriter writersss;
			try {
				writersss = new PrintWriter(new FileOutputStream(
						"Server" + File.separator + v + File.separator + "Inbox" + File.separator + "index.txt", true));

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				writersss.println(userin);
				writersss.println(dtf.format(now));
				writersss.println(email.subject());
				writersss.println(email.attach());
				writersss.println(email.periority());
				writersss.println(srkm);
				writersss.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// create file contain mail data.
			File ff = new File("Server" + File.separator + v + File.separator + "Inbox" + File.separator + userin
					+ File.separator + srkm + File.separator + "mail.txt");
			ff.getParentFile().mkdirs();
			try {
				ff.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter writers;
			try {
				writers = new PrintWriter(new FileOutputStream("Server" + File.separator + v + File.separator + "Inbox"
						+ File.separator + userin + File.separator + srkm + File.separator + "mail.txt", true));
				writers.println(email.body());
				writers.write("\n");
				writers.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/// make a folder of attachment in reciever and sender

			if (email.path() != null) {
				for (int j = 0; j < email.path().length; j++) {

					(new File("Server" + File.separator + userin // sender name
							+ File.separator + "Sent Mails" + File.separator + v + File.separator + srkm
							+ File.separator + "Attachment")).mkdirs();
					String pathu = "Server/" + userin + "/Sent Mails/" + v + "/" + srkm + "/Attachment/";
					File f2 = new File(email.path()[j]);
					try {
						Files.copy(f2.toPath(), (new File(pathu + f2.getName())).toPath(),
								StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					(new File("Server" + File.separator + v + File.separator + "Inbox" + File.separator + userin
							+ File.separator + srkm + File.separator + "Attachment")).mkdirs();

					String path = "Server/" + v + "/Inbox/" + userin + "/" + srkm + "/Attachment/";
					File f1 = new File(email.path()[j]);
					try {
						Files.copy(f1.toPath(), (new File(path + f1.getName())).toPath(),
								StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			if (i + 1 == email.names().length) {
				return true;
			}

		}
		return false;
	}

	/**
	 * to open file names in sign in method.
	 *
	 * @param email
	 * @param password
	 * @return
	 * @throws IOException
	 */
	boolean open(String email, String password) throws IOException {
		File file = new File("server//Names file.txt");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			while (line != null) {
				if (email.equals(line)) {
					line = br.readLine();
					if (password.equals(line)) {
						br.close();
						return true;
					}
				}
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		return false;
	}

	/**
	 * recursive method to delete files.
	 *
	 * @param file
	 * @throws IOException
	 */
	public static void delete(File file) throws IOException {

		if (file.isDirectory()) {

			// directory is empty, then delete it
			if (file.list().length == 0) {

				file.delete();

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
				}
			}

		} else {
			// if file, then delete it
			file.delete();
		}
	}

	public boolean draft(IMail email) {
		// TODO Auto-generated method stub
		for (int i = 0; i < email.names().length; i++) {
			// create folder for the sender in sent folder.
			// v is the name of reciever
			String v = email.names()[i];

			(new File("Server" + File.separator + userin // sender name
					+ File.separator + "Drafts" + File.separator + v)).mkdirs();

			// make text file
			File fff = new File("Server" + File.separator + userin // sender name
					+ File.separator + "Drafts" + File.separator + v + File.separator + "index.txt");
			fff.getParentFile().mkdirs();
			try {
				fff.createNewFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			int rkm = 0;
			File f = new File("Server" + File.separator + userin // sender name
					+ File.separator + "Drafts" + File.separator + v + File.separator + "index.txt");
			Scanner sc = null;

			try {
				sc = new Scanner(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (sc.hasNextLine()) {
				rkm = sc.nextInt();
				rkm++;
			}

			if (rkm == 0) {
				rkm = 1;
			}
			String srkm = String.valueOf(rkm);
			(new File("Server" + File.separator + userin // sender name
					+ File.separator + "Drafts" + File.separator + v + File.separator + srkm)).mkdirs();

			PrintWriter writer = null;
			try {
				writer = new PrintWriter("Server" + File.separator + userin // sender name
						+ File.separator + "Drafts" + File.separator + v + File.separator + "index.txt", "UTF-8");
			} catch (FileNotFoundException | UnsupportedEncodingException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			writer.println(rkm);
			writer.close();

			// sender
			File fis = new File(
					"Server" + File.separator + userin + File.separator + "Drafts" + File.separator + "index.txt");

			try {
				fis.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			PrintWriter writerss;
			try {
				writerss = new PrintWriter(new FileOutputStream(
						"Server" + File.separator + userin + File.separator + "Drafts" + File.separator + "index.txt",
						true));

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				writerss.println(v);
				writerss.println(dtf.format(now));
				writerss.println(email.subject());
				writerss.println(email.attach());
				writerss.println(email.periority());
				writerss.println(srkm);
				writerss.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// create file contain mail data.
			if (flag12 == 0) {
				File f22 = new File("Server" + File.separator + userin + File.separator + "Drafts" + File.separator + v
						+ File.separator + srkm + File.separator + "mail.txt");
				f22.getParentFile().mkdirs();
				try {
					f22.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/************* write the sent mail here *****************/
				PrintWriter writer12;
				try {
					writer12 = new PrintWriter(
							new FileOutputStream("Server" + File.separator + userin + File.separator + "Drafts"
									+ File.separator + v + File.separator + srkm + File.separator + "mail.txt", true));
					writer12.println(email.body());
					writer12.write("\n");
					writer12.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				flag12 = 0;
			}

			// the receiver
			// make a file of the sender if not exist and make index file contain the
			// information of the message//

			if (email.path() != null) {
				for (int j = 0; j < email.path().length; j++) {

					(new File("Server" + File.separator + userin // sender name
							+ File.separator + "Drafts" + File.separator + v + File.separator + srkm + File.separator
							+ "Attachment")).mkdirs();
					String pathu = "Server/" + userin + "/Drafts/" + v + "/" + srkm + "/Attachment/";
					File f2 = new File(email.path()[j]);
					try {
						Files.copy(f2.toPath(), (new File(pathu + f2.getName())).toPath(),
								StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

			if (i + 1 == email.names().length) {
				return true;
			}

		}
		return false;

	}

	public void test(IMail email) throws IOException {
		String[] arr1;
		String[] arr2;
		Double a = new Double();
		Double b = new Double();
		for (int i = 0; i < email.names().length; i++) {
			if (checkname(email.names()[i])) {
				a.add(email.names()[i]);
			} else {
				b.add(email.names()[i]);
			}
		}
		arr1 = new String[a.size()];
		arr2 = new String[b.size()];
		for (int i = 0; i < a.size(); i++) {
			arr1[i] = (String) a.get(i);
		}

		for (int i = 0; i < b.size(); i++) {
			arr2[i] = (String) b.get(i);
		}
		Email d = new Email();
		Email f = new Email();
		d.rec = arr1.clone();
		f.rec = arr2.clone();
		if (email.path() != null) {
			d.att = email.path().clone();
		}
		d.attch = email.attach();
		d.body = email.body();
		d.dat = email.d();
		d.sub = email.subject();
		d.per = email.periority();
		d.srkm = email.rkm();
		d.person = email.pers();

		if (email.path() != null) {
			f.att = email.path().clone();
		}

		f.attch = email.attach();
		f.body = email.body();
		f.dat = email.d();
		f.sub = email.subject();
		f.per = email.periority();
		f.srkm = email.rkm();
		f.person = email.pers();
		compose(d);
		draft(f);
	}

	public boolean checkname(String name) throws IOException {

		File file = new File("server//Names file.txt");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			while (line != null) {
				if (name.equals(line)) {

					br.close();
					return true;
				}
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		return false;
	}

	public void twoemails(String a, String b) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(new FileOutputStream("Server" + File.separator + "Dual.txt", true));
		writer.println(a);
		writer.println(b);
		writer.write("\n");
		writer.close();
	}

	public void filter(String check, IMail email) {
		System.out.println(check + email.names()[0]);
		(new File("Server" + File.separator + email.names()[0] // sender name
				+ File.separator + "Filters" + File.separator + check)).mkdirs();
		if (check.equals("name")) {
			(new File("Server" + File.separator + email.names()[0] // sender name
					+ File.separator + "Filters" + File.separator + check + File.separator + userin)).mkdirs();
			Filtering a = new Filtering();
			a.filtername(email);
		} else if (check.equals("subject")) {
			(new File("Server" + File.separator + email.names()[0] // sender name
					+ File.separator + "Filters" + File.separator + check + File.separator + email.subject())).mkdirs();
			(new File("Server" + File.separator + email.names()[0] // sender name
					+ File.separator + "Filters" + File.separator + check + File.separator + email.subject()
					+ File.separator + userin)).mkdirs();
			Filtering a = new Filtering();
			a.filtersub(email);

		}
	}

	void sortdate() {
		sort a = new sort();
		a.set("year");
		a.sorting(all);

		a.set("month");
		a.sorting(all);

		a.set("day");
		a.sorting(all);
	}

	Double searchdate(String y, String m, String d) {
		System.out.println(y + m + d);
		System.out.println(all.size());
		Filter a = new Filter();
		sort b = new sort();
		Double s1 = a.yearsearch(all, Integer.parseInt(y));
		b.set("month");
		s1 = b.sorting(s1);
		Double s2 = a.monthsearch(s1, Integer.parseInt(m));
		b.set("day");
		s2 = b.sorting(s2);
		Double s3 = a.daysearch(s2, Integer.parseInt(d));
		return s3;
	}

	boolean rightn(String name, String name1) throws IOException {
		File file = new File("Server/" + name + "/Filters/name.txt");
		if (!file.exists()) {
			return false;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			while (line != null) {
				if (name1.equals(line)) {

					return true;
				}
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		return false;

	}

	boolean rights(String name, String sub) throws IOException {
		File file = new File("Server/" + name + "/Filters/subject.txt");
		if (!file.exists()) {
			return false;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			while (line != null) {
				if (sub.equals(line)) {

					return true;
				}
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		return false;
	}

	public static void setpass(String pass) {
		int index = 0;
		Double b = new Double();
		File f = new File("Server" + File.separator + "Names file.txt");
		int i = 0;
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (sc.hasNextLine()) {

			String a = sc.nextLine();
			b.add(a);
			if (a.equals(userin)) {
				index = i + 1;
			}
			i++;
		}
		b.set(index, pass);
		PrintWriter writersss;
		try {
			writersss = new PrintWriter(new FileOutputStream("Server" + File.separator + "Names file.txt", false));
			for (i = 0; i < b.size(); i++) {

				writersss.println(b.get(i));
			}
			writersss.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void del2() throws ParseException {
		Double b = new Double();
		String name = "";
		String date = "";
		String sub = "";
		String att = "";
		String imp = "";
		String fname = "";
		File f = new File("Server" + File.separator + userin + File.separator + "Trash" + File.separator + "Inbox"
				+ File.separator + "index.txt");
		if (!f.exists()) {

			return;
		}
		Scanner sc = null;

		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (sc.hasNextLine()) {

			name = sc.nextLine();
			date = sc.nextLine();
			sub = sc.nextLine();
			att = sc.nextLine();
			imp = sc.nextLine();
			fname = sc.nextLine();
			System.out.println(date);
			b.add(name);
			b.add(date);
			b.add(sub);
			b.add(att);
			b.add(imp);
			b.add(fname);
			String sDate5 = date;
			SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date5 = formatter5.parse(sDate5);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String n = dtf.format(now);
			Date Date4 = formatter5.parse(n);
			long x1 = Date4.getTime() / 10000;
			long x2 = date5.getTime() / 10000;

			long l = (30 * 24 * 60 * 60) / 10;
			System.out.println(x1 - x2);
			System.out.println(l);
			if ((x1 - x2) >= l) {

				File directory = new File(
						"Server/" + userin + "/" + "Trash" + "/" + "Inbox" + "/" + name + "/" + fname);

				try {

					delete(directory);

				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);
			}

		}

		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileOutputStream("Server" + File.separator + userin + File.separator + "trash"
					+ File.separator + "Inbox" + File.separator + "index.txt"));
			for (int i = 0; i < b.size(); i++) {
				writer.println(b.get(i));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.close();

	}

	public void del1() throws ParseException {
		Double b = new Double();
		String name = "";
		String date = "";
		String sub = "";
		String att = "";
		String imp = "";
		String fname = "";
		File f = new File("Server" + File.separator + userin + File.separator + "Trash" + File.separator + "Sent Mails"
				+ File.separator + "index.txt");
		if (!f.exists()) {

			return;
		}
		Scanner sc = null;

		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (sc.hasNextLine()) {

			name = sc.nextLine();
			date = sc.nextLine();
			sub = sc.nextLine();
			att = sc.nextLine();
			imp = sc.nextLine();
			fname = sc.nextLine();
			System.out.println(date);
			b.add(name);
			b.add(date);
			b.add(sub);
			b.add(att);
			b.add(imp);
			b.add(fname);
			String sDate5 = date;
			SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date5 = formatter5.parse(sDate5);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String n = dtf.format(now);
			Date Date4 = formatter5.parse(n);
			long x1 = Date4.getTime() / 10000;
			long x2 = date5.getTime() / 10000;

			long l = (30 * 24 * 60 * 60) / 10;
			if ((x1 - x2) >= l) {

				File directory = new File(
						"Server/" + userin + "/" + "Trash" + "/" + "Sent Mails" + "/" + name + "/" + fname);

				try {

					delete(directory);

				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);

				b.remove(b.size() - 1);
			}

		}

		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileOutputStream("Server" + File.separator + userin + File.separator + "trash"
					+ File.separator + "Sent Mails" + File.separator + "index.txt"));
			for (int i = 0; i < b.size(); i++) {
				writer.println(b.get(i));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.close();

	}
}
