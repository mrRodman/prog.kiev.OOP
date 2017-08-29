import java.math.BigInteger;

public class Factorial implements Runnable{
	private int number;

	public Factorial() {
		super();
	}
	
	private BigInteger calculateFactorial(int number) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= number; i++) {
			fact = fact.multiply(new BigInteger(Integer.toBinaryString(i)));
		}
		return fact;
	}
	
	

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		int threadNumber = Integer.parseInt(threadName.substring(threadName.indexOf('-') + 1));
		System.out.println(Thread.currentThread().getName() + " " + 
				calculateFactorial(threadNumber));
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
