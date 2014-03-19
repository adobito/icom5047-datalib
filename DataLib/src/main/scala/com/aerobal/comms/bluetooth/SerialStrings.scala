package com.aerobal.comms.bluetooth

import java.security.InvalidParameterException

object SerialStrings {
	private val PRESSURE_KEY = "ps";
	private val HUMIDITY_KEY = "hm";
	private val TEMPERATURE_KEY = "tm";
	private val WIND_DIRECTION_KEY = "wd";
	private val LOAD_CELL_KEY = "lc";
	private val PROCESSOR_PROCEDURE_KEY = "pss";
	private val FAN_KEY = "fan";
	private val LINE_NUMBER_KEY = "ln";
	private val WIND_SPEED_KEY = "ws";
	private val GET_SYMBOL = "?";

	def getPressureSensorValue(sensorNumber: Int): String = {
			if(sensorNumber < 0)
				throw new InvalidParameterException("Sensor Number cannot be a negative value.");
			makeGetPressureSensorString(sensorNumber);
	}
	def getHumidity(): String = {
			makeGetHumidityString;
	}
	def getTemperature(): String = {
			makeGetTemeperatureString;
	}
	def getWindDirection(): String = {
			makeGetWindDirectionString;
	}
	def getLoadUp(): String = {
			makeGetLoadCellString(LoadCells.up);
	}
	def getLoadDown(): String = {
			makeGetLoadCellString(LoadCells.down);
	}
	def getLoadLeft(): String = {
			makeGetLoadCellString(LoadCells.left);
	}
	def getLoadRight(): String = {
			makeGetLoadCellString(LoadCells.right);
	}
	def getLoadFront(): String = {
			makeGetLoadCellString(LoadCells.front);
	}
	def getLoadBack(): String = {
			makeGetLoadCellString(LoadCells.back);
	}
	def initiateProcessorProcedure(): String = {
			makeProcessorProcedureString;
	}
	def enableFan():String =  {
			makeFanString(true);
	}
	def disableFan(): String =  {
			makeFanString(false);
	}
	def writeText(line:Int, text: String): String = {
			makeLineWriteString(line, text);
	}
	def setWindSpeed(windSpeed: Double): String = {
			makeSetWindSpeedString(windSpeed);
	}
	def makeBluetoothString(key: String, value: String): String = {
			if(key == null || key.isEmpty())
				throw new InvalidParameterException("Key cannot be empty or null.");
			if(value == null || value.isEmpty())
				throw new InvalidParameterException("Value cannot be empty or null.");
			"bt:" + key + "=" + value + "\r\n"
	}
	private[bluetooth] def makeGetPressureSensorString(sensorNumber: Int): String = {
			makeBluetoothString(PRESSURE_KEY, GET_SYMBOL + sensorNumber);
	}

	private[bluetooth] def makeGetHumidityString(): String = {
			makeBluetoothString(HUMIDITY_KEY, GET_SYMBOL);
	}
	private[bluetooth] def makeGetTemeperatureString(): String = {
			makeBluetoothString(TEMPERATURE_KEY, GET_SYMBOL);
	}
	private[bluetooth] def makeGetWindDirectionString(): String = {
			makeBluetoothString(WIND_DIRECTION_KEY, GET_SYMBOL);
	}
	private[bluetooth] def makeGetLoadCellString(cellPosition: String): String = {
			makeBluetoothString(LOAD_CELL_KEY, GET_SYMBOL + cellPosition);
	}
	private[bluetooth] def makeProcessorProcedureString(): String = {
			makeBluetoothString(PROCESSOR_PROCEDURE_KEY, GET_SYMBOL);
	}
	private[bluetooth] def makeFanString(on: Boolean): String =  {
			val onOrOff = if(on) "on" else "off";
			makeBluetoothString(FAN_KEY, onOrOff);
	}
	def makeLineWriteString(lineNumber: Int, text: String): String = {
	  if(lineNumber < 0)
	    throw new InvalidParameterException("Line number must be a non-negative number.");
	  if(text == null) 
	    throw new InvalidParameterException("Text field cannot be null.");
			makeBluetoothString(LINE_NUMBER_KEY, lineNumber + ":" + text);
	}
	def makeSetWindSpeedString(value: Double): String = {
	  if(value < 0)
	    throw new InvalidParameterException("Wind Speed value must be a non-negative number.");
	  makeBluetoothString(WIND_SPEED_KEY, value.toString);
	}

}