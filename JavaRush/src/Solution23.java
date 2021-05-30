import java.util.Arrays;

public class Solution23 {

/*
Есть ли кто?
*/

        public static int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        public static int element = 5;


        public static void main(String[] args) {
            //напишите тут ваш код

            int[] arraysorted = Arrays.copyOf(array, array.length);
            Arrays.sort(arraysorted);
            int index = Arrays.binarySearch(arraysorted, element);

            boolean re = (index >= 0);
            System.out.println(re);
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(arraysorted));
        }
    }
