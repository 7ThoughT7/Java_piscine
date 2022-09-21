package ex04;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] unic = new int[65536];
        char[] mass = str.toCharArray();
        for (int i = 0; i < mass.length; i++)
            unic[mass[i]]++;
        char[] max_ch = new char[10];
        int[] max_count = new int[10];
        for (int it = 0; it < 10; it++) {
            for (int i = 0; i < 65536; i++) {
                char ch = ' ';
                int count = 0;
                if (unic[i] > count) {
                    max_ch[it] = (char) i;
                    max_count[it] = unic[i];
                    unic[i] = 0;
                }
                else if (unic[i] == count){
                    if ((char)i < max_ch[it]){
                        int tmp = max_ch[it];
                        max_ch[it] = (char) i;
                        max_count[it] = unic[i];
                        max_count[++it] = tmp;
                        unic[i] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(max_ch[i] + " - " + max_count[i]);
        }
    }
}
