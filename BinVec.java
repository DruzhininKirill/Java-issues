import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BinVec {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int num = in.nextInt();
        int[] a = new int[num];
        int i = 0;

        for (int element : a) {
            System.out.print("Введите " + (i + 1) + "-й элемент массива: ");
            a[i] = in.nextInt();
            i++;
        }
        System.out.print("Введите число: ");
        int check = in.nextInt();

        System.out.println(Arrays.toString(a));
        int flag = 0;
        int v = 0;
        while (v <= Math.pow(2,num)) {
            String comp = (Integer.toString(v, 2));
            while (comp.length() < num) {
                comp = "0" + comp;
            }
//            System.out.println("bnary " + comp);
            char arr[] = comp.toCharArray();

            int qwe = 0;
            int sum = 0;
            while (qwe < num) {
                char x = arr[qwe];
                int y = x - '0';
                sum = sum + a[qwe] * y;
                qwe++;
            }
//            System.out.println(" sum " +sum);
            if (sum != check) {
                v += 1;
            }
            else{
                flag = 1;
                System.out.println("ans = " + comp);
                break;
            }
        }
        if (flag == 0){
            System.out.println("Невозможно");
        }



    }
}
