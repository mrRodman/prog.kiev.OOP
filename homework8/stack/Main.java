package stack;

public class Main {
    public static void main(String[] args) {
        SomeStack stack = new SomeStack(4);
        stack.addToBlackList(Double.class);
        stack.addToBlackList(String.class);

        stack.addElementsToStack(1);
        stack.addElementsToStack(1.1);
        stack.addElementsToStack("asd");
        stack.addElementsToStack(2);
        stack.addElementsToStack(3);

        stack.remove();

        System.out.println(stack.get());
    }
}
