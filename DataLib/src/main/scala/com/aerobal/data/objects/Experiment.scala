package com.aerobal.data.objects

import java.sql.Timestamp
import scala.collection.mutable.ListBuffer

case class Experiment(name: String, amountOfValues: Int, frequency: Int,
		windSpeed: Double, timestamp: Option[Timestamp]){
		val runs = ListBuffer[Run]();

}