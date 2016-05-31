package com.dreams.model.parser;

/**
 * Created by Munish on 5/30/16.
 */


import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFromFile {

    private String filename;
    private File file;
    private StringBuffer sb;
    public DreamModel[] dreamModels;

    private JSONArray jsonArray = null;

    public ReadJSONFromFile( String filename ) {
        this.filename = filename;

        ClassLoader classLoader = getClass().getClassLoader();
        this.file = new File( classLoader.getResource( this.filename ).getFile() );

        // Todo don't put this code in the constructor
        this.readFile();
        this.processJSON();
        this.createDreamModels();
    }

    public void readFile() {

        FileInputStream fileInputStream = null;

        this.sb = new StringBuffer();

        try{

            fileInputStream=new FileInputStream( this.file );
            int i;

            while((i=fileInputStream.read())!=-1)
                sb.append((char)i);

        }
        catch(Exception e){
            System.out.println( e.toString() );
        }
        finally{

            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            System.out.println(  sb.toString() );
        }

        System.out.println( "done reading json file ");

    }

    public void processJSON(){

        JSONParser parser = new JSONParser();
        try {
            jsonArray= (JSONArray) parser.parse( this.sb.toString() );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println( "done parsing josn string into json Array" );

    }

    public void createDreamModels() {

        dreamModels = new DreamModel[ jsonArray.size() ];

        for( int i=0; i < jsonArray.size(); i++) {
            JSONObject aJsonObj = (JSONObject) jsonArray.get(i);

            String _id = (String) aJsonObj.get("_id");
            String name = (String) aJsonObj.get("name");
            String dream = (String) aJsonObj.get("dream");
            String sex = (String) aJsonObj.get("sex");
            String origin = (String) aJsonObj.get("origin");

            Double  latitude  =  (Double) aJsonObj.get("latitude");
            Double  longitude  = (Double) aJsonObj.get("longitude");


            JSONArray jpeople  = (JSONArray) aJsonObj.get("people");
            String people[] = new String[ jpeople.size() ];
            for( int j=0; j < jpeople.size(); j++ )
                people[j] = (String) jpeople.get(j);

            JSONArray jplaces  = (JSONArray) aJsonObj.get("places");
            String places[] = new String[ jplaces.size() ];
            for( int j=0; j < jplaces.size(); j++ )
                places[j] = (String) jplaces.get(j);

            JSONArray jevents  = (JSONArray) aJsonObj.get("events");
            String events[] = new String[ jevents.size() ];
            for( int j=0; j<jevents.size(); j++ )
                events[j] = (String) jevents.get(j);


            JSONArray jobjects  = (JSONArray) aJsonObj.get("objects");
            String objects[] = new String[ jobjects.size() ];
            for( int j=0; j<jobjects.size(); j++ )
                objects[j] = (String) jobjects.get(j);


            dreamModels[i] = new DreamModel( _id, name, dream, sex, origin, latitude, longitude, people, places, events, objects);
        }
        System.out.println( "done creating dream models ");
    }

    public DreamModel[] getDreamModels() {
        return dreamModels;
    }

    public static void main(String[] args) {
        ReadJSONFromFile rjfl = new ReadJSONFromFile("dreams.json");
    }

}
