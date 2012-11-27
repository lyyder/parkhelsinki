package models

case class Parkingmeter (
  id: String,
  address: String,
  zone: Int,
  chargeTime: String,
  maxParkingTime: String,
  additionalPaymentMethod: String,
  lat: Double,
  lng: Double
)


