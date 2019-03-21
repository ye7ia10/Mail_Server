package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.mailServer.IMail;

public class Filtering {
	boolean filtername(IMail email) {

		// create folder for the sender in sent folder.
		// v is the name of reciever
		String v = email.names()[0];
		File fff = new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "name"
				+ File.separator + MailServer.userin + File.separator + "index1.txt");
		fff.getParentFile().mkdirs();
		try {
			fff.createNewFile();
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}

		int rkm = 0;
		File f = new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "name"
				+ File.separator + MailServer.userin + File.separator + "index1.txt");
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

		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Server" + File.separator + v + File.separator + "Filters" + File.separator
					+ "name" + File.separator + MailServer.userin + File.separator + "index1.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		writer.println(rkm);
		writer.close();

		// sender

		// create file contain mail data.

		// the receiver
		// make a file of the sender if not exist and make index file contain the
		// information of the message//
		(new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "name" + File.separator
				+ MailServer.userin)).mkdirs();

		File fff1 = new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "name"
				+ File.separator + MailServer.userin + File.separator + "index.txt");
		fff1.getParentFile().mkdirs();
		try {
			fff1.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		/// write the information of the sent email
		PrintWriter writersss;
		try {
			writersss = new PrintWriter(
					new FileOutputStream("Server" + File.separator + v + File.separator + "Filters" + File.separator
							+ "name" + File.separator + MailServer.userin + File.separator + "index.txt", true));

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			writersss.println(MailServer.userin);
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
		File ff = new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "name"
				+ File.separator + MailServer.userin + File.separator + srkm + File.separator + "mail.txt");
		ff.getParentFile().mkdirs();
		try {
			ff.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writers;
		try {
			writers = new PrintWriter(new FileOutputStream(
					"Server" + File.separator + v + File.separator + "Filters" + File.separator + "name"
							+ File.separator + MailServer.userin + File.separator + srkm + File.separator + "mail.txt",
					true));
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

				(new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "name"
						+ File.separator + MailServer.userin + File.separator + srkm + File.separator + "Attachment"))
								.mkdirs();

				String path = "Server" + File.separator + v + File.separator + "Filters" + File.separator + "name"
						+ File.separator + MailServer.userin + File.separator + srkm + "/Attachment/";
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
		return false;
	}

	void filtersub(IMail email) {
		String v = email.names()[0];
		File fff = new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "subject"
				+ File.separator + email.subject() + File.separator + MailServer.userin + File.separator + "index.txt");
		fff.getParentFile().mkdirs();
		try {
			fff.createNewFile();
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}

		int rkm = 0;
		File f = new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "subject"
				+ File.separator + email.subject() + File.separator + MailServer.userin + File.separator + "index.txt");
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

		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Server" + File.separator + v + File.separator + "Filters" + File.separator
					+ "subject" + File.separator + email.subject() + File.separator + MailServer.userin + File.separator
					+ "index.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		writer.println(rkm);
		writer.close();

		// sender

		// create file contain mail data.

		// the receiver
		// make a file of the sender if not exist and make index file contain the
		// information of the message//
		(new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "subject"
				+ File.separator + email.subject() + File.separator + MailServer.userin)).mkdirs();

		File fff1 = new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "subject"
				+ File.separator + email.subject() + File.separator + MailServer.userin + File.separator + "index.txt");
		fff1.getParentFile().mkdirs();
		try {
			fff1.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		/// write the information of the sent email
		PrintWriter writersss;
		try {
			writersss = new PrintWriter(
					new FileOutputStream("Server" + File.separator + v + File.separator + "Filters" + File.separator
							+ "subject" + File.separator + email.subject() + File.separator + "index.txt", true));

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			writersss.println(MailServer.userin);
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
		File ff = new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "subject"
				+ File.separator + email.subject() + File.separator + MailServer.userin + File.separator + srkm
				+ File.separator + "mail.txt");
		ff.getParentFile().mkdirs();
		try {
			ff.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writers;
		try {
			writers = new PrintWriter(new FileOutputStream("Server" + File.separator + v + File.separator + "Filters"
					+ File.separator + "subject" + File.separator + email.subject() + File.separator + MailServer.userin
					+ File.separator + srkm + File.separator + "mail.txt", true));
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

				(new File("Server" + File.separator + v + File.separator + "Filters" + File.separator + "subject"
						+ File.separator + email.subject() + File.separator + MailServer.userin + File.separator + srkm
						+ File.separator + "Attachment")).mkdirs();

				String path = "Server" + File.separator + v + File.separator + "Filters" + File.separator + "subject"
						+ File.separator + email.subject() + File.separator + MailServer.userin + File.separator + srkm
						+ "/Attachment/";
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

	}
}
