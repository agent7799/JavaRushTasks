import java.util.Arrays;


public class Solution22 {
/*
���� �� ���?
*/


    public static int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static int element = 5;

    public static void main(String[] args) {
        //�������� ��� ��� ���


        int index = Arrays.binarySearch(array, element);

        if (index >=0) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
}
    }
}