package models

import play.api.Play.current
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import play.api.libs.json._
import play.api.libs.json.Json._
import mongoContext._

case class Parkingmeter (
  id: String,
  address: String,
  zone: String,
  chargeTime: String,
  maxParkingTime: String,
  additionalPaymentMethod: String,
  lat: Double,
  lng: Double
)

object Parkingmeter extends ParkingmeterDAO with ParkingmeterJson

trait ParkingmeterDAO extends ModelCompanion[Parkingmeter, ObjectId] {
  val dao = new SalatDAO[Parkingmeter, ObjectId](collection = mongoCollection("parkingmeters")) {}
}

trait ParkingmeterJson {

  implicit val parkingmeterJsonWrite = new Writes[Parkingmeter] {
    def writes(p: Parkingmeter): JsValue = {
      obj(
        "id" -> p.id,
        "address" -> p.address,
        "zone" -> p.zone,
        "chargeTime" -> p.chargeTime,
        "maxParkingTime" -> p.maxParkingTime,
        "additionalPaymentMethod" -> p.additionalPaymentMethod,
        "lat" -> p.lat,
        "lng" -> p.lng
      )
    }
  }

}
