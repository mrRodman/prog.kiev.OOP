
public class Main {

	public static void main(String[] args) {
		Dock dock = new Dock();
		Port port = new Port(dock);
		
		Ship[] ships = new Ship[3];

		for (int i = 0; i < ships.length; i++) {
			ships[i] = new Ship("Ship" + i, port);
		}	
		
		Thread[] threads = new Thread[ships.length];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(ships[i]);
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}
