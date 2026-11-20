package comday2;

public class TestArrays {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5};
		
//		for (int num : numbers) {
//			System.out.println(num);
//		}
		
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
//		
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col <  3; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
		
		int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int oddCount = 0, evenCount = 0;
		for (int row = 0; row < matrix2.length; row++) {
			for (int col = 0; col <  matrix2.length; col++) {
				if (row == col) {
					System.out.println(matrix2[row][col]);
				}
				if (matrix2[row][col] % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
			}
		}
		System.out.println(evenCount + " " + oddCount);
		
		

	}

}
