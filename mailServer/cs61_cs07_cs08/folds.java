package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import eg.edu.alexu.csd.datastructure.mailServer.IFolder;

public class folds implements IFolder {
	String aaa;
	String fold;
	MailServer x = new MailServer();
	public static String check;
	public static String delete;
	public static String back;

	@Override
	public void folders(String f) {
		// TODO Auto-generated method stub
		fold = f;
	}

	@Override
	public void read() {
		File file = new File("Server/" + MailServer.userin + "/" + fold + "/index.txt");
		aaa = "Server/" + MailServer.userin + "/" + fold + "/index.txt";
		MailServer.po = aaa;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String line = null;

			try {
				int i = 0;
				while (true) {
					line = br.readLine();
					if (line != null && (i % 6 == 0)) {
						Email temp = new Email();
						temp.person = line;
						// System.out.println(temp.person);
						temp.dat = br.readLine();
						// System.out.println(temp.dat);
						temp.sub = br.readLine();
						// System.out.println(temp.sub);
						temp.attch = Integer.parseInt(br.readLine());
						// System.out.println(temp.attch);
						temp.per = Integer.parseInt(br.readLine());
						temp.srkm = Integer.parseInt(br.readLine());
						// System.out.println(temp.per);
						MailServer.all.add(temp);
						i = i + 5;
						String d = temp.dat;
						String a = "";
						int flag = 0;
						for (int j = 0; j < d.length(); j++) {
							if (d.charAt(j) != '/') {
								a += d.charAt(j);
							} else {
								temp.year = Integer.parseInt(a);
								a = "";
								for (j++; j < d.length(); j++) {
									if (d.charAt(j) != '/') {
										a += d.charAt(j);
									} else {
										temp.month = Integer.parseInt(a);
										a = "";
										for (j++; j < d.length(); j++) {
											if (d.charAt(j) != ' ') {
												a += d.charAt(j);
											} else {
												temp.day = Integer.parseInt(a);
												a = "";
												flag = 1;
												break;
											}

										}
									}
									if (flag == 1) {
										break;
									}
								}
							}
							if (flag == 1) {
								break;
							}
						}
					}
					i++;
					if (line == null) {
						break;
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public String getFolder() {
		// TODO Auto-generated method stub
		return fold;
	}

	@Override
	public String getcheck() {
		// TODO Auto-generated method stub
		return check;
	}

	@Override
	public String getdelete() {
		// TODO Auto-generated method stub
		return delete;
	}

	@Override
	public String getback() {
		// TODO Auto-generated method stub
		return back;
	}

	public void setback(String s) {
		// TODO Auto-generated method stub
		back = s;
	}

	public void setdelete(String s) {
		// TODO Auto-generated method stub
		delete = s;
	}

	public void setcheck(String s) {
		// TODO Auto-generated method stub
		check = s;
	}

}
