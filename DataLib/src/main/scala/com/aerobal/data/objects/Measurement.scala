package com.aerobal.data.objects

import java.sql.Timestamp
import com.aerobal.data.objects.measurementTypes._
import com.aerobal.data.serializers.JSONifier
import scala.beans.BeanProperty

case class Measurement(@BeanProperty var typeOf: String,
	@BeanProperty var value: Double) extends JSONifier with Serializable {
	@BeanProperty var id: Long = _;
	@BeanProperty var timestamp: Timestamp = new Timestamp(System.currentTimeMillis());
//  run.measurements += this;
//  run.recalculateStats(typeOf);
}
