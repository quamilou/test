public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z ;
    }
/*
    public Vector() {
        this.x = a;
        this.y = b;
        this.z = c;
    }
*/
    public String toString() {
        return "( " + this.x + ", " + this.y + ", " + this.z + " )";
    }

    public double norm() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public Vector add(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public double dot(Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

}
