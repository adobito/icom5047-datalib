package com.aerobal.data.objects

import java.sql.Timestamp
import com.aerobal.data.objects.measurementTypes._

case class Measurement(run: Run, typeOf: MeasurementType, value: Double, timestamp: Option[Timestamp]) extends Serializable{
  run.measurements += this;
  run.recalculateStats(typeOf);
}
object Measurement {
   val typeList: List[MeasurementType] = List(Drag,Lift,Tilt,Pressure, WindSpeed, WindDirection,Temperature,Humidity);
}