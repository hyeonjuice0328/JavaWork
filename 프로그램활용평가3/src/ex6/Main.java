package ex6;

public class Main {
	
	public static void main(String[] args) {
		//타입[] 이름 = new 타입[] {a, b, c, ...};
		int [] arr = new int[] {10, 20, 30};
		for(int i = 0; i <= arr.length; i++) {
		System.out.println(arr[i]);
// 배열 arr에 넣을 수 있는 수가 초과되어 ArrayIndexOutofBoundsException이 발생
		}
	}

}
