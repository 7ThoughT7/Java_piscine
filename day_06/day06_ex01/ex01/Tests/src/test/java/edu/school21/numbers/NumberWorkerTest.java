package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

	@ParameterizedTest
	@ValueSource(ints = {2, 3, 5, 13, 17, 113})
	public void isPrimeForPrimes(int prime){
		new NumberWorker();
		Assertions.assertTrue(NumberWorker.isPrime(prime));
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 6, 10, 120, 400})
	public void isPrimeForNotPrimes(int prime){
		new NumberWorker();
		Assertions.assertFalse(NumberWorker.isPrime(prime));
	}

	@ParameterizedTest
	@ValueSource(ints = {-1999, -100, -1, 0 , 1})
	public void isPrimeForIncorrectNumbers(int prime){
		new NumberWorker();
		Assertions.assertThrows(RuntimeException.class, () -> NumberWorker.isPrime(prime));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/resources/data.csv", delimiter = ',')
	public void digitsSum(int num, int sum){
		new NumberWorker();
		Assertions.assertEquals(sum, NumberWorker.digitsSum(num));
	}

}
