public class cercle extends forme2d {
    double rayon;
    public cercle( point2d p,double r)
    {
        super(p);
        rayon=r;
    }
    public double perimetre()
    {
        return 2*3.14*rayon;
    }
    public double surface()
    {
        return 3.14*3.14*rayon;
    }
}
