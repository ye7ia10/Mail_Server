package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

public class testaya {
	public static void main(String[] args) {
		MailServer x = new MailServer();
		if (x.signin("yehia", "123456")) {
			System.out.println("eqr");
		}

		Email y = new Email();
		x.signin("yehia", "1236");
		y.body = "ahmed hi";
		String[] n = { "ahmed", "madrid" }; // receiver
		y.rec = n.clone();
		y.person = "yehya";
		y.attch = 10;
		y.per = 5;
		y.sub = "xxx";
		x.compose(y);

		/*
		 * folds f= new folds(); f.folders("Sent Mails"); f.read();
		 */
		// Mailinfo u = (Mailinfo) MailServer.all.get(0);
		// System.out.println(u.person);
		// Mailinfo[] m = (Mailinfo[]) x.listEmails(1);
		// Mailinfo m = (Mailinfo) MailServer.all.get(0);
		// System.out.println(m.person);
		/*
		 * for (int i = 0; i < m.length ; i++) { Mailinfo u = new Mailinfo(); u = m[i];
		 * System.out.println(u.person); } MailServer.all.clear();
		 */
		/*
		 * String p = "D:\\test.txt";
		 *
		 *
		 * Path x = (Path) Paths.get("D:\\test.txt"); Path y = (Path)
		 * Paths.get("D:\\test2.txt");
		 *
		 *
		 * java.nio.file.Files.copy(x, y);
		 */
		/*
		 * sort s = new sort(); Double a = new Double(); s.set("year"); a.add("bae");
		 * a.add("nasser"); a.add("ahmed"); a.add("ss"); a.add("omar");
		 * a.add("mohamed"); a.add("yehia"); Double y2 = s.sorting(MailServer.all); for
		 * (int i =0 ; i < y2.size() ; i++) { Email u = new Email(); u = (Email)
		 * y2.get(i); System.out.println(u.year); }
		 * System.out.println("hgajdhgasjdhas"); Filter a1 = new Filter(); Double y1 =
		 * a1.subjectsearch(y2, "ahuuuuuu"); for (int i =0 ; i < y1.size() ; i++) {
		 * Email u = new Email(); u = (Email) y1.get(i); System.out.println(u.sub); }
		 * MailServer.inout = "Sent Mails"; //x.deleteEmails(MailServer.all); }
		 *
		 *
		 */

	}
}
