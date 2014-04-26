package com.aerobal.data.objects

import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer
import com.aerobal.data.dto.RunDto
import com.aerobal.data.serializers.JSONifier
import java.sql.Timestamp

case class Run() extends JSONifier with Serializable { 
	@BeanProperty var id: Long = _;
	@BeanProperty var timestamp: Timestamp = new Timestamp(System.currentTimeMillis());
	
	def this(runDto: RunDto) {
	  this();
	  this.id = runDto.id;
	  this.timestamp = runDto.timestamp;
	}
	val measurements = ListBuffer[Measurement]();
	
//	val stats: HashMap[MeasurementType,Stats] = HashMap[MeasurementType,Stats]();
//	initMap();
//	def recalculateStats(measurementType: MeasurementType) {
//	  val filteredList = measurements.filter(measurement => measurement.typeOf.equals(measurementType));
//	  val values = ListBuffer[Double]();
//	  filteredList.foreach(measurement => values += measurement.value);
//	  stats(measurementType).recalculate(values.toList);
//	  experiment.recalculateStats(measurementType);
//	}
//	private def initMap() {
//	  Measurement.typeList.foreach(measurementType => stats(measurementType) = new Stats(measurementType))
//	}
	
}