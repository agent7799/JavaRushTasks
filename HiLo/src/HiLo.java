import java.util.Scanner;


public class HiLo {
	
	public static void main(String[] args) {
		
		String playAgain = "";
		System.out.println("���������� ������� ����� �� 1 �� 100:");
		Scanner scan = new Scanner(System.in);
		
			do {
				int theNumber = (int)(Math.random()*100+1);		//���������� ��������� �����
				int guess=0; 	// System.out.println(theNumber);
				int numberOfTries=0;
				while (guess!= theNumber) {
					System.out.println("������� ����� �� 1 �� 100:");
					//guess = scan.nextInt();
					guess=(int)(Math.random()*100+1);		// ��������� ����� ��������� ���������
					//System.out.println("�� ����� " + guess + ".");
					System.out.println("����� ��� " + guess + " ?\r"); 
					numberOfTries++; // edtkbxbdftn 
					if (guess<theNumber) 
						System.out.println(guess +  " ������. ���������� ��� ���.");
					else if (guess>theNumber)
						System.out.println(guess + " ������. ���������� ��� ���.");
					else System.out.println(guess + " ���������, �� �������!\n " + "����� " + numberOfTries + " �������!"); //����� ����� ����������
					} 
			System.out.println("������ ������� ��� ���? y/n?");
			playAgain=scan.next();
		} while (playAgain.equalsIgnoreCase("y"));
		System.out.println("������� �� ����! ����������!");
		scan.close();
	}
}
