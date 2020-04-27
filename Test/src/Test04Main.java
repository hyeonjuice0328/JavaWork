import java.util.Scanner;

public class Test04Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 0;
		int max = 0; 
		int num;

		while (true) {
			num = sc.nextInt();
			max = max > num? max : num;
			min = min < num? min : num;
		if(num == 0)	
			break;
		
		}
		System.out.println(max +"," + min);
		sc.close();
		}

	}

