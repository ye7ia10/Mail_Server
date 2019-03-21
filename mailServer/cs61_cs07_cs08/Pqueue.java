package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import eg.edu.alexu.csd.datastructure.mailServer.IPriorityQueue;

/**
 *
 * @author KCc
 *
 */
public class Pqueue implements IPriorityQueue {
	/**
	 * head node.
	 */
	Prnode start;
	/**
	 * tail node.
	 */
	Prnode end;
	/**
	 * size.
	 */
	int size = 0;

	/**
	 * @param key.
	 * @param data.
	 */
	@Override
	public void insert(final Object item, final int key) {
		// TODO Auto-generated method stub
		if (key < 1) {
			throw new RuntimeException();
		}
		Pnode n = new Pnode(item, key);
		if (!item.equals(null)) {
			Prnode nptr = new Prnode(n, null, null);
			Prnode temp = start;
			size++;

			if (size == 1) {
				if (start == null) {
					start = nptr;
					end = start;
					return;
				}
			}
			int index = 0;
			Pnode t = (Pnode) temp.getdata();
			if (t.key > key) {
				if (index == 0) {
					nptr.setnext(start);
					start.setprev(nptr);
					start = nptr;
					return;
				}
			}
			t = (Pnode) end.getdata();
			if (t.key <= key) {
				nptr.setprev(end);
				end.setnext(nptr);
				end = nptr;
				return;
			}
			while (index < size) {
				index++;
				Pnode t1 = (Pnode) temp.getdata();
				if (t1.key > key) {
					Prnode nptr1 = temp.getprev();
					nptr1.setnext(nptr);
					temp.setprev(nptr);
					nptr.setprev(nptr1);
					nptr.setnext(temp);
					return;
				}
				if (index == size - 1) {
					if (t1.key <= key) {
						nptr.setprev(end);
						end.setnext(nptr);
						end = nptr;
						return;
					} else {
						return;
					}
				}
				temp = temp.getnext();
			}
		}
		throw new RuntimeException();
	}

	/**
	 * @return object the data with high and remove.
	 */
	@Override
	public Object removeMin() {
		// TODO Auto-generated method stub
		Pnode res;
		if (size == 1) {
			size--;
			res = (Pnode) start.getdata();
			start = null;
			return res.val;
		}
		if (size > 0) {
			res = (Pnode) start.getdata();
			start = start.getnext();
			start.setprev(null);
			size--;
			return res.val;
		}
		throw new RuntimeException();
	}

	/**
	 * @return data without removing.
	 */
	@Override
	public Object min() {
		// TODO Auto-generated method stub
		Pnode res;
		if (size == 1) {
			res = (Pnode) start.getdata();
			return res.val;
		}
		if (size > 0) {
			res = (Pnode) start.getdata();
			return res.val;
		}
		throw new RuntimeException();
	}

	/**
	 * check is empty.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	/**
	 * @return the size.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
