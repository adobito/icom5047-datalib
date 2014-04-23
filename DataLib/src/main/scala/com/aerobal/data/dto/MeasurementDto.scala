package com.aerobal.data.dto

import scala.beans.BeanProperty
import java.sql.Timestamp

case class MeasurementDto(@BeanProperty var runId: Long, 
    @BeanProperty var measurementTypeId: Integer,
	@BeanProperty var value: Double) extends JSONifier {
	@BeanProperty var id: Long = _;
	@BeanProperty var timestamp: Timestamp = new Timestamp(System.currentTimeMillis());
	@BeanProperty var isActive: Boolean = true;
	def this() = {
		this(-1, -1, -1)
	}
}
