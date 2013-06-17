package models

import play.api.Play.current
import com.novus.salat.dao._
import com.novus.salat.annotations._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import play.api.libs.json._
import play.api.libs.json.Json._
import mongoContext._

case class Parkingmeter (
  @Key("_id") id: String,
  address: String,
  zone: String,
  chargeTime: String,
  maxParkingTime: String,
  additionalPaymentMethod: String,
  loc : Location
)

case class Location (@Key("type") locationType: String, coordinates: List[Double])

object Parkingmeter extends ParkingmeterDAO with ParkingmeterJson

trait ParkingmeterDAO extends ModelCompanion[Parkingmeter, String] {
  val dao = new SalatDAO[Parkingmeter, String](collection = mongoCollection("parkingmeters")) {}
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
        "lng" -> p.loc.coordinates(0),
        "lat" -> p.loc.coordinates(1)
      )
    }
  }
}
