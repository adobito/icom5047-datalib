package com.aerobal.data.objects.statTypes

import com.aerobal.data.processing.DataProcessing

object Min extends StatType  {
	def calculate(values: List[Double]):Double = {
	  DataProcessing.min(values);
	}
}