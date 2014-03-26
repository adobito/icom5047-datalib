package com.aerobal.comms.server

import java.sql.Timestamp

import scala.collection.mutable.HashMap

import com.aerobal.data.objects.Experiment
import com.aerobal.data.objects.Measurement
import com.aerobal.data.objects.Run
import com.aerobal.data.objects.Session
import com.aerobal.data.objects.User
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpContent


object Posts {

	def newUser(username: String, name: String, email: String, password: String): User = {
			val map = makeNewUserPostMap(username, name, email, password);
			val urlString = ServerCommLib.makeFullRoute(Constants.HOST_ADDRESS, Constants.POST_NEW_USER_ROUTE);
			val url = new GenericUrl(urlString);
			val content = ServerCommLib.makeHttpContent(map);
			val response = executePostRequest(url, content);
			ServerCommLib.fromJson(response, classOf[User]);
	}
	def newSession(userId: Int, name: String, description: String, timestamp: Option[Timestamp]): Session = {
			val map = makeNewSessionPostMap(userId, name, description, timestamp);
			val urlString = ServerCommLib.makeFullRoute(Constants.HOST_ADDRESS, Constants.POST_NEW_SESSION_ROUTE);
			val url = new GenericUrl(urlString);
			val content = ServerCommLib.makeHttpContent(map);
			val response = executePostRequest(url, content);
			ServerCommLib.fromJson(response, classOf[Session]);
	}
	def newExperiment(sessionId: Int, name: String, measurementAmount: Int, frequency: Int, timestamp: Option[Timestamp]): Experiment = {
			val map = makeNewExperimentPostMap(sessionId, name, measurementAmount, frequency, timestamp);
			val urlString = ServerCommLib.makeFullRoute(Constants.HOST_ADDRESS, Constants.POST_NEW_EXPERIMENT_ROUTE);
			val url = new GenericUrl(urlString);
			val content = ServerCommLib.makeHttpContent(map);
			val response = executePostRequest(url, content);
			ServerCommLib.fromJson(response, classOf[Experiment]);
	}
	def newRun(experimentId: Int, timestamp: Option[Timestamp]): Run = {
			val map = makeNewRunPostMap(experimentId, timestamp);
			val urlString = ServerCommLib.makeFullRoute(Constants.HOST_ADDRESS, Constants.POST_NEW_RUN_ROUTE);
			val url = new GenericUrl(urlString);

			val content = ServerCommLib.makeHttpContent(map);
			val response = executePostRequest(url, content);
			ServerCommLib.fromJson(response, classOf[Run]);
	}
	def newMeasurement(runId:Int, typeOf: String, value: Double, timestamp: Option[Timestamp]): Measurement = {
			val map = makeNewMeasurementPostMap(runId, typeOf, value, timestamp);
			val urlString = ServerCommLib.makeFullRoute(Constants.HOST_ADDRESS, Constants.POST_NEW_MEASUREMENT_ROUTE);
			val url = new GenericUrl(urlString);
			val content = ServerCommLib.makeHttpContent(map);
			val response = executePostRequest(url, content);
			ServerCommLib.fromJson(response, classOf[Measurement]);
	}
	def auth(username: String, password: String): String = {
			null;
	}
	private[server] def executePostRequest(url: GenericUrl, content: HttpContent): String = {
			val request = ServerCommLib.requestFactory.buildPostRequest(url, content);
			request.execute().parseAsString();
	}
	private[server] def makeNewUserPostMap(username: String, name: String, email: String, password: String): Map[String,String] =  {
			val contentMap = HashMap[String,String]();
			contentMap += Constants.USER_USERNAME_STRING -> username;
			contentMap += Constants.USER_NAME_STRING -> name;
			contentMap += Constants.USER_EMAIL_STRING -> email;
			contentMap += Constants.USER_PASSWORD_STRING -> password;
			contentMap.toMap;
	}
	private[server] def makeNewSessionPostMap(userId: Int, name: String, description: String, timestamp: Option[Timestamp]): Map[String,String] =  {
			val contentMap = HashMap[String,String]();
			contentMap += Constants.USER_ID_STRING -> userId.toString;
			contentMap += Constants.SESSION_NAME_STRING -> name;
			contentMap += Constants.SESSION_DESCRIPTION_STRING -> description;
			if(timestamp.isDefined) {
				contentMap += Constants.TIMESTAMP_STRING -> timestamp.get.toString;
			}
			contentMap.toMap;
	}

	private[server] def makeNewExperimentPostMap(sessionId: Int, name: String, measurementAmount: Int, frequency: Int, timestamp: Option[Timestamp]): Map[String,String] =  {
			val contentMap = HashMap[String,String]();
			contentMap += Constants.SESSION_ID_STRING -> sessionId.toString;
			contentMap += Constants.EXPERIMENT_NAME_STRING -> name;
			contentMap += Constants.EXPERIMENT_MEASUREMENT_AMOUNT_STRING -> measurementAmount.toString;
			contentMap += Constants.EXPERIMENT_FREQUENCY_STRING -> frequency.toString;
			if(timestamp.isDefined) {
				contentMap += Constants.TIMESTAMP_STRING -> timestamp.get.toString;
			}
			contentMap.toMap;
	}
	private[server] def makeNewRunPostMap(experimentId: Int, timestamp: Option[Timestamp]): Map[String,String] = {
			val contentMap = HashMap[String,String]();
			contentMap += Constants.EXPERIMENT_ID_STRING -> experimentId.toString;
			if(timestamp.isDefined) {
				contentMap += Constants.TIMESTAMP_STRING -> timestamp.get.toString; 
			}
			contentMap.toMap;
	}
	private[server] def makeNewMeasurementPostMap(runId:Int, typeOf: String, value: Double, timestamp: Option[Timestamp]): Map[String,String] = {
			val contentMap = HashMap[String,String]();
			contentMap += Constants.RUN_ID_STRING -> runId.toString;
			contentMap += Constants.MEASUREMENT_TYPE_STRING -> typeOf;
			contentMap += Constants.MEASUREMENT_VALUE_STRING -> value.toString;
			if(timestamp.isDefined) {
				contentMap += Constants.TIMESTAMP_STRING -> timestamp.get.toString;
			}
			contentMap.toMap; 
	}
	private[server] def makeAuthPostContent() {}
}