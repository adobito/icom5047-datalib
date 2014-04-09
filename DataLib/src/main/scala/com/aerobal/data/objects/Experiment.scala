package com.aerobal.data.objects

import java.sql.Timestamp
import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap
import com.aerobal.data.objects.measurementTypes.MeasurementType

case class Experiment(@BeanProperty var name: String, amountOfValues: Int,frequency: Int,
		windSpeed: Double, timestamp: Option[Timestamp]) extends Serializable {
	val runs = ListBuffer[Run]();

	val stats: HashMap[MeasurementType,Stats] = HashMap[MeasurementType,Stats]();
	initMap();
	def recalculateStats(measurementType: MeasurementType) {
//		val filteredList = runs.filter(measurement => measurement.typeOf.equals(measurementType));
//		val values = ListBuffer[Double]();
//		filteredList.foreach(measurement => values += measurement.value);
//		stats(measurementType).recalculate(values.toList);
	}
	private def initMap() {
		Measurement.typeList.foreach(measurementType => stats(measurementType) = new Stats(measurementType))
	}
}