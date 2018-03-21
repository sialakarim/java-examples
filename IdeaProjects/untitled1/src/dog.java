public class dog extends animals
{
int age;
int speed;
String race;
    public dog(int dogage,int spe,String ra)
    {
        age=dogage;
        race=ra;
        speed=spe;
    }
    public void bark()
    {
        System.out.println("Haab");
    }
    public void run(int feet)
    {
        int time=feet/speed;
        System.out.println("your dog has ran " +feet +"feet in " + time +"seconds");
    }
    public int getage()
    {
        return age;
    }
    public int getSpeed()
    {return speed;
    }
    public String getrace()
    {
        return race;
    }
    public static void main (String[] args){
    dog rex=new dog(5,12,"bulldog");
    rex.bark();
    rex.run(89);
    System.out.println(rex.getage());
    System.out.println(rex.getrace());

    }

}
