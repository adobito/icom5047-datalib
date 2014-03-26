package com.aerobal.comms.server

import scala.collection.mutable.HashMap

import com.aerobal.data.objects.Experiment
import com.aerobal.data.objects.Session
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpContent


object Puts {


	def updateSession(sessionId: Int, name: Option[String], description: Option[String]): Session = {
			val map = makeUpdateSessionPutMap(sessionId, name, description);
			val url = new GenericUrl("");
			val content = ServerCommLib.makeHttpContent(map);
			val response = executePutRequest(url, content);
			ServerCommLib.fromJson(response, classOf[Session]);
	}
	def updateExperiment(experimentId: Int, name: Option[String]): Experiment = {
			val map = makeUpdateExperimentPutMap(experimentId, name);
			val url = new GenericUrl("");
			val content = ServerCommLib.makeHttpContent(map);
			val response = executePutRequest(url, content);
			ServerCommLib.fromJson(response, classOf[Experiment]);
	}
	private[server] def executePutRequest(url: GenericUrl, content: HttpContent): String = {
			val request = ServerCommLib.requestFactory.buildPutRequest(url, content);
			request.execute().parseAsString();
	}
	private[server] def makeUpdateSessionPutMap(sessionId: Int, name: Option[String], description: Option[String]): Map[String, String] = {
			val map =  HashMap[String,String]();
			map += Constants.SESSION_ID_STRING -> sessionId.toString;

			if(name.isDefined) {
				map += Constants.SESSION_NAME_STRING -> name.get;
			}
			if(description.isDefined) {
				map += Constants.SESSION_DESCRIPTION_STRING -> description.get;
			}
			map.toMap;

	}
	private[server] def makeUpdateExperimentPutMap(experimentId: Int, name: Option[String]): Map[String, String] = {
			val map =  HashMap[String,String]();
			map += Constants.EXPERIMENT_ID_STRING -> experimentId.toString;
			if(name.isDefined) {
				map += Constants.EXPERIMENT_NAME_STRING -> name.get;
			}
			map.toMap;
	}

}