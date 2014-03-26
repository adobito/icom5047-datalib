package com.aerobal.data.objects

import java.sql.Timestamp
import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer

case class Experiment(@BeanProperty var name: String, amountOfValues: Int,frequency: Int,
		windSpeed: Double, timestamp: Option[Timestamp]) extends Serializable {
		val runs = ListBuffer[Run]();
}