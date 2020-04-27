package practice.game369;

public class Game369 {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			int x = i / 10, b = i % 10;
			if ((x == 3 || x == 6 || x == 9) && (b == 3 || b == 6 || b == 9)) {

				System.out.print(" *  ");
			} else if ((x == 3 || x == 6 || x == 9) || (b == 3 || b == 6 || b == 9)) {
				System.out.print(" *  ");
			} else {
				System.out.print(" " + i + " ");
			}

			if (i % 10 == 0) {
				System.out.println();
			}
		}
	}
}
