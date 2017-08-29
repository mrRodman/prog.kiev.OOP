import java.util.Arrays;

public class ArraySum {

    private int[] array;

    public ArraySum(int[] array) {
        this.array = array;
    }

    public ArraySum() {
    }

    public int sum() {
        if (array == null) {
            System.out.println("NULL");
            return -1;
        }
        ArrayPartSum[] parts = makeArrayParts(this.array, 4);
        IntRunnableArrayOperations.generateThreads(parts);

        int sum = 0;
        for (int i = 0; i < parts.length; i++) {
          sum += parts[i].getSum();
        }
        return sum;
    }

    private ArrayPartSum[] makeArrayParts(int[] array, int numberOfParts) {
        ArrayPartSum[] parts = new ArrayPartSum[numberOfParts];
        int[][] arrayParts = IntRunnableArrayOperations.divideRunnableArray(array, numberOfParts);

        for (int i = 0; i < parts.length; i++) {
            parts[i] = new ArrayPartSum(arrayParts[i]);
        }
        return parts;
    }
    

    private class ArrayPartSum implements Runnable {
        private int[] arrayPart;
        private int sum;

        public ArrayPartSum(int[] arrayPart) {
            this.arrayPart = arrayPart;
        }

        public ArrayPartSum() {
        }

        private int sum (int[] arrayPart) {
            int s = 0;
            for (int i = 0; i < arrayPart.length; i++) {
                s+= arrayPart[i];
            }
            return s;
        }

        @Override
        public void run() {
            sum = sum(arrayPart);
        }

        public int getSum() {
            return sum;
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
