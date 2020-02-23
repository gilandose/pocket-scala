import sttp.client.{Identity, Response}

package object io {

  type Responsey = Identity[Response[Either[String, String]]]

}
