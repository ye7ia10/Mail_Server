package eg.edu.alexu.csd.datastructure.mailServer;



import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Double;

public interface IFilter {
	// search
	Double namesearch(Double link, String name);
	Double subjectsearch(Double link, String subject);
	Double yearsearch(Double link, int year);
	Double monthsearch(Double link, int month);
	Double daysearch(Double link, int day);
	Double persearch(Double link, int per);
	public String FilterName ();
	public void setF (String f);
}
