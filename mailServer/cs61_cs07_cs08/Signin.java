package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Linked;

public class Signin {

	private static Linked data = new Linked();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String user = null;
		String pass = null;
		System.out.println("enter user name : ");
		user = s.nextLine();
		System.out.println("enter password : ");
		pass = s.nextLine();
		if (signin(user, pass)) {
			System.out.println("Welcome " + user);
		} else {
			System.out.println("user or passwoed doesn't match");
		}
		s.close();

	}

	public static void open() throws IOException {
		File file = new File("Server\\Names file.txt");

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
				data.add(line);
				line = br.readLine();
			}
		} finally {
			br.close();
		}

	}

	public static boolean signin(String email, String password) {
		try {
			open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!data.contains(email) || !data.contains(password)) {
			return false;
		} else {
			int iemail = 0;
			int ipass = 0;
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).equals(email)) {
					iemail = i;
				} else if (data.get(i).equals(password)) {
					ipass = i;
				}
			}
			if (ipass - iemail == 1) {
				return true;
			} else {
				return false;
			}

		}

	}
}
