import java.util.Arrays;

public class Solution16 {

    /*
“аблица умножени€
*/

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {

        //напишите тут ваш код

    MULTIPLICATION_TABLE = new int[10][10];

        for (int i = 0 ; i < MULTIPLICATION_TABLE[0].length; i++) {
            for (int j = 0 ; j < MULTIPLICATION_TABLE[1].length; j++ ) {
                MULTIPLICATION_TABLE[i][j] = (i+1) * (j+1) ;
            }
        }

        for (int i = 0 ; i < MULTIPLICATION_TABLE[0].length; i++) {
            for (int j = 0; j < MULTIPLICATION_TABLE[1].length; j++) {
                System.out.print(MULTIPLICATION_TABLE[i][j] + " ");
            }
            System.out.println();
        }


    }
}