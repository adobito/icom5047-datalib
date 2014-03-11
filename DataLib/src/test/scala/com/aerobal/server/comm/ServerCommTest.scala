package com.aerobal.server.comm

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import org.junit.Assert._
import scala.collection.mutable.HashMap
import com.aerobal.data.objects.User
import com.aerobal.data.objects.Session

class ServerCommTest extends AssertionsForJUnit {

	@Test def testMakeGetURL() {
		val route = "http://www.test.com/testroute";
		val params = HashMap[String,String]();
		params("id") = "45";
		params("name") = "testing";
		params("other") = "234.5";
		val url = ServerComm.makeGetURL(route, params.toMap[String,String]);
		val split = url.toString().split("[?]");
		assertEquals(route, split(0));
		val paramSplit = split(1).split("&");
		assertEquals(3,paramSplit.size);
		assertTrue(paramSplit.contains("id=45"));
		assertTrue(paramSplit.contains("name=testing"));
		assertTrue(paramSplit.contains("other=234.5"));
	}

	@Test def testFromJson() {
		val json = "{\"id\":1,\"username\":\"aloha23\",\"email\":\"somewhere@somewhere.com\",\"name\":\"John Smith\",\"isActive\":true}";
		val user = ServerComm.fromJson(json, classOf[User]); 
		assertEquals(1, user.id);
		assertEquals("aloha23", user.username);
		assertEquals("somewhere@somewhere.com", user.email);
		assertEquals("John Smith", user.name);
		assertEquals(true, user.isActive);

	}
	@Test def testMakeSessionGetMap() {
		val id = 4;
		val map = ServerComm.makeSessionGetMap(id);
		assertTrue(map.contains("id"))
		assertEquals("4", map("id"))
		
	}

}