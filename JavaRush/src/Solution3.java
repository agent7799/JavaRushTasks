
public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Сумма чисел, не кратных 3
		*/
		               
		
		        //напишите тут ваш код     
		         int sum=0; 
		         int i=1;
		         while (i<=100) 
		         { 
		                i++;
		              if ((i%3)==0)
		                {                                
		                  continue;  
		                }   
                          
		                 sum=sum+i;
		         } 
		              System.out.println(sum);
		                                   
	}

}
