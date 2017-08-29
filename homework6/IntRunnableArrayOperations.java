import java.util.Arrays;

public class IntRunnableArrayOperations {

	public static int[][] divideRunnableArray(int[] array, int numberOfparts) {
		int[][] parts = new int[numberOfparts][];
		for (int i = 0; i < parts.length; i++) {
			parts[i] = Arrays.copyOfRange(array, (array.length * i) /numberOfparts, (array.length * (i + 1)) / numberOfparts);
		}
		return parts;
	}
	
	public static void generateThreads(Runnable[] parts) {
        Thread[] threads = new Thread[parts.length];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(parts[i]);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public IntRunnableArrayOperations() {
	}

}
