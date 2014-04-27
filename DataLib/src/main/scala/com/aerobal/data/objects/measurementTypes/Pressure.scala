package com.aerobal.data.objects.measurementTypes

case object Pressure extends MeasurementType {
  def id = 1;
	override def toString = "Pressure";
}