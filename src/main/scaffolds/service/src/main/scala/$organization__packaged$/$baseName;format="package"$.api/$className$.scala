
package $organization$$baseName$.api

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.broker.Topic
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}
import io.metabookmarks.security.SecurityHeaderFilter
import play.api.libs.json._


object $className$ {
  val TOPIC_NAME = "$topic$"
}

trait $className$ extends Service {

    def aMethod: ServiceCall[BookmarkToCreate, Bookmark]

    def $topic$Topic(): Topic[BookmarkEvent]

    override def descriptor = {
        import Service._
        // @formatter:off
        named("$topic$")
          .withCalls(
            restCall(Method.POST, "/api/$topic$", aMethod),    
          )
          .withTopics(
            topic($className$.TOPIC_NAME, $topic$Topic _)
          )
          .withAutoAcl(true)
        // @formatter:on
    
      }  
}


trait 