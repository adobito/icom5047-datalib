package com.aerobal.data.objects.statTypes

import com.aerobal.data.processing.DataProcessing

object StandardDeviation extends StatType  {
	def calculate(values: List[Double]):Double = {
			DataProcessing.standardDeviation(values);
	}
}