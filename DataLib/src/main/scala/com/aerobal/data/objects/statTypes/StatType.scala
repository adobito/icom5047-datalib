package com.aerobal.data.objects.statTypes

import com.aerobal.data.objects.Measurement

trait StatType {
  def calculate(values: List[Double]): Double;
}