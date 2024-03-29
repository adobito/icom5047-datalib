package com.aerobal.comms.server

import scala.collection.mutable.HashMap
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit
import java.security.InvalidParameterException
import com.aerobal.data.dto.UserDto

class ServerCommLibTest extends AssertionsForJUnit {


	@Test def testMakeFullRoute() {
		var host = "http://www.tet.com/";
		var route = "/route";
		var expectedUrl = "http://www.tet.com/route";
		assertEquals(expectedUrl,ServerCommLib.makeFullRoute(host, route));
		host = "algo.rad.ed";
		route = "someroute";
		expectedUrl = "http://algo.rad.ed/someroute";
		assertEquals(expectedUrl,ServerCommLib.makeFullRoute(host, route));
		host = "localhost";
		route = "datRoute";
		expectedUrl = "http://localhost/datRoute";
		assertEquals(expectedUrl,ServerCommLib.makeFullRoute(host, route));

	}
	@Test def testFromJson() {
		val json = "{\"id\":1,\"email\":\"somewhere@somewhere.com\",\"name\":\"John Smith\",\"isActive\":true}";
		val user = ServerCommLib.fromJson(json, classOf[UserDto]); 
		assertEquals(1, user.id);
		assertEquals("somewhere@somewhere.com", user.email);
		assertEquals("John Smith", user.name);
		assertEquals(true, user.isActive);

	}
	@Test def testNegativeCheck() {
		ServerCommLib.negativeCheck(35343);
		ServerCommLib.negativeCheck(0);
		try {
			ServerCommLib.negativeCheck(-13422);
		}
		catch {
		case e: InvalidParameterException => ();
		}
	}



}