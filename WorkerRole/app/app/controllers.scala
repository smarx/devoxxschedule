package controllers

import play._
import play.mvc._
import java.net._
import scala.io._
import com.google.gson._
import models._
import play.cache.Cache

object Application extends Controller {
    import views.Application._

    def index = {
    	val text = Cache.get("schedule") match {
    		case Some(thing) => thing
    		case None => {
    			val thing = Source.fromURL("https://cfp.devoxx.com/rest/v1/events/4/schedule").mkString
    			Cache.set("schedule", Source.fromURL("https://cfp.devoxx.com/rest/v1/events/4/schedule").mkString, "5mn")
    			thing
    		}
    	}
    	val gson = new GsonBuilder().setDateFormat("y-M-d H:m:s.S").create()
    	val presentations = gson.fromJson(text, classOf[Array[Presentation]]).toList
    	html.index(presentations)
    }
}

object Presentation extends Controller {
	import views.Presentation._
    def show(id:Int) = {
    	val text = Source.fromURL(String.format("https://cfp.devoxx.com/rest/v1/events/presentations/%d", id.asInstanceOf[AnyRef])).mkString
    	val gson = new GsonBuilder().setDateFormat("y-M-d H:m:s.S").create()
    	val presentation = gson.fromJson(text, classOf[Presentation])
    	val speaker = gson.fromJson(Source.fromURL(presentation.speakerUri).mkString, classOf[Speaker])
    	html.show(presentation, speaker)
    }    
}

object About extends Controller {
    import views.About._
    def index = {
        html.index()
    }
}