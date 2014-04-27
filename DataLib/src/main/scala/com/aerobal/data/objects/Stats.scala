package com.aerobal.data.objects

import scala.beans.BeanProperty
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.List;
import com.aerobal.data.objects.measurementTypes.MeasurementType
import com.aerobal.data.processing.DataProcessing
import com.aerobal.data.serializers.JSONifier

case class Stats(measurementType: MeasurementType) extends JSONifier with Serializable {
	@BeanProperty var max: Double = _;
	@BeanProperty var min: Double = _;
	@BeanProperty var mean: Double = _;
	@BeanProperty var median: Double = _;
	@BeanProperty var standardDeviation: Double = _;
	var values: List[Double] = List[Double]();

	def this(measurementType: MeasurementType, run: Run) {
		this(measurementType);
		calculateStats(run);
	}
	def this(measurementType: MeasurementType, experiment: Experiment) {
		this(measurementType);
		calculateStats(experiment);
	}
	def calculateStats(experiment: Experiment) {
		val listBuffer = new ListBuffer[Double]();
		val filtered = experiment.runs.
				foreach(run => run.measurements.
				filter(measurement => measurement.typeOf.equals(measurementType)).
				foreach(filteredMeasurement => listBuffer.append(filteredMeasurement.getValue)
						));
		values = listBuffer.toList;
		max = DataProcessing.max(values);
		min = DataProcessing.min(values);
		mean = DataProcessing.mean(values);
		median = DataProcessing.median(values);
		standardDeviation = DataProcessing.standardDeviation(values);
	}
	def calculateStats(run: Run) {
		val filtered = run.measurements.filter(measurement => measurement.typeOf.equals(measurementType));
		val listBuffer = new ListBuffer[Double]();
		filtered.foreach(filteredMeasurement => listBuffer.append(filteredMeasurement.getValue));
		val valuesList = listBuffer.toList;
		max = DataProcessing.max(valuesList);
		min = DataProcessing.min(valuesList);
		mean = DataProcessing.mean(valuesList);
		median = DataProcessing.median(valuesList);
		standardDeviation = DataProcessing.standardDeviation(valuesList);

	}

}
