package controllers

import play.api.mvc._
import play.api.libs.json.Json._
import models._
import org.bson.types.ObjectId

object Api extends Controller {
  
  def parkingmeters = Action {
    val meters = Parkingmeter.findAll();
    Ok(toJson(meters.toList))
  }

  def parkingmeter(id: String) = Action {
    val meter = Parkingmeter.findOneById(id)
    Ok(toJson(meter))
  }

  def newMeter = Action {

   // val meter = Parkingmeter(new ObjectId, "1234", "address");
   // Parkingmeter.insert(meter)

    Ok("new meter")
  }

}
