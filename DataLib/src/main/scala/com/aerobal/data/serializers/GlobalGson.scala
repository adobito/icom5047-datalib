package com.aerobal.data.serializers

import com.google.gson.GsonBuilder
import com.aerobal.data.objects.Experiment
import com.aerobal.data.objects.Measurement
import com.aerobal.data.objects.Run

object GlobalGson {
  val gson = new GsonBuilder().
  registerTypeAdapter(classOf[Experiment], ExperimentSerializer).
  registerTypeAdapter(classOf[Run], RunSerializer).
  registerTypeAdapter(classOf[Measurement], MeasurementSerializer).
  create();
}