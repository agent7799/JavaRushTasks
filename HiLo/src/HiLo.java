import java.util.Scanner;


public class HiLo {
	
	public static void main(String[] args) {
		
		String playAgain = "";
		System.out.println("Попробуйте угадать число от 1 до 100:");
		Scanner scan = new Scanner(System.in);
		
			do {
				int theNumber = (int)(Math.random()*100+1);		//генерируем случайное число
				int guess=0; 	// System.out.println(theNumber);
				int numberOfTries=0;
				while (guess!= theNumber) {
					System.out.println("Введите число от 1 до 100:");
					//guess = scan.nextInt();
					guess=(int)(Math.random()*100+1);		// рандомное число подбирает компьютер
					//System.out.println("Вы ввели " + guess + ".");
					System.out.println("Может это " + guess + " ?\r"); 
					numberOfTries++; // edtkbxbdftn 
					if (guess<theNumber) 
						System.out.println(guess +  " меньше. Попробуйте еще раз.");
					else if (guess>theNumber)
						System.out.println(guess + " больше. Попробуйте еще раз.");
					else System.out.println(guess + " правильно, Вы угадали!\n " + "Всего " + numberOfTries + " попыток!"); //Конец цикла угадывания
					} 
			System.out.println("Хотите сыграть еще раз? y/n?");
			playAgain=scan.next();
		} while (playAgain.equalsIgnoreCase("y"));
		System.out.println("Спасибо за игру! Досвидания!");
		scan.close();
	}
}
