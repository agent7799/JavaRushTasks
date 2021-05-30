import java.util.Arrays;



public class Solution21 {
/*
Делим массив
*/



        public static int[][] result = new int[2][];
        public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        public static void main(String[] args) {
            int n = array.length;
            if (n % 2 == 0) {
                result[0] = Arrays.copyOfRange(array , 0 , n/2);
                result[1] = Arrays.copyOfRange((array), n/2, array.length);
            }
            else {
                result[0] = Arrays.copyOfRange(array , 0 , n/2 +1);
                result[1] = Arrays.copyOfRange((array), n/2 + 1, array.length);
            }
            //напишите тут ваш код



            System.out.println(Arrays.deepToString(result));


        }
    }