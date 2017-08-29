import java.util.Arrays;

public class ShellSort {
    
    public ShellSort() {
    	
    }      
        
    public static int[] runnableShellSort(int[] array) {
    	try {
    		if (array == null) 
                throw new IllegalArgumentException();
    	}
             catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
    	
    	ShellSortByParts[] parts = divideArray(array, 4);
    	IntRunnableArrayOperations.generateThreads(parts);
    	
    	if (parts.length == 1) {
    		return parts[0].getPartOfArray();
    	
    	}
    	
    	if (parts.length == 2) {
    		return merge(parts[0].getPartOfArray(), parts[1].getPartOfArray());
    		
    	}
    	
    	if (parts.length > 2) {
    		int[] temp = null;
    		
    		for (int i = 0; i < parts.length; i++) {
				temp = merge(temp, parts[i].getPartOfArray());
			}
    		array = temp;
    	}
    	return array;
    	
    }
    
    private static int[] merge(int[] part1, int[] part2) {
    	try {
    		if (part1 == null && part2 == null) {
        		throw new IllegalArgumentException("NULL PART");
        	}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
    	if (part1 == null && part2 != null)
    		return part2;
    	
    	if (part1 != null && part2 == null)
    		return part1;
    		
    	int merged[] = new int[part1.length + part2.length];
    	
    	int i = 0, j = 0;
    
    	for (int k = 0; k < merged.length; k++) {
    		if (i == part1.length) {
    			merged[k] = part2[j];
    			j++;
    			continue;
    		}
    		if (j == part2.length) {
    			merged[k] = part1[i];
    			i++;
    			continue;
    		}
    		if (part1[i] < part2[j]) {
    			merged[k] = part1[i];
    			i++;
    		} else {
    			merged[k] = part2[j];
    			j++;
    		}
		}

		return merged;
    }
    
    private static ShellSortByParts[] divideArray(int[] array, int numberOfparts) {
    	
    	ShellSortByParts[] parts = new ShellSortByParts[numberOfparts];
    	int[][] arrayParts = IntRunnableArrayOperations.divideRunnableArray(array, numberOfparts);

        for (int i = 0; i < parts.length; i++) {
            parts[i] = new ShellSortByParts(arrayParts[i]);
        }
        return parts;
    }

    private static class ShellSortByParts implements Runnable {
        private int[] partOfArray;

        public ShellSortByParts(int[] partOfArray) {
            this.partOfArray = partOfArray;
        }

        public ShellSortByParts() {
        }

        private void shellSort(int[] array) {
      
            for (int step = array.length / 2; step > 0; step /= 2) {

                int j;
                for (int i = step; i < array.length; i++) {
                    int value = array[i];

                    for (j = i - step; j >= 0 && array[j] > value; j -= step) {
                        array[step + j] = array[j];
                    }
                    array[j + step] = value;
                }
            }
        }

        @Override
        public void run() {
        	shellSort(partOfArray);
        }

        public int[] getPartOfArray() {
            return partOfArray;
        }
    }
}
