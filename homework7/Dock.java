
public class Dock {

	public Dock() {
		
	}
	
	public void piersidOperation(Ship ship) {
		try {
			int t = ship.getCargo();
			for (int i = 0; i < t; i++) {
				int temp = ship.getCargo();
				System.out.println(ship.getName() + " is unloading " + temp + "th cargo");
				temp--;
				ship.setCargo(temp);
				Thread.currentThread().sleep(500);
			}
			
			System.out.println(ship.getName() + " is finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
