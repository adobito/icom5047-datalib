package com.aerobal.comms.server

import java.security.InvalidParameterException
import scala.collection.mutable.HashMap
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit
import com.google.api.client.http.HttpContent
import java.sql.Timestamp

class ServerCommPostsTest extends AssertionsForJUnit {
	private val USER_USERNAME_STRING = "username";
	private val USER_NAME_STRING = "name";
	private val USER_EMAIL_STRING = "email";
	private val USER_PASSWORD_STRING = "password";
	private val USER_ID_STRING = "userId";
	private val SESSION_ID_STRING = "sessionId";
	private val SESSION_NAME_STRING = "name";
	private val SESSION_DESCRIPTION_STRING = "description";
	private val EXPERIMENT_ID_STRING = "experimentId";
	private val EXPERIMENT_NAME_STRING = "name";
	private val EXPERIMENT_DESCRIPTION_STRING = "description";
	private val EXPERIMENT_MEASUREMENT_AMOUNT_STRING = "measurementAmount";
	private val EXPERIMENT_FREQUENCY_STRING = "frequency";
	private val RUN_ID_STRING = "runId";
	private val MEASUREMENT_ID_STRING = "measurementId";
	private val MEASUREMENT_TYPE_STRING = "type";
	private val MEASUREMENT_VALUE_STRING = "value";
	private val TIMESTAMP_STRING = "timestamp";

	@Test def testMakeNewUserPostContent() {
		val func: (String,String,String,String) => Map[String,String] = ServerCommPosts.makeNewUserPostMap;
		val username = "testname13432";
		val name = "John Doe";
		val email = "email@amd.er";
		val password = "2gfh546y";
		val map = func(username, name, email, password);
		assertEquals(4, map.size);
		assertEquals(username, map(USER_USERNAME_STRING));
		assertEquals(name, map(USER_NAME_STRING));
		assertEquals(email, map(USER_EMAIL_STRING));
		assertEquals(password, map(USER_PASSWORD_STRING));

	}
	@Test def testMakeNewSessionPostContent() {
		val func: (Int,String,String,Option[Timestamp]) => Map[String,String] = ServerCommPosts.makeNewSessionPostMap;
		val userId = 23543543;
		val name = "Some Session";
		val description = "Lorem ipsum.";
		val timestamp = None;
		val map = func(userId, name, description, timestamp)
				assertEquals(3, map.size);
		assertEquals(userId.toString, map(USER_ID_STRING));
		assertEquals(name, map(SESSION_NAME_STRING));
		assertEquals(description, map(SESSION_DESCRIPTION_STRING));
		assertEquals(None, map.get(TIMESTAMP_STRING));
		val timestamp2 = new Timestamp(4354564576575L);
		val map2 = func(userId, name, description, Some(timestamp2));
		assertEquals(4, map2.size);
		assertEquals(timestamp2.toString(), map2.get(TIMESTAMP_STRING).get);
	}
	@Test def testMakeNewExperimentPostContent() {
		val func: (Int,String,Int,Int,Option[Timestamp]) => Map[String,String] = ServerCommPosts.makeNewExperimentPostMap;
		val sessionId = 25456;
		val name = "Some Session";
		val measurementAmount = 45;
		val frequency = 2454;
		val timestamp = None;
		val map = func(sessionId, name, measurementAmount,frequency, timestamp)
				assertEquals(4, map.size);
		assertEquals(sessionId.toString, map(SESSION_ID_STRING));
		assertEquals(name, map(EXPERIMENT_NAME_STRING));
		assertEquals(measurementAmount.toString, map(EXPERIMENT_MEASUREMENT_AMOUNT_STRING));
		assertEquals(frequency.toString, map(EXPERIMENT_FREQUENCY_STRING));
		assertEquals(None, map.get(TIMESTAMP_STRING));
		val timestamp2 = new Timestamp(4598459864598694856L);
		val map2 = func(sessionId, name, measurementAmount, frequency, Some(timestamp2));
		assertEquals(5, map2.size);
		assertEquals(timestamp2.toString(), map2.get(TIMESTAMP_STRING).get);
	}
	@Test def testMakeNewRunPostContent() {
		val func: (Int,Option[Timestamp]) => Map[String,String] = ServerCommPosts.makeNewRunPostMap;
		val experimentId = 98454;
		val timestamp = None;
		val map = func(experimentId,timestamp)
				assertEquals(1, map.size);
		assertEquals(experimentId.toString, map(EXPERIMENT_ID_STRING));
		assertEquals(None, map.get(TIMESTAMP_STRING));
		val timestamp2 = new Timestamp(4598459864598694856L);
		val map2 = func(experimentId, Some(timestamp2));
		assertEquals(2, map2.size);
		assertEquals(timestamp2.toString(), map2.get(TIMESTAMP_STRING).get);
	}
	@Test def testMakeNewMeasurementPostContent() {
		val func: (Int,String,Double,Option[Timestamp]) => Map[String,String] = ServerCommPosts.makeNewMeasurementPostMap;
		val runId = 25456;
		val typeOf = "Pressure";
		val value = 2454;
		val timestamp = None;
		val map = func(runId, typeOf, value, timestamp)
				assertEquals(3, map.size);
		assertEquals(runId.toString, map(RUN_ID_STRING));
		assertEquals(typeOf, map(MEASUREMENT_TYPE_STRING));
		assertEquals(value, map(MEASUREMENT_VALUE_STRING).toDouble, 0.000001);
		assertEquals(None, map.get(TIMESTAMP_STRING));
		val timestamp2 = new Timestamp(4598459864598694856L);
		val map2 = func(runId, typeOf, value, Some(timestamp2));
		assertEquals(4, map2.size);
		assertEquals(timestamp2.toString(), map2.get(TIMESTAMP_STRING).get);
	}


}