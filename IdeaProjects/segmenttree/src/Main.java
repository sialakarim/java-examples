import java.*;
import java.util.Scanner;

public class Main {
        int tree[];
        int t[];
        String s;
        public Main(String s1)
        {
            s=s1;
        }
        void build(int a,int b, int node)
        {
                if (a>b) return ;
                if (a==b)
                {
                        tree[a]=s.charAt(a);
                        return ;
                }
                int mid=(a+b)/2 ;
                build(a,mid,node*2+1);
                build(mid+1,b,node*2+2);

                if (tree[node*2+2]==tree[node*2+1])
                        tree[node]=tree[node*2+1];
                else
                        tree[node]=-999999999;

        }
        int  querry(int node, int a, int b, int i, int j)
        {
        if (a>b || a>j|| b<i) return -999999999;
        if (a==i && b==j) {
                return tree[node];

        }
        else
        {
                int mid=(a+b)/2;
                int c1=querry(node*2+1,a,mid,i,j);
                int c2=querry(node*2+2,mid+1,b,i,j);
                if (c1==c2) return 1;
                else return 0;
        }
        }



        public static void main(String[] args)
        {
                Scanner S=new Scanner(System.in);

                int co=0;
                while (S.hasNext())
                {   co++;
                        String str;
                        str=S.next();
                    Main T =new Main(str) ;
                        int n;
                        n=S.nextInt();
                        T.build(0,T.s.length()-1,0);
                        for (int k=0;k<n;k++)
                        {       int i,j;
                                i=S.nextInt();j=S.nextInt();
                                System.out.println("Case "+co+":");
                                if (T.querry(0,0,T.s.length()-1,i,j)==1)
                                {
                                        System.out.println("YES");
                                }
                                else
                                        System.out.println("NO");
                        }

                }
        }
}
