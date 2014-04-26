package com.aerobal.data.objects

import java.sql.Timestamp
import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap
import com.aerobal.data.objects.measurementTypes.MeasurementType
import com.aerobal.data.dto.ExperimentDto
import com.aerobal.data.serializers.JSONifier

case class Experiment(@BeanProperty var name: String, 
    @BeanProperty var amountOfValues: Int, 
    @BeanProperty var frequency: Int,
	@BeanProperty var windSpeed: Double ) extends JSONifier with Serializable {
	@BeanProperty var id: Long = _;
	@BeanProperty var timestamp: Timestamp  = new Timestamp(System.currentTimeMillis());
	
	def this(experimentDto: ExperimentDto) {
	  this(experimentDto.name, experimentDto.amountOfValues, experimentDto.frequency, experimentDto.windSpeed);
	  this.id = experimentDto.id;
	  this.timestamp = experimentDto.timestamp;
	}
	val runs = ListBuffer[Run]();

//	val stats: HashMap[MeasurementType,Stats] = HashMap[MeasurementType,Stats]();
//	initMap();
//	def recalculateStats(measurementType: MeasurementType) {
////		val filteredList = runs.filter(measurement => measurement.typeOf.equals(measurementType));
////		val values = ListBuffer[Double]();
////		filteredList.foreach(measurement => values += measurement.value);
////		stats(measurementType).recalculate(values.toList);
//	}
//	private def initMap() {
//		Measurement.typeList.foreach(measurementType => stats(measurementType) = new Stats(measurementType))
//	}
}