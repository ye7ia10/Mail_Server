package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import eg.edu.alexu.csd.datastructure.mailServer.IContact;

public class Details implements IContact {

	public String name;
	public String pass;
	public String Finame;
	public String Laname;

	@Override
	public String name() {
		// TODO Auto-generated method stub

		return name;
	}

	@Override
	public String pass() {
		// TODO Auto-generated method stub
		return pass;
	}

	@Override
	public String Fname() {
		// TODO Auto-generated method stub
		return Finame;
	}

	@Override
	public String Lname() {
		// TODO Auto-generated method stub
		return Laname;
	}

}
