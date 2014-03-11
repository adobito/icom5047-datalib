//package com.aerobal.data.objects
//
//import com.aerobal.server.comm.ServerComm
//
//object Main {
//
//	def main(args: Array[String]): Unit = {
//			val measurement = new Measurement(1,"type",12);
//			val user = new User(1,"name","email","myName",true);
//			println(measurement);
//			println(user);
//			println( ServerComm.deJSONer(measurement.toString, classOf[Measurement]));
//	}
//}