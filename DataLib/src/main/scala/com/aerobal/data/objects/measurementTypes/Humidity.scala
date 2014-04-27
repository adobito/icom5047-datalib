package com.aerobal.data.objects.measurementTypes

case object Humidity extends MeasurementType  {
  def id = 2;
	override def toString = "Humidity";
}