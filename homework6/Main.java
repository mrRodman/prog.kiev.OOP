import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Thread[] threads = new Thread[100];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Factorial());
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		try {
			for (int i = 0; i < threads.length; i++) {
				threads[i].join();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		int[] ints = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

		long startTime = System.nanoTime();
		ArraySum arrSum = new ArraySum(ints);
		System.out.println(arrSum.sum());

		long endTime = System.nanoTime();

		System.out.print("Thread time ");
		System.out.println(endTime - startTime);

		long startTime2 = System.nanoTime();
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		System.out.println(sum);
		long endTime2 = System.nanoTime();
		System.out.print("No thread time ");
		System.out.println(endTime2 - startTime2);
		
		int[] arrayS = new int[] {3, 5, 1, 6, 10 , 4, 0, 2, 10, 4, 15, 3};
		
		System.out.println(Arrays.toString(ShellSort.runnableShellSort(arrayS)));
		
	}
}
