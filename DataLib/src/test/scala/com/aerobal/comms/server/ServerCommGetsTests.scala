package com.aerobal.comms.server

import java.security.InvalidParameterException

import scala.collection.mutable.HashMap

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class ServerCommGetsTest extends AssertionsForJUnit {
  	private val USER_ID_STRING = "userId";
	private val SESSION_ID_STRING = "sessionId";
	private val EXPERIMENT_ID_STRING = "experimentId";
	private val RUN_ID_STRING = "runId";
	private val MEASUREMENT_ID_STRING = "measurementId";
	private val ID_STRING = "id";
  
	@Test def testMakeGetURL() {
		val route = "http://www.test.com/testroute";
		val params = HashMap[String,String]();
		params("id") = "45";
		params("name") = "testing";
		params("other") = "234.5";
		val url = ServerCommGets.makeGetURL(route, params.toMap[String,String]);
		val split = url.toString().split("[?]");
		assertEquals(route, split(0));
		val paramSplit = split(1).split("&");
		assertEquals(3,paramSplit.size);
		assertTrue(paramSplit.contains("id=45"));
		assertTrue(paramSplit.contains("name=testing"));
		assertTrue(paramSplit.contains("other=234.5"));
	}
	@Test def testMakeUserGetMap() {
	  	val id = 3453434;
	  	val key = ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeUserGetMap;
		val map = func(id);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(id.toString, map(key));
	}
	@Test def testMakeUsersGetMap() {
		val id = 5687685;
		val func: Map[String,String] = ServerCommGets.makeUsersGetMap;
		val map = func;
		assertTrue(map.isEmpty);
	}
	@Test def testMakeSessionGetMap() {
		val id = 45645;
		val key = ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeSessionGetMap;
		val map = func(id);
		assertTrue(map.contains(key));
		assertEquals(id.toString, map(key));
		testNegatives(func);
	}
	@Test def testMakeSessionsGetMap() {
	  		val id = 2357876;
		val key = USER_ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeSessionsGetMap;
		val map = func(id);
		assertTrue(map.contains(key));
		assertEquals(id.toString, map(key));
		testNegatives(func);
	}
	@Test def testMakeExperimentGetMap() {
		val id =  9724;
		val key = ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeExperimentGetMap;
		val map = func(id);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(1,map.size);
		assertEquals(id.toString,map(key));
	}
	@Test def testMakeExperimentsGetMap() {
		val sessionId =  343545756;
		val key = SESSION_ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeExperimentsGetMap;
		val map = func(sessionId);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(1,map.size);
		assertEquals(sessionId.toString,map(key));
	}
	@Test def testMakeExperimentStatsGetMap() {
		val experimentId = 45;
		val key = EXPERIMENT_ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeExperimentStatsGetMap;
		val map = func(experimentId);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(1,map.size);
		assertEquals(experimentId.toString,map(key));
	}
	@Test def testMakeRunGetMap() {
		val id = 34564;
		val key = ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeRunGetMap;
		val map = func(id);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(id.toString, map(key));

	}
	
	@Test def testMakeRunsGetMap() {
		val id = 3453434;
		val key = EXPERIMENT_ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeRunsGetMap;
		val map = func(id);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(id.toString, map(key));
	}
	@Test def testMakeRunStatsGetMap() {
	 		val id = 2543534;
	 		val key = RUN_ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeRunStatsGetMap;
		val map = func(id);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(id.toString, map(key));
	}
	
	@Test def testMakeMeasurementGetMap() {
		val id = 867;
		val key = ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeMeasurementGetMap;
		val map = func(id);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(id.toString, map(key));
	}
	@Test def testMakeMeasurementsGetMap() {
	  		val id = 78734654;
		val key = RUN_ID_STRING;
		val func: Int => Map[String,String] = ServerCommGets.makeMeasurementsGetMap;
		val map = func(id);
		testNegatives(func);
		assertTrue(map.contains(key));
		assertEquals(id.toString, map(key));
	}
	def testNegatives[T](func:Int => T) {
		func(0)
		func(3453)
		try {
			func(-123)
			fail("Expected InvalidParameterException");
		} catch {
		case e: InvalidParameterException => {};
		}


	}
}