package com.aerobal.data.objects

import scala.collection.mutable.HashMap
import java.util.Collection
import java.security.InvalidParameterException
import com.aerobal.data.objects.statTypes._
import com.aerobal.data.objects.measurementTypes.MeasurementType

case class Stats(val measurementType: MeasurementType)  extends Serializable {
	val stats = HashMap[StatType, Double]();
	Stats.typeList.foreach(statType => stats(statType) = 0);
	
	def apply(statType: StatType): Double = {
	  stats(statType);
	}
	def recalculate(values: List[Double]) {
	  stats.keySet.foreach(statType => stats(statType) = statType.calculate(values));
	}
}
object Stats {
	val typeList: List[StatType] = List(Max,Min,Median,Mean,StandardDeviation);
}