


/*
Треугольный массив
*/

    public class Solution17 {

        public static int[][] result = new int[10][];

        public static void main(String[] args) {


            //напишите тут ваш код

            for (int i = 0 ; i < result.length ; i++) {
               result[i] = new int[i+1];
            }

            for (int i = 0 ; i < result.length ; i++) {                 //  номер строки
                for (int j = 0 ; j <result[i].length ; j++) {              // номер столбца
                    result[i][j] = i +j;
                }
            }

            // вывод

            for (int i = 0 ; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }






        }
    }




