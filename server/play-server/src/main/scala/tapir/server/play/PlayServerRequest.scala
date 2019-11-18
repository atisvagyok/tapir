package tapir.server.play

import java.net.URI

import play.api.mvc.RequestHeader
import tapir.model.{ConnectionInfo, Method, ServerRequest}

private[play] class PlayServerRequest(request: RequestHeader) extends ServerRequest {

  override def method: Method = Method(request.method.toUpperCase)
  override def protocol: String = request.version
  override def uri: URI = new URI(request.uri)
  override def connectionInfo: ConnectionInfo = ConnectionInfo(None, None, None)
  override def headers: Seq[(String, String)] = request.headers.headers
  override def header(name: String): Option[String] = request.headers.get(name)
}