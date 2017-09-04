
public class Port {
	
	private Dock dock;
	private int count;

	public Port(Dock dock) {
		super();
		this.dock = dock;
		count = 0;
	}
	
	public Port() {
		
	}
	private synchronized void waitMethod(Ship ship) {
		for (;count > 2;) {
			try {
				wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		sailToDock(ship);
	}
	
	private synchronized void notifyMethod() {
		notifyAll();
	}
	
	public void sailToDock(Ship ship) {
		if (ship == null) {
			System.out.println("The Flying Dutchman cann't be served");
			return;
		}
		count++;
		if (count > 2) {
			waitMethod(ship);
		} else {
			dock.piersidOperation(ship);
			
		}
		if (ship.getCargo() == 0) {
			count--;
			notifyMethod();
		}
		
	}
}
