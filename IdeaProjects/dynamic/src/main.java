import java.math.BigInteger;
import  java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        while (sc.hasNext()) {
            List<BigInteger> l= new ArrayList<>();
            while (sc.hasNext() && ((n = sc.nextInt()) != -999999)) {
                l.add(BigInteger.valueOf(n));
            }
            BigInteger ans=l.get(0);
            for (int i=0;i<l.size();i++) {
                BigInteger s=l.get(i);
                ans=ans.max(s);
                for (int j=i+1;j<l.size();j++) {
                    s=s.multiply(l.get(j));
                    ans=ans.max(s);
                }
            }
            System.out.println(ans);
        }
    }
}
