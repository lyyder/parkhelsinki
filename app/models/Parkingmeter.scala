package models

import play.api.Play.current
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import play.api.libs.json._
import play.api.libs.json.Json._
import mongoContext._

case class Parkingmeter (
//  _id: ObjectId,
//  id: String,
  address: String
//  zone: Int
//  chargeTime: String,
//  maxParkingTime: String,
//  additionalPaymentMethod: String,
//  lat: Double,
//  lng: Double
)

//object Parkingmeter extends ParkingmeterDAO with ParkingmeterJson

object Parkingmeter extends ModelCompanion[Parkingmeter, ObjectId] with ParkingmeterJson {
  val dao = new SalatDAO[Parkingmeter, ObjectId](collection = mongoCollection("parkingmeters")) {}
}

trait ParkingmeterJson {

  //  def asSuccessJson = JsObject(Seq("success" -> JsBoolean(true), "message" -> JsString(str))) // (*)

  implicit val parkingmeterJsonWrite = new Writes[Parkingmeter] {
    def writes(p: Parkingmeter): JsValue = {
      toJson(
        Map(
        "address" -> p.address
//        "zone" -> JsNumber(p.zone)
//        "chargeTime" -> p.chargeTime,
//        "maxParkingTime" -> p.maxParkingTime,
//        "additionalPaymentMethod" -> p.additionalPaymentMethod,
//        "lat" -> p.lat,
//        "lng" -> p.lng
        )
      )
    }
  }

}
