package controllers

import play.api._
import play.api.mvc._

object Api extends Controller {
  
  def parkingmeter = Action {
    Ok("parkingmeter")
  }
  
}
