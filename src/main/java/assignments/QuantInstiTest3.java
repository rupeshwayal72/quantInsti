package assignments;


public class QuantInstiTest3 {

	public static void main(String[] args){

		System.out.println("The sum of the multiples of 3 and 5 is: " + getSum());

		}

		private static int getSum() {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
		    if (i % 3 == 0 || i % 5 == 0) {
		        sum += i;
		    }
		}
		return sum;
		}}