
import java.util.Scanner;

/* 
������ ���������� ���� ��� ���������� �����?
*/

public class Solution9 {
    public static void main(String[] args) {                  
        double glass = 0.5;              
        int result; 
 
        //�������� ��� ��� ���  
 
        Scanner sc = new Scanner(System.in);
        boolean optimist = sc.nextBoolean();
        
        if  (optimist) { 
            result =  (int) Math.ceil(glass);
         }  
        else result = (int) Math.floor(glass);

    System.out.println(result);    
                                                                           
 
    }
}
            


