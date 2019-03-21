package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import java.io.IOException;

public class CopyFile {

	public static void main(String[] args) throws IOException {

		Email a = new Email();
		a.body = "ahmaaaaaad";
		MailServer x = new MailServer();
		x.signin("yehya", "123");
		String[] r = { "C:\\Users\\ahmed hd/ahmed.jpg" };
		a.att = r.clone();
		String[] re = { "arsany" };
		a.rec = re.clone();
		x.compose(a);
	}
}