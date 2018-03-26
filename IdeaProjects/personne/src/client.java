public class client extends personne {
    private  int money;
    public client(int id,int age,String name, String location, int money)
    {

        super(id,age,name,location);
        this.money=money;
    }
    public void get_money(int sum)
    {
        if (money>=sum)
        {
            money-=sum;
            System.out.println("operation effectuee, votre solde est " +money);
        }
        else
            System.out.println("Erreur, vous n'avez pas assez d'argent !");

    }
    public void verse_money(int sum)
    {

        money+=sum;
        System.out.println("operation effectuee, votre solde est " +money);
    }
    public void transfer_money(client c1, client c2, int sum)
    {
        if (c1.money>=sum) {
            c1.money -= sum;
            c2.money += sum;
            System.out.println("operation effectuee!!");

        }
        else
            System.out.println("Erreur, vous n'avez pas assez d'argent !");

    }

    public void main(String[] args)
    {

    }
}
