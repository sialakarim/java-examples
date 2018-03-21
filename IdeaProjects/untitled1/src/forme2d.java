public class forme2d {
    point2d centre;
    public forme2d(point2d p)
    {
        centre=p;
    }
    public void translation (double dx,double dy)
    {
        centre.traslation(dx,dy);
    }
    public void affiche ()
    {
        centre.affiche();
    }
}
