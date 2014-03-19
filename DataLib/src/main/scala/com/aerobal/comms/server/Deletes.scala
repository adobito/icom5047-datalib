package com.aerobal.comms.server

import com.google.api.client.http.GenericUrl
import scala.util.parsing.json._
import com.google.gson.JsonParser

object Deletes {


	def deleteSession(sessionId: Int): Boolean = {
			val url = makeDeleteSessionUrl(ServerCommLib.HOST, Constants.DELETE_SESSION_ROUTE, sessionId);
			val json = executePutRequest(url);
			getJsonBooleanResponse(json);
	}
	def deleteExperiment(experimentId: Int): Boolean = {
			val url = makeDeleteExperimentUrl(ServerCommLib.HOST, Constants.DELETE_EXPERIMENT_ROUTE, experimentId);
			val json = executePutRequest(url);
			getJsonBooleanResponse(json);
			}
	def deleteRun(runId: Int): Boolean = {
			val url = makeDeleteRunUrl(ServerCommLib.HOST, Constants.DELETE_RUN_ROUTE, runId);
			val json = executePutRequest(url);
			getJsonBooleanResponse(json);
			}
	private[server] def executePutRequest(url: GenericUrl): String = {
			val request = ServerCommLib.requestFactory.buildDeleteRequest(url);
			request.execute().parseAsString();
	}
	def makeDeleteURL(route: String, params: Map[String,String]): GenericUrl = {
			val sb = new StringBuilder;
			sb ++= route;
			if(!params.isEmpty) {
				sb += '?'
						params.foreach(x => sb ++= x._1 + "=" + x._2 + "&")
			}
			new GenericUrl(sb.toString);
	}
	private[server] def getJsonBooleanResponse(json: String): Boolean = {
	  val jsonElement = new JsonParser().parse(json);
	  val jsonObject = jsonElement.getAsJsonObject();
	  
	  jsonObject.getAsJsonPrimitive(Constants.DELETE_CONFIRM_JSON_KEY).getAsBoolean();
	}
	private[server] def makeDeleteSessionUrl(host: String, route: String, sessionId: Int): GenericUrl = {
			val fullRoute = ServerCommLib.makeFullRoute(host, route);
			val url = makeDeleteURL(fullRoute, Map(Constants.SESSION_ID_STRING -> sessionId.toString));
			url; 
	}
	private[server] def makeDeleteExperimentUrl(host: String, route: String, experimentId: Int): GenericUrl = {
			val fullRoute = ServerCommLib.makeFullRoute(host, route);
			val url = makeDeleteURL(fullRoute, Map(Constants.EXPERIMENT_ID_STRING -> experimentId.toString));
			url;
	}
	private[server] def makeDeleteRunUrl(host: String, route: String, runId: Int): GenericUrl = {
			val fullRoute = ServerCommLib.makeFullRoute(host, route);
			val url = makeDeleteURL(fullRoute, Map(Constants.RUN_ID_STRING -> runId.toString));
			url;
	}
}