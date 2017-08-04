package vector3d;

public class Main {
    public static void main(String[] args) {
        Vector3d vector1 = new Vector3d(2, 3, 3);
        Vector3d vector2 = new Vector3d(5, 6, 7);

        System.out.println(Vector3d.vectorSum(vector1, vector2));
        System.out.println(Vector3d.scalarProduct(vector1, vector2));
        System.out.println();
        System.out.println(Vector3d.crossProduct(vector1, vector2));
    }
}
