import java.util.Scanner;

public class Test02Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s1 = sc.nextLine();
		int i1 = sc.nextInt(); 
		
		for (int i = 0; i < i1 ; i++) {
			
			System.out.println(s1);
		}
		
		sc.close();
	}

}
