import java.util.Arrays;



/*
«аполн€ем массив
*/

    public class Solution20 {

        public static int[] array = new int[11];
        public static int valueStart = 10;
        public static int valueEnd = 13;

        public static void main(String[] args) {

            int n = array.length;
           // int odd = n / 2;
            //int nodd = n / 2 +1;

            if (n % 2 == 0) {
                Arrays.fill(array,  0 , (n / 2) , valueStart);
                Arrays.fill(array,  (n / 2) + 1 , array.length , valueEnd);
            }
            else {
                Arrays.fill(array,  0 , (n / 2) + 1 , valueStart);
                Arrays.fill(array, (n / 2) + 1 , array.length , valueEnd);
            }


            //напишите тут ваш код



            System.out.println(Arrays.toString(array));
        }
    }


