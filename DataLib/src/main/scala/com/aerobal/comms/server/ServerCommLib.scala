package com.aerobal.comms.server

import java.security.InvalidParameterException
import com.google.api.client.http.HttpContent
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.http.json.JsonHttpContent
import com.google.api.client.json.jackson.JacksonFactory
import com.google.gson.Gson
import com.sun.org.glassfish.gmbal.util.GenericConstructor
import com.google.api.client.util.GenericData
import com.google.api.client.http.UrlEncodedContent

case object ServerCommLib {
	private[server] val requestFactory = new NetHttpTransport().createRequestFactory();
	private[server] val JACKSON_FACTORY = new JacksonFactory();
	var HOST = "http://127.0.0.1/" ;


	private[server] def makeFullRoute(host: String, route: String): String = {
	  lazy val sb = new StringBuilder();
	  if(!host.matches("(http[s]?://)?(([a-zA-Z0-9]+\\.)*[a-zA-Z0-9]+\\.[A-Za-z0-9]+(:[0-9]+)?+|localhost)(/[a-zA-Z0-9]*)*") ) {
	    throw new InvalidParameterException("Invalid Host");;
	  }
	  else if (host.matches("([A-Za-z]+.)?[A-Za-z]+.[A-Za-z]+(/[A-Za-z]*)*")) {
	    sb.append("http://");
	    
	  }
	  sb.append(host);
	  if(host.last != '/' && route(0) != '/') {
	    sb.append('/');
	    sb.append(route);
	  } else if(host.last == '/' && route(0) == '/') {
	    sb.append(route.substring(1));
	  }
	  else sb.append(route);
	  sb.toString;

	}


	private[server] def makeHttpContent(map: Map[String,String]): HttpContent  = {
	  val generic = new GenericData();
	  map.foreach( x => generic.put(x._1, x._2));
	  val content = new UrlEncodedContent();
	  content.setData(generic);
	  content;	
	}

	private[server] def fromJson[T](json: String, classType: Class[T]): T = {
			new Gson().fromJson(json, classType);
	}
	private[server] def negativeCheck(num: Int) {
		if(num < 0)
			throw new InvalidParameterException("Expected non-negative number but received " + num);
	}

}