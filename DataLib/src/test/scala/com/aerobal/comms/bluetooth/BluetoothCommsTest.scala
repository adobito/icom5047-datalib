package com.aerobal.comms.bluetooth

import org.junit.Test
import org.junit.Assert._
import org.scalatest.junit.AssertionsForJUnit
import java.security.InvalidParameterException

class BluetoothCommsTest extends AssertionsForJUnit { 
	private val PRESSURE_KEY = "ps";
	private val HUMIDITY_KEY = "hm";
	private val TEMPERATURE_KEY = "tm";
	private val WIND_DIRECTION_KEY = "wd";
	private val LOAD_CELL_KEY = "lc";
	private val PROCESSOR_PROCEDURE_KEY = "pss";
	private val FAN_KEY = "fan";
	private val LINE_WRITE_KEY = "ln";
	private val WIND_SPEED_KEY = "ws";
	private val GET_SYMBOL = "?";

	@Test def testMakeBluetoothString() {
		val key = "someKey";
		val value = "someValue";
		val expected = "bt:someKey=someValue\r\n";
		assertEquals(expected, BluetoothComms.makeBluetoothString(key, value));
		val func:(String,String) => String = BluetoothComms.makeBluetoothString;
		testForInvalidParameterException(func, null, null);
		testForInvalidParameterException(func, key, null);
		testForInvalidParameterException(func, null, value);
		testForInvalidParameterException(func, "", value);
		testForInvalidParameterException(func, key, "");
	}
	def testForInvalidParameterException(func:(String,String) => String, key: String, value: String) {
	  		try {
			func(key, value);
			fail("Expected InvalidParameterException from key: " + key + "and value: " + value);
		} catch {
		  case e: InvalidParameterException => {}
		}
	}
	@Test def testMakeGetPressureSensorString() {
		val sensorNumber = 5;
		val expected = "bt:" + PRESSURE_KEY + "=" + GET_SYMBOL+ sensorNumber + "\r\n";
		assertEquals(expected, BluetoothComms.getPressureSensorValue(sensorNumber));
		try {
		  BluetoothComms.getPressureSensorValue(-4);
		  fail("Expected InvalidParameterException")
		} catch {
		  case e: InvalidParameterException => {}
		}
	}
	@Test def testMakeGetHumidityString() {
		val func: () => String = BluetoothComms.makeGetHumidityString;
		val key = HUMIDITY_KEY;
		val expected = "bt:" + key + "=" + GET_SYMBOL + "\r\n";
		assertEquals(expected, func());
	}
	@Test def testMakeGetTemperatureString() {
				val func: () => String = BluetoothComms.makeGetTemeperatureString;
		val key = TEMPERATURE_KEY;
		val expected = "bt:" + key + "=" + GET_SYMBOL + "\r\n";
		assertEquals(expected, func());
	}
	@Test def testMakeGetWindDirectionString() {
				val func: () => String = BluetoothComms.makeGetWindDirectionString;
		val key = WIND_DIRECTION_KEY;
		val expected = "bt:" + key + "=" + GET_SYMBOL + "\r\n";
		assertEquals(expected, func());
	}
	@Test def testMakeGetLoadCellString() {
		val func: String => String = BluetoothComms.makeGetLoadCellString;
		val key = LOAD_CELL_KEY;
		val cell = "up"
		val expected = "bt:" + key + "=" + GET_SYMBOL + cell + "\r\n";
		assertEquals(expected, func(cell));
	}
	@Test def testMakeProcessorProcedureString() {
				val func: () => String = BluetoothComms.makeProcessorProcedureString;
		val key = PROCESSOR_PROCEDURE_KEY;
		val expected = "bt:" + key + "=" + GET_SYMBOL + "\r\n";
		assertEquals(expected, func());
		
	}
	@Test def testMakeFanString() {
		val func: Boolean => String = BluetoothComms.makeFanString;
		val key = FAN_KEY;
		val expected = "bt:" + key + "=on" + "\r\n";
		assertEquals(expected, func(true));
		val expected2 = "bt:" + key + "=off" + "\r\n";
		assertEquals(expected2, func(false));

	}
	@Test def testMakeLineWriteString() {
		val func: (Int,String) => String = BluetoothComms.makeLineWriteString
		val key = LINE_WRITE_KEY;
		val lineNum = 2;
		val text = "someText"
		val expected = "bt:" + key + "=" +lineNum+":"+ text+ "\r\n";
		assertEquals(expected, func(lineNum,text));
		try {
		  func(-4,text);
		  fail("Expected InvalidParameterException")
		} catch {
		  case e: InvalidParameterException => {}
		}
		try {
		  func(lineNum, null);
		  fail("Expected InvalidParameterException")
		} catch {
		  case e: InvalidParameterException => {}
		}
	}
	@Test def testMakeSetWindSpeedString() {
			val func: Double => String = BluetoothComms.makeSetWindSpeedString;
		val key = WIND_SPEED_KEY;
		val value = 342.23
		val expected = "bt:" + key + "="+ value + "\r\n";
		assertEquals(expected, func(value));
				try {
		  func(-24);
		  fail("Expected InvalidParameterException")
		} catch {
		  case e: InvalidParameterException => {}
		}
	}
}