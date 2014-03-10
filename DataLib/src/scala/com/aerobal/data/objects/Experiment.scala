package com.aerobal.data.objects

import java.sql.Timestamp

case class Experiment(id: Int, sessionId: Int, name: String, amountOfValues: Int, frquency: Int,
		windSpeed: Double, timestamp: Timestamp) extends JSONifier{

	lazy val runs: List[Run] = null;;
	lazy val stats: Stats = null;
}