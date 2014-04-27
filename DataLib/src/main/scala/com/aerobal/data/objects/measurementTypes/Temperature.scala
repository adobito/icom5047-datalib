package com.aerobal.data.objects.measurementTypes

case object Temperature extends MeasurementType  {
  def id = 6;
	override def toString = "Temperature";
}