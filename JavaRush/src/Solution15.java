import java.util.Scanner;


public class Solution15 {


    /*
    ”дал€ем одинаковые строки
    */

        public static String[] strings;

        public static void main(String[] args) {

            //напишите тут ваш код

            strings = new String[6];
            boolean[] check = new boolean[strings.length];

            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < 6; i++) {
                strings[i] = sc.nextLine();
            }
            for (int i = 0; i < strings.length; i++) {
                String dummy = strings[i];
                for (int j = (i + 1); j < strings.length; j++) {

                    if (strings[i].equals(strings[j])) {
                        check[i] = true;
                        check[j] = true;
                    }
                }
            }
            for (int k = 0; k < strings.length; k++) {
                if (check[k]) {
                    strings[k] = null;
                }
            }
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i] + ", ");
            }
        }
    }





