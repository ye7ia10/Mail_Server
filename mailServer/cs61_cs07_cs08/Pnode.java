package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

/**
 *
 * @author KCc
 *
 */
public class Pnode {
	/**
	 * value of node.
	 */
	Object val = null;
	/**
	 * the key.
	 */
	int key;

	/**
	 * empty constructor.
	 */
	public Pnode() {

	}

	/**
	 * define the node.
	 *
	 * @param v
	 *            is the object.
	 * @param k
	 *            is the key.
	 */
	public Pnode(final Object v, final int k) {
		val = v;
		key = k;
	}
}
