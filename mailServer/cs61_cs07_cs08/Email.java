package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

/**
 * for (int i = 0; i < email.names().length ; i++) {
         //create folder for the sender in compose folder.
			String v = email.names()[i];
		(new File("Server" + File.separator + userin //sender name
				+ File.separator + "Sent Mails"
				+ File.separator + v)).mkdirs();

        //create file contain mail data.
		File f = new File("Server" + File.separator + userin
				+ File.separator + "Sent Mails"
				+ File.separator + v + File.separator + "mail.txt");
		f.getParentFile().mkdirs();
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileOutputStream("Server" + File.separator +
					userin+ File.separator +
					"Sent Mails"+ File.separator +
					v + File.separator +
					"mail.txt", true));
			writer.println(email.body());
			writer.write("\n");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// the receiver
		(new File("Server" + File.separator + v
				+ File.separator + "Inbox"
				+ File.separator + userin)).mkdirs();

        //create file contain mail data.
		File ff = new File("Server" + File.separator + v
				+ File.separator + "Inbox"
				+ File.separator + userin + File.separator + "mail.txt");
		ff.getParentFile().mkdirs();
		try {
			ff.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writers;
		try {
			writers = new PrintWriter(new FileOutputStream("Server" + File.separator +
					v + File.separator +
					"Inbox"+ File.separator +
					userin + File.separator +
					"mail.txt", true));
			writers.println(email.body());
			writers.write("\n");
			writers.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		}
		return false;
 */

import eg.edu.alexu.csd.datastructure.mailServer.IMail;

public class Email implements IMail {
	public String body;
	public String[] rec;
	public String[] att;
	public int attch;
	public int per;
	public String sub;
	String person;
	String dat;
	int year;
	int day;
	int month;
	int srkm;

	@Override
	public String body() {
		// TODO Auto-generated method stub
		return body;
	}

	@Override
	public String[] names() {
		// TODO Auto-generated method stub
		return rec;
	}

	@Override
	public String[] path() {
		// TODO Auto-generated method stub
		return att;
	}

	@Override
	public int attach() {
		// TODO Auto-generated method stub
		return attch;
	}

	@Override
	public int periority() {
		// TODO Auto-generated method stub
		return per;
	}

	@Override
	public String subject() {
		// TODO Auto-generated method stub
		return sub;
	}

	@Override
	public String pers() {
		// TODO Auto-generated method stub
		return person;
	}

	@Override
	public String d() {
		// TODO Auto-generated method stub
		return dat;
	}

	@Override
	public int rkm() {
		// TODO Auto-generated method stub
		return srkm;
	}

}
