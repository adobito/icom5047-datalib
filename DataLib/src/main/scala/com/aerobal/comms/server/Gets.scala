package com.aerobal.comms.server

import com.google.api.client.http.GenericUrl
import com.google.api.client.http.javanet.NetHttpTransport
import com.aerobal.data.dto._

object Gets {

	def getUser(id: Int): User = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_USER_ROUTE, makeUserGetMap(id));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[User]);
	}
	def getSession(id: Int): Session = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_SESSION_ROUTE, makeSessionGetMap(id));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Session]);
	}
	def getSessions(userId: Int): Sessions = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_MULTIPLE_SESSIONS_ROUTE, makeSessionsGetMap(userId));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Sessions]);
	}
	def getExperiment(id: Int): Experiment = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_EXPERIMENT_ROUTE, makeExperimentGetMap(id));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Experiment]);
	}
	def getExperiments(sessionId: Int): Experiments = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_MULTIPLE_EXPERIMENTS_ROUTE, makeExperimentGetMap(sessionId));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Experiments]);
	}
	def getRun(id: Int): Run = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_RUN_ROUTE, makeRunGetMap(id));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Run]);
	}
	def getRuns(experimentId: Int): Runs = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_MULTIPLE_RUNS_ROUTE, makeRunsGetMap(experimentId));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Runs]);
	}
	def getExperimentStats(experimentId: Int): Stats = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_EXPERIMENT_STATS_ROUTE, makeExperimentStatsGetMap(experimentId));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Stats]);
	}
	def getRunStats(runId: Int): Stats = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_RUN_STATS_ROUTE, makeRunStatsGetMap(runId));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Stats]);
	}
	def getMeasurement(id: Int): Measurement = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_MEASUREMENT_ROUTE, makeMeasurementGetMap(id));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Measurement]);
	}
	def getMeasurements(runId: Int): Measurements = {
			val url = makeGetURL(Constants.HOST_ADDRESS + Constants.GET_MEASUREMENT_ROUTE, makeMeasurementsGetMap(runId));
			val json = executeGetRequest(url);
			ServerCommLib.fromJson(json,classOf[Measurements]);
	}
	def makeGetURL(route: String, params: Map[String,String]): GenericUrl = {
			val sb = new StringBuilder;
			sb ++= route;
			if(!params.isEmpty) {
				sb += '?'
						params.foreach(x => sb ++= x._1 + "=" + x._2 + "&")
			}
			new GenericUrl(sb.toString);
	}
	private def executeGetRequest(url: GenericUrl): String = {
			ServerCommLib.requestFactory.buildGetRequest(url).execute().parseAsString();
	}
	private[server] def makeUserGetMap(id: Int): Map[String, String] = {
			ServerCommLib.negativeCheck(id);
			Map(Constants.ID_STRING -> id.toString);
	}
	private[server] def makeUsersGetMap(): Map[String, String] = {
			Map[String,String]();
	}
	private[server] def makeSessionGetMap(id: Int): Map[String,String] = {
			ServerCommLib.negativeCheck(id);
			Map(Constants.ID_STRING -> id.toString());
	}
	private[server] def makeSessionsGetMap(userId: Int): Map[String,String] = {
			ServerCommLib.negativeCheck(userId);
			Map(Constants.USER_ID_STRING -> userId.toString());
	}
	private[server] def makeExperimentGetMap(id: Int): Map[String,String] = {
			ServerCommLib.negativeCheck(id);
			Map(Constants.ID_STRING -> id.toString);
	}
	private[server] def makeExperimentsGetMap(sessionId: Int): Map[String,String] = {
			ServerCommLib.negativeCheck(sessionId);
			Map(Constants.SESSION_ID_STRING -> sessionId.toString);
	}
	private[server] def makeExperimentStatsGetMap(experimentId: Int): Map[String, String] = {
			ServerCommLib.negativeCheck(experimentId);
			Map(Constants.EXPERIMENT_ID_STRING -> experimentId.toString);
	}
	private[server] def makeRunGetMap(id: Int): Map[String,String] = {
			ServerCommLib.negativeCheck(id);
			Map(Constants.ID_STRING -> id.toString());
	}
	private[server] def makeRunsGetMap(experimentId: Int): Map[String,String] = {
			ServerCommLib.negativeCheck(experimentId);
			Map(Constants.EXPERIMENT_ID_STRING -> experimentId.toString());
	}
	private[server] def makeRunStatsGetMap(runId: Int): Map[String,String] = {
			ServerCommLib.negativeCheck(runId);
			Map(Constants.RUN_ID_STRING -> runId.toString);
	}
	private[server] def makeMeasurementGetMap(id: Int): Map[String, String] = {
			ServerCommLib.negativeCheck(id);
			Map(Constants.ID_STRING -> id.toString);
	}
	private[server] def makeMeasurementsGetMap(runId: Int): Map[String, String] = {
			ServerCommLib.negativeCheck(runId);
			Map(Constants.RUN_ID_STRING -> runId.toString);
	}
}
