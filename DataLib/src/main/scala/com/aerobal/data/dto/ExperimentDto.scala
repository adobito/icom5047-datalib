package com.aerobal.data.dto

import java.sql.Timestamp
import scala.beans.BeanProperty
import com.aerobal.data.serializers.JSONifier

case class ExperimentDto(@BeanProperty var sessionId: Long, 
    @BeanProperty var name: String, 
    @BeanProperty var amountOfValues: Int, 
    @BeanProperty var frequency: Int,
	@BeanProperty var windSpeed: Double ) extends JSONifier {
	@BeanProperty var id: Long = _;
	@BeanProperty var isActive: Boolean = true;
	@BeanProperty var timestamp: Timestamp  = new Timestamp(System.currentTimeMillis());
	def this() {
		this( -1, "", -1, -1, -1);
	}
}
