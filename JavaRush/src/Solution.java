import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyb = new  Scanner(System.in);
		int num1 = keyb.nextInt();                          
		int num2 = keyb.nextInt();                                        
		int num3 = keyb.nextInt();   
		String str1="", str2="", str3="";                                              
boolean eq=false;

		   if (num1==num2) {                 
		        str1=(num1+" ");
		        str2=(num2+" ");
		        eq=(num1==num2);  
		}
		      // System.out.println(num1 + " " + num2) ;
		      if (num2==num3) {
		               str2=(num2+" ");
		               str3=(num3+" ");  
		               eq=(num2==num3); 
		}                     
		      if (num3==num1) {                        
		                        str3=(num3+" ");
		                        str1=(num1+" ");   
		                        eq=(num3==num1);  
		}
		            //   else if  (str1!=""||str2!=""||str3!="")
		                        if (eq) System.out.println(str1+str2+str3); 
		                       
		                        keyb.close();

		    
		}


}


