package io

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.mockito.MockitoSugar._
import sttp.client.{Identity, Response}
import org.mockito.ArgumentMatchers
import sttp.model.StatusCode

class Reader_UnitTest extends AnyFunSuite with Matchers {

  test("Program flow should execute as expected") {
    val requestSender = mock[RequestSender]
    val otherWayToMock = new Requester[Seq[String],Responsey]{
      override def get(options: Seq[String]): Responsey = Response(Right(""),StatusCode.Ok)} {}
    val reader = new Reader(requestSender)



    val x: Either[String,String] = Right("")

    when(requestSender.get(Seq("", "&tag=_untagged_"))).thenReturn(Response(Right(""),StatusCode.Ok))
    //when(mockRequestResponse.body.flatMap(_: Either[String, String])).thenReturn(ArgumentMatchers.any[Either[String, String]] => ArgumentMatchers.anyString)

    reader.read(Some("_untagged_"))

    verify(requestSender, times(1)).get(Seq("", "&tag=_untagged_"))
  }
}
