package elasticsearch

import com.dreams.model.parser.DreamModel
import com.sksamuel.elastic4s.ElasticClient
import com.sksamuel.elastic4s.ElasticDsl._
import com.sksamuel.elastic4s.mappings.FieldType.StringType
import org.elasticsearch.common.settings.Settings

/**
  * Created by Munish on 5/30/16.
  */
class ElasticCURD() {

   val settings = Settings.settingsBuilder()
    .put("http.enabled", false)
    .put("path.home", "/var/elastic/")

  val client = ElasticClient.transport("localhost:9300")

  def createMapping(): Unit ={

    client.execute {
      create index "dreams" mappings (
          "dream" as (
          "_id"       typed StringType ,
          "name"      typed StringType ,
          "dream"     typed StringType ,
          "sex"       typed StringType ,
          "origin"    typed StringType ,
          "latitude"  typed StringType ,
          "longitude" typed StringType ,
          "people"    typed StringType ,
          "places"    typed StringType ,
          "events"    typed StringType ,
          "objects"   typed StringType
          )
        )
    }

  }

  def indexADream( dream : DreamModel ): Unit = {

    client.execute {
      index into "dreams" / "dream" id dream.get_id() fields (
        "_id" -> dream.get_id(),
        "name" -> dream.getName(),
        "dream" -> dream.getDream(),
        "sex" -> dream.getSex(),
        "origin" -> dream.getOrigin(),
        "latitude" -> dream.getLatitude(),
        "longitude" -> dream.getLongitude(),
        "people" -> dream.getPeople(),
        "places" -> dream.getPlaces(),
        "events" -> dream.getEvents(),
        "objects" -> dream.getObjects()
        )
    }

  }

//  def insert( dream : DreamModel ): Unit = {
//    // await is a helper method to make this operation synchronous instead of async
//    // You would normally avoid doing this in a real program as it will block your thread
//
//    //    client.execute { index into "bands" / "artists" fields "name"->"coldplay" }.await
//
//    client.execute {
//      index into "places" / "cities" id 2 fields (
//        "name" -> "New York",
//        "country" -> "USA",
//        "continent" -> "North America",
//        "status" -> "Super Awesome"
//        )
//    }.await
//
//    // we need to wait until the index operation has been flushed by the server.
//    // this is an important point - when the index future completes, that doesn't mean that the doc
//    // is necessarily searchable. It simply means the server has processed your request and the doc is
//    // queued to be flushed to the indexes. Elasticsearch is eventually consistent.
//    // For this demo, we'll simply wait for 2 seconds (default refresh interval is 1 second).
//    Thread.sleep(2000)
//
//    // now we can search for the document we indexed earlier
//    val resp = client.execute { search in "bands" / "artists" query "coldplay" }.await
//    println(resp)
//
//  }

  def searchAll(): Unit = {
    val resp = client.execute { search in "bands" / "artists" query "coldplay" }.await
    println( resp )
  }

}
