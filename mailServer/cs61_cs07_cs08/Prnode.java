package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

/**
 *
 * @author KCc
 *
 */
public class Prnode {
	/**
	 * object.
	 */
	Object element = null;
	/**
	 * next.
	 */
	Prnode next = null;
	/**
	 * previous.
	 */
	Prnode prev = null;

	/**
	 * empty constructor.
	 */
	public Prnode() {

	}

	/**
	 *
	 * @param e
	 *            object.
	 * @param l
	 *            next node.
	 * @param p
	 *            previous node.
	 */
	public Prnode(final Object e, final Prnode l, final Prnode p) {
		element = e;
		next = l;
		prev = p;
	}

	/**
	 *
	 * @param l
	 *            set next.
	 */
	public void setnext(final Prnode l) {
		next = l;
	}

	/**
	 *
	 * @param p
	 *            set prev.
	 */
	public void setprev(final Prnode p) {
		prev = p;
	}

	/**
	 * set data.
	 *
	 * @param e
	 *            data.
	 */
	public void setdata(final Object e) {
		element = e;
	}

	/**
	 *
	 * @return data.
	 */
	Object getdata() {
		return element;
	}

	/**
	 *
	 * @return next node.
	 */
	Prnode getnext() {
		return next;
	}

	/**
	 *
	 * @return prev node.
	 */
	Prnode getprev() {
		return prev;
	}
}
