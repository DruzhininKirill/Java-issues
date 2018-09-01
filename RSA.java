import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;



public class RSA {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = 43;
        int q = 61;
        int n = p*q;
        int d = 593;
//        593
        int e = 0;
        while  ((e*d)%((p-1)*(q-1))!=1){
            e++;
        }
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("n = " + n);
        System.out.println("Enter your message(nums with whitespace): ");
        String num = in.nextLine();
        String mes[] = (num.split(" "));
        List<BigInteger> code = new ArrayList<>();
        for (String element : mes){
            BigInteger c1 = BigInteger.valueOf(Long.parseLong(element));
            BigInteger b2 = BigInteger.valueOf(n);
            c1 = c1.pow((e));
            c1 = c1.mod(b2);
            code.add(c1);
        }
        System.out.println("Coded: " + code);

        List<BigInteger> decode = new ArrayList<>();
        for (BigInteger element : code){
            BigInteger c1 = element;
            BigInteger b2 = BigInteger.valueOf(n);
            c1 = c1.pow((d));
            c1 = c1.mod(b2);
            decode.add(c1);
        }
        System.out.println("decoded: " + decode);


    }
}
