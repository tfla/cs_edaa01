public class PrioComparator implements Comparator<Patient> {
	public int compare(Patient p1, Patient p2) {
		if (p1.getPrio() == p2.getPrio()) {
			return p1.getNumber() - p2.getNumber();
		}
		else {
			return p1.getPrio() - p2.getPrio();
		}
	}
}
