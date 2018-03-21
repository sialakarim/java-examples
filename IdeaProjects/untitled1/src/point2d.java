public class point2d {
    double x,y;
    public point2d()
    {
        x=0;y=0;
    }
    public point2d(double a,double b)
    {
        x=a;
        y=b;

    }
    public void traslation(double dx,double dy)
    {

        x+=dx;
        y+=dy;
    }
    public void affiche()
    {
        System.out.println("point dabscisse " +x +" et ordonnee" +y);
    }

}
