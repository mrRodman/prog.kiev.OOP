package stack;

public class SomeStack {
	private Object[] stack;
	private int stackSize;
	private Class[] blackList;
	
	public SomeStack(int stackSize) {
		super();
		this.stackSize = stackSize;
		this.stack = new Object[stackSize];
		this.blackList = new Class[stackSize * 2];
	}

	public SomeStack() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addElementsToStack(Object obj) {
        for (int i = 0; i < blackList.length; i++) {
            if (obj.getClass() == blackList[i]) {
                System.err.println(obj.getClass().getSimpleName() + " class is forbidden");
                return;
            }
        }

        for (int i = 0; i < stack.length; i++) {
			if (stack[i] == null) {
				stack[i] = obj;
				return;
			}
		}
		System.err.println("Stack is full!");
	}
	
	public void remove() {
		for (int i = stack.length - 1; i >= 0; i--) {
			if (stack[i] != null) {
				stack[i] = null;
				return;
			}
		}
		System.err.println("Stack is empty!");
	}

	public Object get() {
        for (int i = stack.length - 1; i > 0; i--) {
            if (stack[i] != null) {
                Object temp = stack[i];
                stack[i] = null;
                return temp;
            }
        }
        System.err.println("Stack is empty");
        return null;
    }

    public void addToBlackList (Class objClass) {
        for (int i = 0; i < blackList.length; i++) {
            if (blackList[i] == null) {
                blackList[i] = objClass;
                return;
            }
        }
    }
}
