import java.util.Scanner;

public class Solution14 {
  /*
”дал€ем одинаковые строки
*/
       public static String[] strings;

        public static void main(String[] args) {

            //напишите тут ваш код

            strings = new String[6];
            Scanner sc = new Scanner(System.in);

            for (int i = 0 ; i < 6 ; i++) {
                strings[i] = sc.nextLine();
            }

            for (int i = 0 ; i < strings.length - 1; i++) {
                if (strings[i].equals(strings[i+1])) {
                    strings[i] = null;
                    strings[i + 1] = null;
                }
            }

            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i] + ", ");
            }
        }
    }


