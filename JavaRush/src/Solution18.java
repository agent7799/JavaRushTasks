import java.util.Scanner;

public class Solution18 {



/*
������� ���������� ������
*/

    public static int[][] multiArray;

        public static void main(String[] args) {
            //�������� ��� ��� ���

            Scanner sc = new Scanner(System.in);
            int rows = sc.nextInt();
            multiArray = new int[rows][];

            for (int i = 0 ; i < multiArray.length ; i++)  {
                int col = sc.nextInt();
                multiArray[i] = new int[col];
            }





        }

    }









