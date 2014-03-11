package com.aerobal.data.processing;

import org.scalatest.junit.AssertionsForJUnit;
import org.junit.Assert._;
import org.junit.Test;
import org.junit.Before;
import scala.collection.mutable.ListBuffer;
import com.aerobal.data.processing.exceptions.EmptyListException;
import java.security.InvalidParameterException;
import org.junit.After;

class DataProcessingTest extends AssertionsForJUnit {
	val list: List[Double] = List( 4.5,2.3,-1.2,12,-13.4,22, 17.98433, -45.34234);
	val negativeList: List[Double] = List(-12.4, -54.6, -34.5, -34.87676, -123.45, -3);
	val positiveList: List[Double] = List(34.2, 7, 56.7655, 12.546757567, 7.8456456, 23.54364565, 77.345334);
	val zeroList: List[Double] = List( 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
	val singleValueList: List[Double] = List(7);
	val emptyList = List[Double]();


	@Test def testMax {
		val func:List[Double] => Double = DataProcessing.max;

		assertEquals(22.0, func(list),0.00001);	
		assertEquals(-3, func(negativeList),0.00001);
		assertEquals(77.345334, func(positiveList),0.00001);
		assertEquals(0, func(zeroList),0.00001);
		assertEquals(7, func(singleValueList),0.00001);
		testWithEmptyList(func)
		testWithNull(func)

	}
	@Test def testMin {
		val func:List[Double] => Double = DataProcessing.min;

		assertEquals(-45.34234, func(list),0.00001);	
		assertEquals(-123.45, func(negativeList),0.00001);
		assertEquals(7, func(positiveList),0.00001);
		assertEquals(0, func(zeroList),0.00001);
		assertEquals(7, func(singleValueList),0.00001);
		testWithEmptyList(func)
		testWithNull(func)
	}
	@Test def testMean {
		val func:List[Double] => Double = DataProcessing.mean;

		assertEquals(-0.14475, func(list),0.00001);	
		assertEquals(-43.80446, func(negativeList),0.00001);
		assertEquals(31.32098, func(positiveList),0.00001);
		assertEquals(0, func(zeroList),0.00001);
		assertEquals(7, func(singleValueList),0.00001);
		testWithEmptyList(func)
		testWithNull(func)
	}
	@Test def testSum {
		val func:List[Double] => Double = DataProcessing.sum;

		assertEquals(-1.158, func(list),0.00001);	
		assertEquals(-262.82676, func(negativeList),0.00001);
		assertEquals(219.2468828, func(positiveList),0.00001);
		assertEquals(0, func(zeroList),0.00001);
		assertEquals(7, func(singleValueList),0.00001);
		testWithEmptyList(func)
		testWithNull(func)
	}
	@Test def testMedian {
		val func:List[Double] => Double = DataProcessing.median;

		assertEquals(3.4, func(list),0.00001);	
		assertEquals(-34.68837, func(negativeList),0.00001);
		assertEquals(23.54364565, func(positiveList),0.00001);
		assertEquals(0, func(zeroList),0.00001);
		assertEquals(7, func(singleValueList),0.00001);
		testWithEmptyList(func)
		testWithNull(func)
	}
	@Test def testStandardDeviation {
		val func:List[Double] => Double = DataProcessing.standardDeviation;

		assertEquals(20.04288, func(list),0.00001);	
		assertEquals(39.32234, func(negativeList),0.00001);
		assertEquals(24.8697, func(positiveList),0.00001);
		assertEquals(0x	, func(zeroList),0.00001);
		assertEquals(0, func(singleValueList),0.00001);
		testWithEmptyList(func)
		testWithNull(func)
	}



	/////////////////////////////////////////////
	private def testWithNull(func:List[Double] => Double) {


		try {
			func(null);
			fail("No null exception thrown.");
		}
		catch {
		case e: InvalidParameterException => {};
		}
	}
	private def testWithEmptyList(func:List[Double] => Double) {
		try {
			func(emptyList);
			fail("No empty list exception thrown.");
		}
		catch {
		case e: EmptyListException => {};
		}
	}

}