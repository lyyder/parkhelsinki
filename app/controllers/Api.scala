package controllers

import play.api.mvc._
import play.api.libs.json.Json._
import models._
import org.bson.types.ObjectId

object Api extends Controller {
  
  def parkingmeters(lng: Option[Double], lat: Option[Double],
                    maxDistance: Option[Int], limit: Option[Int]) = Action {

    (lng, lat, maxDistance, limit) match {
      case (Some(lng), Some(lat), Some(maxDistance), Some(limit)) => Ok(toJson(Parkingmeter.findClosest(lng, lat, maxDistance, limit).toList))
      case _ => Ok(toJson(Parkingmeter.findAll().toList))
    }
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
