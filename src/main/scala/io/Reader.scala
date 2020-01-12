package io

import conf.PocketConf
import sttp.client._

class Reader(
              consumerKey: String,
              accessToken: String
            ) {

  def read: Unit = {

    val request = basicRequest.get(
      uri"https://getpocket.com/v3/get?consumer_key=$consumerKey&access_token=$accessToken")

    request.header("Content-Type", "application/json")

    implicit val backend: SttpBackend[Identity, Nothing, NothingT] = HttpURLConnectionBackend()
    val response = request.send()

    // response.header(...): Option[String]
    println(response.header("Content-Length"))

    // response.unsafeBody: by default read into a String
    println(response)
  }

}

object Reader {
  def apply(conf: PocketConf): Reader = {
    new Reader(conf.consumerKey, conf.accessToken)
  }
}
