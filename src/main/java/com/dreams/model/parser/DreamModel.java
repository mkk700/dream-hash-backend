package com.dreams.model.parser;

/**
 * Created by Munish on 5/30/16.
 */
public class DreamModel {

    private String _id;
    private String name;
    private String dream;
    private String sex;
    private String origin;
    private double latitude;
    private double longitude;
    private String[] people;
    private String[] places;
    private String[] events;
    private String[] objects;


    public DreamModel(String _id, String name, String dream, String sex, String origin, double latitude, double longitude, String[] people, String[] places, String[] events, String[] objects) {

        this._id = _id;
        this.name = name;
        this.dream = dream;
        this.sex = sex;
        this.origin = origin;
        this.latitude = latitude;
        this.longitude = longitude;
        this.people = people;
        this.places = places;
        this.events = events;
        this.objects = objects;

    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getDream() {
        return dream;
    }

    public String getSex() {
        return sex;
    }

    public String getOrigin() {
        return origin;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String[] getPeople() {
        return people;
    }

    public String[] getPlaces() {
        return places;
    }

    public String[] getEvents() {
        return events;
    }

    public String[] getObjects() {
        return objects;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDream(String dream) {
        this.dream = dream;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setPeople(String[] people) {
        this.people = people;
    }

    public void setPlaces(String[] places) {
        this.places = places;
    }

    public void setEvents(String[] events) {
        this.events = events;
    }

    public void setObjects(String[] objects) {
        this.objects = objects;
    }

}
