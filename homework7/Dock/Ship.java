
public class Ship implements Runnable{
	private int cargo;
	private String name;
	private Port port;
	
	public Ship(String name, Port port) {
		super();
		this.name = name;
		this.port = port;
		this.cargo = 10;
	}

	public Ship() {
		super();
	}
	
	@Override
	public void run() {
		port.sailToDock(this);
	}

	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
