package com.aerobal.data.objects

import java.sql.Timestamp
import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.List
import com.aerobal.data.objects.measurementTypes._
import com.aerobal.data.objects.statTypes._

case class Run(experiment: Experiment, timestamp: Option[Timestamp]) extends Serializable{
	experiment.runs += this;
	val measurements = ListBuffer[Measurement]();
	
	val stats: HashMap[MeasurementType,Stats] = HashMap[MeasurementType,Stats]();
	initMap();
	def recalculateStats(measurementType: MeasurementType) {
	  val filteredList = measurements.filter(measurement => measurement.typeOf.equals(measurementType));
	  val values = ListBuffer[Double]();
	  filteredList.foreach(measurement => values += measurement.value);
	  stats(measurementType).recalculate(values.toList);
	}
	private def initMap() {
	  Measurement.typeList.foreach(measurementType => stats(measurementType) = new Stats(measurementType))
	}
	
}