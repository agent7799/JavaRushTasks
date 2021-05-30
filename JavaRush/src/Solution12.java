

   import java.util.Scanner;

/*
Reverse
*/
   public class Solution12 {
        public static void main(String[] args) {
            //напишите тут ваш код
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();

            if (N  >  0)  {

                int[] array = new int[N];

                for (int i = 0 ; i < N ; i++) {
                    array[i] = sc.nextInt();
                }

                if ((N % 2) != 0) {
                    for (int i = 0 ; i < N ; i++) {
                        System.out.println(array[i]);
                    }
                }
                else {
                    for (int i = 0 ; i < N; i++) {
                        System.out.println(array[N - i - 1]);
                    }
                }
            }
        }
    }