package com.aerobal.comms.server

import org.junit.Test
import java.sql.Timestamp
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._

class ServerCommPutsTests extends AssertionsForJUnit {
	private val SESSION_ID_STRING = "sessionId";
	private val SESSION_NAME_STRING = "name";
	private val SESSION_DESCRIPTION_STRING = "description";
	private val EXPERIMENT_ID_STRING = "experimentId";
	private val EXPERIMENT_NAME_STRING = "name";
	
	@Test def testMakeUpdateSessionPutsMap() {
		val func: (Int,Option[String],Option[String]) => Map[String,String] = ServerCommPuts.makeUpdateSessionPutMap;
		val sessionId = 2454334;
		val name = "My Session";
		val description = "My description string is this.";
		val map = func(sessionId, Some(name), Some(description));
		assertEquals(3, map.size);
		assertEquals(sessionId.toString, map(SESSION_ID_STRING));
		assertEquals(name, map(SESSION_NAME_STRING));
		assertEquals(description, map(SESSION_DESCRIPTION_STRING));
		val map2 = func(sessionId, None, Some(description));
		assertEquals(2, map2.size);
		val map3 = func(sessionId, Some(name), None);
		assertEquals(2, map3.size);
		val map4 = func(sessionId, None, None);
		assertEquals(1, map4.size);
	}
	@Test def testMakeUpdateExperimentsPutsMap() {
		val func: (Int,Option[String]) => Map[String,String] = ServerCommPuts.makeUpdateExperimentPutMap;
		val experimentId = 97865;
		val name = "My Session";
		val map = func(experimentId, Some(name));
		assertEquals(2, map.size);
		assertEquals(experimentId.toString, map(EXPERIMENT_ID_STRING));
		assertEquals(name, map(EXPERIMENT_NAME_STRING));
		val map2 = func(experimentId, None);
		assertEquals(1, map2.size);

	}
}