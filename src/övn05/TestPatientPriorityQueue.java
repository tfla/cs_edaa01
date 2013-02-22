public class TestPatientPriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Patient> pq = new PriorityQueue<Patient>();
		pq.offer(new Patient("Kalle", "Karlsson", "850322-1213", 3));
		pq.offer(new Patient("Lisa", "Svensson", "840312-1224", 2));
		pq.offer(new Patient("Lena", "Nilsson", "820323-1224", 3));
	}
}
