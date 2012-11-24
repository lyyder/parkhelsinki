package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Json._

object Api extends Controller {
  
  def parkingmeter = Action {
    val meter = toJson(
      Map(
        "id" -> toJson("dummy meter id"),
        "lat" -> toJson(22.2),
        "lng" -> toJson(33.3)
      )
    )

    Ok(meter)
  }
  
}
