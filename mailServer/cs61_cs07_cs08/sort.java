package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Double;
import eg.edu.alexu.csd.datastructure.mailServer.ISort;
import eg.edu.alexu.csd.datastructure.stack.cs61.Mystack;

public class sort implements ISort {
	public String kind;

	@Override
	public Double per(Double s) {
		// TODO Auto-generated method stub
		if (s.equals(null)) {
			throw new RuntimeException();
		}

		Pqueue a = new Pqueue();
		for (int i = 0; i < s.size(); i++) {
			Email p = (Email) s.get(i);
			a.insert(p, p.per);
		}
		s.clear();
		int s1 = a.size();
		for (int i = 0; i < s1; i++) {
			s.add(a.min());
			a.removeMin();
		}
		return s;
	}

	@Override
	public Double date(Double s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s.size() / 2; i++) {
			Email temp = (Email) s.get(i);
			s.set(i, s.get(s.size() - i - 1));
			s.set(s.size() - i - 1, temp);
		}

		return s;
	}

	// apply the sorting .
	@Override
	public Double sorting(Double s) {
		// TODO Auto-generated method stub
		Mystack stack = new Mystack();
		stack.push(0);
		stack.push(s.size());
		while (!stack.isEmpty()) {
			int end = (int) stack.pop();
			int start = (int) stack.pop();
			if (end - start < 2) {
				continue;
			}
			int p = start + ((end - start) / 2);
			if (kind.equals("name")) {
				p = partition(s, p, start, end);
			} else if (kind.equals("subject")) {
				p = partitionsub(s, p, start, end);
			} else if (kind.equals("attachment")) {
				p = partitionsatt(s, p, start, end);
			} else if (kind.equals("year")) {
				p = partitionyear(s, p, start, end);
			} else if (kind.equals("month")) {
				p = partitionmon(s, p, start, end);
			} else if (kind.equals("day")) {
				p = partitionday(s, p, start, end);
			}
			stack.push(p + 1);
			stack.push(end);

			stack.push(start);
			stack.push(p);
		}
		return s;
	}

	// for the name sorting
	public int partition(Double s, int pos, int start, int end) {
		int l = start;
		int h = end - 2;
		Email q = (Email) s.get(pos);
		String piv = q.person;
		swap(s, pos, end - 1);
		while (l < h) {
			Email r = (Email) s.get(l);
			Email t = (Email) s.get(h);
			if ((r.person).compareTo(piv) < 0) {
				l++;
			} else if ((t.person).compareTo(piv) >= 0) {
				h--;
			} else {
				swap(s, l, h);
			}
		}
		int idx = h;
		Email t = (Email) s.get(h);
		if ((t.person).compareTo(piv) < 0) {
			idx++;
		}
		swap(s, end - 1, idx);
		return idx;
	}

	// for the subject sorting
	public int partitionsub(Double s, int pos, int start, int end) {
		int l = start;
		int h = end - 2;
		Email q = (Email) s.get(pos);
		String piv = q.sub;
		swap(s, pos, end - 1);
		while (l < h) {
			Email r = (Email) s.get(l);
			Email t = (Email) s.get(h);
			if ((r.sub).compareTo(piv) < 0) {
				l++;
			} else if ((t.sub).compareTo(piv) >= 0) {
				h--;
			} else {
				swap(s, l, h);
			}
		}
		int idx = h;
		Email t = (Email) s.get(h);
		if ((t.sub).compareTo(piv) < 0) {
			idx++;
		}
		swap(s, end - 1, idx);
		return idx;
	}

	// for the attach sorting
	public int partitionsatt(Double s, int pos, int start, int end) {
		int l = start;
		int h = end - 2;
		Email q = (Email) s.get(pos);
		int piv = q.attch;
		swap(s, pos, end - 1);
		while (l < h) {
			Email r = (Email) s.get(l);
			Email t = (Email) s.get(h);
			if (r.attch >= piv) {
				l++;
			} else if (t.attch < piv) {
				h--;
			} else {
				swap(s, l, h);
			}
		}
		int idx = h;
		Email t = (Email) s.get(h);
		if (t.attch > piv) {
			idx++;
		}
		swap(s, end - 1, idx);
		return idx;
	}

	// for the year sorting
	public int partitionyear(Double s, int pos, int start, int end) {
		int l = start;
		int h = end - 2;
		Email q = (Email) s.get(pos);
		int piv = q.year;
		swap(s, pos, end - 1);
		while (l < h) {
			Email r = (Email) s.get(l);
			Email t = (Email) s.get(h);
			if (r.year < piv) {
				l++;
			} else if (t.year >= piv) {
				h--;
			} else {
				swap(s, l, h);
			}
		}
		int idx = h;
		Email t = (Email) s.get(h);
		if (t.year < piv) {
			idx++;
		}
		swap(s, end - 1, idx);
		return idx;
	}

	// for the month sorting
	public int partitionmon(Double s, int pos, int start, int end) {
		int l = start;
		int h = end - 2;
		Email q = (Email) s.get(pos);
		int piv = q.month;
		swap(s, pos, end - 1);
		while (l < h) {
			Email r = (Email) s.get(l);
			Email t = (Email) s.get(h);
			if (r.month < piv) {
				l++;
			} else if (t.month >= piv) {
				h--;
			} else {
				swap(s, l, h);
			}
		}
		int idx = h;
		Email t = (Email) s.get(h);
		if (t.month < piv) {
			idx++;
		}
		swap(s, end - 1, idx);
		return idx;
	}

	// for the day sorting
	public int partitionday(Double s, int pos, int start, int end) {
		int l = start;
		int h = end - 2;
		Email q = (Email) s.get(pos);
		int piv = q.day;
		swap(s, pos, end - 1);
		while (l < h) {
			Email r = (Email) s.get(l);
			Email t = (Email) s.get(h);
			if (r.day < piv) {
				l++;
			} else if (t.day >= piv) {
				h--;
			} else {
				swap(s, l, h);
			}
		}
		int idx = h;
		Email t = (Email) s.get(h);
		if (t.day < piv) {
			idx++;
		}
		swap(s, end - 1, idx);
		return idx;
	}

	public void swap(Double s, int i, int j) {
		Email temp = (Email) s.get(i);
		s.set(i, s.get(j));
		s.set(j, temp);
	}

	@Override
	public void set(String k) {
		// TODO Auto-generated method stub
		kind = k;
	}

	@Override
	public String get() {
		return kind;
	}

}
