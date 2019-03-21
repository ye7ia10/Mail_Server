package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import eg.edu.alexu.csd.datastructure.linkedList.cs07_cs61.Double;
import eg.edu.alexu.csd.datastructure.mailServer.IFilter;
import eg.edu.alexu.csd.datastructure.stack.cs61.Mystack;

public class Filter implements IFilter {
	/**
	 * date search
	 */
	public String type;

	@Override
	public String FilterName() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public Double namesearch(Double link, String name) {
		// TODO Auto-generated method stub
		Double list = new Double();
		int l = 0;
		int r = link.size() - 1;

		int mid = l + (r - l) / 2;
		Mystack a = new Mystack();
		a.push(link.get(mid));
		while (!a.isEmpty() && l <= r) {
			Email b = (Email) a.pop();
			if (b.person.equals(name)) {
				mid = l + (r - l) / 2;
				list.add(b);
				int s12 = mid;
				if (mid - 1 >= 0) {
					while (mid - 1 >= 0) {
						Email akl = (Email) link.get(mid - 1);
						if (akl.person.equals(name)) {
							list.add(akl);
							mid--;
						} else {
							break;
						}
					}
				}
				mid = s12;
				if (mid + 1 <= link.size() - 1) {

					while (mid + 1 <= link.size() - 1) {
						Email akl = (Email) link.get(mid + 1);
						if (akl.person.equals(name)) {
							list.add(akl);
							mid++;
						} else {
							break;
						}
					}
				}
				break;
			} else if (l <= r) {
				if (b.person.compareTo(name) > 0) {
					r = mid - 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				} else {
					l = mid + 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				}
			} else {
				break;
			}
		}
		return list;
	}

	@Override
	public Double subjectsearch(Double link, String subject) {
		// TODO Auto-generated method stub
		Double list = new Double();
		int l = 0;
		int r = link.size() - 1;

		int mid = l + (r - l) / 2;
		Mystack a = new Mystack();
		a.push(link.get(mid));
		while (!a.isEmpty() && l <= r) {
			Email b = (Email) a.pop();
			if (b.sub.equals(subject)) {
				mid = l + (r - l) / 2;
				list.add(b);
				int s12 = mid;
				if (mid - 1 >= 0) {
					while (mid - 1 >= 0) {
						Email akl = (Email) link.get(mid - 1);
						if (akl.sub.equals(subject)) {
							list.add(akl);
							mid--;
						} else {
							break;
						}
					}
				}
				mid = s12;
				if (mid + 1 <= link.size() - 1) {

					while (mid + 1 <= link.size() - 1) {
						Email akl = (Email) link.get(mid + 1);
						if (akl.sub.equals(subject)) {
							list.add(akl);
							mid++;
						} else {
							break;
						}
					}
				}
				break;
			} else if (l <= r) {
				if (b.sub.compareTo(subject) > 0) {
					r = mid - 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				} else {
					l = mid + 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				}
			} else {
				break;
			}
		}
		return list;
	}

	@Override
	public Double yearsearch(Double link, int year) {
		// TODO Auto-generated method stub
		Double list = new Double();
		int l = 0;
		int r = link.size() - 1;

		int mid = l + (r - l) / 2;
		Mystack a = new Mystack();
		a.push(link.get(mid));
		while (!a.isEmpty() && l <= r) {
			Email b = (Email) a.pop();
			if (b.year == (year)) {
				mid = l + (r - l) / 2;
				list.add(b);
				int s12 = mid;
				if (mid - 1 >= 0) {
					while (mid - 1 >= 0) {
						Email akl = (Email) link.get(mid - 1);
						if (akl.year == year) {
							list.add(akl);
							mid--;
						} else {
							break;
						}
					}
				}
				mid = s12;
				if (mid + 1 <= link.size() - 1) {

					while (mid + 1 <= link.size() - 1) {
						Email akl = (Email) link.get(mid + 1);
						if (akl.year == year) {
							list.add(akl);
							mid++;
						} else {
							break;
						}
					}
				}
				break;
			} else if (l <= r) {
				if (b.year > year) {
					r = mid - 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				} else {
					l = mid + 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				}
			} else {
				break;
			}
		}
		return list;
	}

	@Override
	public Double monthsearch(Double link, int month) {
		// TODO Auto-generated method stub
		Double list = new Double();
		int l = 0;
		int r = link.size() - 1;

		int mid = l + (r - l) / 2;
		Mystack a = new Mystack();
		a.push(link.get(mid));
		while (!a.isEmpty() && l <= r) {
			Email b = (Email) a.pop();
			if (b.month == (month)) {
				mid = l + (r - l) / 2;
				list.add(b);
				int s12 = mid;
				if (mid - 1 >= 0) {
					while (mid - 1 >= 0) {
						Email akl = (Email) link.get(mid - 1);
						if (akl.month == month) {
							list.add(akl);
							mid--;
						} else {
							break;
						}
					}
				}
				mid = s12;
				if (mid + 1 <= link.size() - 1) {

					while (mid + 1 <= link.size() - 1) {
						Email akl = (Email) link.get(mid + 1);
						if (akl.month == month) {
							list.add(akl);
							mid++;
						} else {
							break;
						}
					}
				}
				break;
			} else if (l <= r) {
				if (b.month > month) {
					r = mid - 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				} else {
					l = mid + 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				}
			} else {
				break;
			}
		}
		return list;
	}

	@Override
	public Double daysearch(Double link, int day) {
		// TODO Auto-generated method stub
		Double list = new Double();
		int l = 0;
		int r = link.size() - 1;

		int mid = l + (r - l) / 2;
		Mystack a = new Mystack();
		a.push(link.get(mid));
		while (!a.isEmpty() && l <= r) {
			Email b = (Email) a.pop();
			if (b.day == (day)) {
				mid = l + (r - l) / 2;
				list.add(b);
				int s12 = mid;
				if (mid - 1 >= 0) {
					while (mid - 1 >= 0) {
						Email akl = (Email) link.get(mid - 1);
						if (akl.day == day) {
							list.add(akl);
							mid--;
						} else {
							break;
						}
					}
				}
				mid = s12;
				if (mid + 1 <= link.size() - 1) {

					while (mid + 1 <= link.size() - 1) {
						Email akl = (Email) link.get(mid + 1);
						if (akl.day == day) {
							list.add(akl);
							mid++;
						} else {
							break;
						}
					}
				}
				break;
			} else if (l <= r) {
				if (b.day > day) {
					r = mid - 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				} else {
					l = mid + 1;
					a.push(link.get(l + ((r - l) / 2)));
					mid = l + ((r - l) / 2);
				}
			} else {
				break;
			}
		}
		return list;
	}

	@Override
	public Double persearch(Double link, int per) {
		// TODO Auto-generated method stub
		Double list = new Double();
		int l = 0;
		int r = link.size() - 1;
		Email akl = new Email();
		int mid = l + (r - l) / 2;
		Mystack a = new Mystack();
		a.push(link.get(mid));
		while (!a.isEmpty() && l <= r) {
			Email b = (Email) a.pop();
			if (b.per == per) {
				list.add(b);
				mid = l + (r - l) / 2;
				int s12 = mid;
				if (mid - 1 >= 0) {

					while (mid - 1 >= 0) {
						akl = (Email) link.get(mid - 1);
						if (akl.per == per) {
							list.add(akl);
							mid--;
						} else {
							break;
						}
					}
				}
				mid = s12;
				if (mid + 1 <= link.size() - 1) {

					while (mid + 1 <= link.size() - 1) {
						akl = (Email) link.get(mid + 1);
						if (akl.per == per) {
							list.add(akl);
							mid++;
						} else {
							break;
						}
					}
				}
			} else if (l <= r) {
				if (b.per > per) {
					r = mid - 1;
					a.push(link.get(l + (r - l) / 2));
				} else {
					l = mid + 1;
					a.push(link.get(l + (r - l) / 2));
				}
			} else {
				break;
			}
		}
		return list;
	}

	@Override
	public void setF(String f) {
		// TODO Auto-generated method stub
		type = f;

	}

}
