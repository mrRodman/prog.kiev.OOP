package vector3d;

public class Vector3d {
    private double x;
    private double y;
    private double z;

    public Vector3d() {
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public static Vector3d vectorSum(Vector3d vector1, Vector3d vector2) {
        double x = vector1.getX() + vector2.getX();
        double y = vector1.getY() + vector2.getY();
        double z = vector1.getZ() + vector2.getZ();

        return new Vector3d(x, y, z);
    }

    public static double scalarProduct(Vector3d vector1, Vector3d vector2) {
        return vector1.getX() * vector2.getX()
                + vector1.getY() * vector2.getY()
                + vector1.getZ() * vector2.getZ();
    }

    public static Vector3d crossProduct(Vector3d vector1, Vector3d vector2) {
        double x = vector1.getY() * vector2.getZ() - vector1.getZ() * vector2.getY();
        double y = - vector1.getX() * vector2.getZ() + vector1.getZ() * vector2.getX();
        double z = vector1.getX() * vector2.getY() - vector1.getY() * vector2.getX();

        return new Vector3d(x, y, z);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector3d:\n" +
                "x = " + x + '\n' +
                "y = " + y + '\n' +
                "z = " + z +
                '\n';
    }
}
