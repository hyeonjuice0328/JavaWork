import java.util.Scanner;

public class Test01Main {

	public static void main(String[] args) {
		double num1, num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("실수를 입력하세요.");
		num1 = sc.nextDouble();
		num2 = sc.nextDouble();
		
		Double num3 = num1 + num2;
		Double num4 = num1 * num2;
		System.out.println(num3);
		System.out.println(num4);
		
		
		sc.close();
	}

}
