public class point2d {

    double x, y;

    public point2d() {
        this(0, 0);
    }

    public point2d(double a, double b) {
        this.x = a;
        this.y = b;
    }

    public void traslation(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void affiche() {
        System.out.println("point dabscisse " + x + " et ordonnee" + y);
    }
    
    public String toString() {
        return "point d'abscisse " + x + " et ordonnee" + y;
    }
}
