import java.util.Scanner;

public class Solution11 {



/*
ћинимальное из N чисел
*/


        public static int[] array;

        public static void main(String[] args) throws Exception {
            //напишите тут ваш код



            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            array = new int[n];

            for (int i = 0 ; i < array.length ; i++) {
                array[i] = sc.nextInt();
            }

            int min = array[0];

            for (int i = 0 ; i < array.length ; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }

            System.out.println(min);
        }
}

