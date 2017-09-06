package students;

public interface Sorting {
	public static final int NOT_NULL = 11;
	
	public void sortBy(int i);
	
	public static int nullCheck(Object o1, Object o2) {
		if (o1 != null && o2 == null)
			return 1;
		
		if (o1 == null && o2 != null)
			return -1;
		
		if(o1 == null && o2 == null)
			return 0;
		
		return NOT_NULL;
	}
}