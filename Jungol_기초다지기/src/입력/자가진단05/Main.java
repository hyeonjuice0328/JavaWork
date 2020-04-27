package 입력.자가진단05;

public class Main {

	public static void main(String[] args) {
		double yd;
		double in;

		yd = 2.1;
		in = 10.5;

		System.out.printf("%4.1fyd = %5.1fcm%n", yd, (yd * 91.44));
		System.out.printf("%4.1fin = %5.1fcm", in, (in * 2.54));
	}

}
