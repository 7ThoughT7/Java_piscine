package edu.school21.numbers;

public class NumberWorker{

	public static boolean isPrime(int number)  {
		int count = 2;
		boolean boo = true;
		if (number > 1){
			while (count <= number / count){
				if (number % count == 0) {
					boo = false;
					break;
				}
				else
					count++;
			}
			if (!boo)
				return false;
		}
		else {
			throw new IllegalNumberException("IllegalNumberException");
		}
		return true;
	}

	public static int digitsSum(int number){
		int res = 0;
		while (number > 0){
			res += number % 10;
			number /= 10;
		}
		return res;
	}
}

