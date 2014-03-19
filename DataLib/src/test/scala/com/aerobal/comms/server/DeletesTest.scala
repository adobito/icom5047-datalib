package com.aerobal.comms.server

import scala.collection.mutable.HashMap

import org.junit.Assert._
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

import com.google.api.client.http.GenericUrl

class DeletesTest extends AssertionsForJUnit {

	@Test def testMakeDeleteURL() {
		val route = "http://www.test.com/testroute";
		val params = HashMap[String,String]();
		params("id") = "45";
		params("name") = "testing";
		params("other") = "234.5";
		val url = Gets.makeGetURL(route, params.toMap[String,String]);
		val split = url.toString().split("[?]");
		assertEquals(route, split(0));
		val paramSplit = split(1).split("&");
		assertEquals(3, paramSplit.size);
		assertTrue(paramSplit.contains("id=45"));
		assertTrue(paramSplit.contains("name=testing"));
		assertTrue(paramSplit.contains("other=234.5"));
		Deletes.makeDeleteURL(route, params.toMap)
	}
	@Test def testMakeSessionDeleteUrl() {
		val route = "/route";
		val host = "http://algo.io/";
		val sessionId = 142534;
		val url = Deletes.makeDeleteSessionUrl(host, route, sessionId);
		val expected = new GenericUrl("http://algo.io/route?sessionId=" + sessionId);
		assertEquals(expected, url);
	}
	@Test def testMakeExperimentDeleteUrl() {
		val route = "/route";
		val host = "http://algo.io/";
		val experimentId = 345089;
		val url = Deletes.makeDeleteExperimentUrl(host, route, experimentId);
		val expected = new GenericUrl("http://algo.io/route?experimentId=" + experimentId);
		assertEquals(expected, url);
	}
	@Test def testMakeRunDeleteUrl() {
		val route = "/route";
		val host = "http://algo.io/";
		val runId = 289734;
		val url = Deletes.makeDeleteRunUrl(host, route, runId);
		val expected = new GenericUrl("http://algo.io/route?runId=" + runId);
		assertEquals(expected, url);
	}
	@Test def testGetJsonBooleanResponse() {
		assertTrue(Deletes.getJsonBooleanResponse("{\"confirm\":true}"));
		assertFalse(Deletes.getJsonBooleanResponse("{\"confirm\":false}"));
	}

}