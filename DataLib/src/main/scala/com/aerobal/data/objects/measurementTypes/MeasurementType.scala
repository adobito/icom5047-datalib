package com.aerobal.data.objects.measurementTypes

import scala.collection.immutable.HashMap

trait MeasurementType {
	def id: Int;
	override def toString: String;
}
object MeasurementTypes {
	private val pressure = Pressure;
	private val humidity = Humidity;
	private val lift = Lift;
	private val drag = Drag;
	private val tilt = Tilt;
	private val temperature = Temperature;
	private val windDirection = WindDirection;
	private val windSpeed = WindSpeed;

	private val stringMap = HashMap(pressure.toString -> Pressure,
			humidity.toString -> humidity,
			lift.toString -> lift,
			drag.toString -> drag,
			tilt.toString -> tilt,
			temperature.toString -> temperature,
			windDirection.toString -> windDirection,
			windSpeed.toString -> windSpeed);
	private val idMap = HashMap(pressure.id -> Pressure,
			humidity.id -> humidity,
			lift.id -> lift,
			drag.id -> drag,
			tilt.id -> tilt,
			temperature.id -> temperature,
			windDirection.id -> windDirection,
			windSpeed.id -> windSpeed);
	def getType(typeOf: String): MeasurementType =  {
			stringMap(typeOf);
	}
	def getType(id: Int): MeasurementType = {
			idMap(id);
	}
}