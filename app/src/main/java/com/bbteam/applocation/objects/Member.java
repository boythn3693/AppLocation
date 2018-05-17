package com.bbteam.applocation.objects;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Member {

    public String name;
    private String lastupdate;
    public double lat;
    public double lng;

    public Member() {}

    public Member(String name, String lastupdate, double lat, double lng) {
        this.name = name;
        this.lastupdate = lastupdate;
        this.lat = lat;
        this.lng = lng;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("lastupdate", lastupdate);
        result.put("lat", lat);
        result.put("lng", lng);
        return result;
    }
}
