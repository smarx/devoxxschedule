package models

import java.util._
import eu.henkelmann.actuarius.ActuariusTransformer

class Presentation {
	var id:Int = 0
	var fromTime:Date = null
	var toTime:Date = null
	var room:String = null
	var speaker:String = null
	var presentationUri:String = null
	var `type`:String = null
	var kind:String = null
	var title:String = "TBA"
	var speakerUri:String = null
	def urlId:Int = {
		Integer.parseInt(presentationUri.substring(presentationUri.lastIndexOf('/')+1))
	}
	def summaryFormatted:String = {
		new ActuariusTransformer()(summary)
	}
	var summary:String = null
}