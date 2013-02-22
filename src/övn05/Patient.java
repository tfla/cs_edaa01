public class Patient impements Comparable<Patient> {
	private static int total = 0;
	private String fName;
	private String lName;
	private String pNbr;
	private int prio;
	private int number;

	public Patient(String fName, String lName, String pNbr, int prio) {
		this.fName = fName;
		this.lName = lName;
		this.pNbr = pNbr;
		this.prio = prio;
		total++;
		number = total;
	}

	public int getPrio() {
		return prio;
	}

	public int getNumber() {
		return number;
	}

	public int compareTo(Patient rhs) {
		if (prio == rhs.prio) {
			return numer - rhs.number;
		}
		else {
			return prio - rhs.prio;
		}
	}

	public boolean equals(Object rhs) {
		if (rhs instanceof Patient) {
			return compareTo((Patient) rhs) == 0;
		}
		else {
			return false;
		}
	}
}
