package com.JUnit_Testing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JUnitTestingApplicationTests {

	private  Calculator calculator = new Calculator();
	@Test
	void contextLoads() {
	}


	@Test
	void testSum(){
		//expected result
		int expectedResult = 27;
		//actual result
		int actualResult = calculator.doSum(12,7,8);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testProduct(){
		//expected result
		int expectedResult = 84;
		//actual result
		int actualResult = calculator.doProduct(12,7);
		assertThat(actualResult).isEqualTo(expectedResult);
	}


	@Test
	void testCompareNums(){
		//expected result
		Boolean expectedResult = true;
		//actual result
		Boolean actualResult = calculator.compareTwoNums(12,12);
		assertThat(actualResult).isTrue();
	}




}
