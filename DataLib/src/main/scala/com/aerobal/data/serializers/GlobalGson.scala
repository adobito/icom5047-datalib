package com.aerobal.data.serializers

import com.google.gson.GsonBuilder
import com.aerobal.data.objects.Experiment
import com.aerobal.data.objects.Measurement
import com.aerobal.data.objects.Run

object GlobalGson {
  private val builder = new GsonBuilder();
  builder.registerTypeAdapter(classOf[Experiment], ExperimentSerializer);
  builder.registerTypeAdapter(classOf[Run], RunSerializer);
  builder.registerTypeAdapter(classOf[Measurement], MeasurementSerializer);
  val gson = builder.create();
}