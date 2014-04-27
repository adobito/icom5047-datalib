package com.aerobal.data.objects.measurementTypes

case object WindSpeed extends MeasurementType  {
	def id = 8;
	override def toString = "Wind Speed";
}