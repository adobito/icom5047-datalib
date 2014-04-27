package com.aerobal.data.objects

import java.sql.Timestamp
import com.aerobal.data.objects.measurementTypes._
import com.aerobal.data.serializers.JSONifier
import scala.beans.BeanProperty
import com.aerobal.data.dto.MeasurementDto

case class Measurement(@BeanProperty var typeOf: MeasurementType,
	@BeanProperty var value: Double) extends JSONifier with Serializable {
	@BeanProperty var id: Long = _;
	@BeanProperty var timestamp: Timestamp = new Timestamp(System.currentTimeMillis());
	
	def this(measurementDto: MeasurementDto) {
	  this(MeasurementTypes.getType(measurementDto.measurementTypeId), measurementDto.value);
	  this.id = measurementDto.id;
	  this.timestamp = measurementDto.timestamp;
	}
}
