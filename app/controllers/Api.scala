package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Json._
import models._

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

  def newMeter = Action {
    val meter = Parkingmeter(
      "1234", "address", 2, "chargetime", "max park time", "additional", 20.2, 30.3)
    Parkingmeter.insert(meter)

    Ok("new meter")
  }

}
