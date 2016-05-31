package com.test.code

import com.dreams.model.parser.ReadJSONFromFile
import com.dreams.model.parser.DreamModel
import elasticsearch.ElasticCURD

/**
  * Created by Munish on 5/30/16.
  */
object ProcessDreams {

  def main(args: Array[String]) {

    val dms =  new ReadJSONFromFile("dreams.json").getDreamModels()

    val es = new ElasticCURD
//    es.createMapping()
//
//    for( dm <- dms ) {
//      es.indexADream( dm )
//    }

    es.searchAll()


  }

}


