package models

import play.api.Play.current
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import mongoContext._

case class Parkingmeter (
  id: ObjectId = new ObjectId,
  parkingmeterId: String,
  address: String,
  zone: Int,
  chargeTime: String,
  maxParkingTime: String,
  additionalPaymentMethod: String,
  lat: Double,
  lng: Double
)

object Parkingmeter extends ModelCompanion[Parkingmeter, ObjectId] {
  val dao = new SalatDAO[Parkingmeter, ObjectId](collection = mongoCollection("parkingmeters")) {}
}
