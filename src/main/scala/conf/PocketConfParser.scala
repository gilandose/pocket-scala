package conf

import com.typesafe.config.{Config, ConfigFactory}

object PocketConfParser {
  def parse: PocketConf = {

    val config: Config = ConfigFactory.load("pocket.conf")

    val consumerKey = config.getString("consumerKey")
    val accessToken = config.getString("accessToken")

    PocketConf(consumerKey, accessToken)
  }
}

case class PocketConf(consumerKey: String, accessToken: String)
