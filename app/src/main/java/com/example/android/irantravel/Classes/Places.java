package com.example.android.irantravel.Classes;

import android.content.Context;

import com.orm.SugarRecord;

/**
 * Created by meno on 12/12/2017.
 */

public class Places extends SugarRecord<Places> {
    Long ID;
    String name;
    String number;
    String address;
    String type;
    String map;
    String website;
    String wiki;
    String city;
    String category;
    String description;
    String image_1;
    String image_2;
    String image_3;
    String image_4;


    public Places(){

    }

    public Places(Long ID,String Name,String number,String address,String description,String type,String map,String website,String city,String wiki,String category,String image_1,String image_2,String image_3,String image_4){
        this.ID = ID;
        this.name = Name;
        this.number = number;
        this.address = address;
        this.description = description;
        this.type = type;
        this.map = map;
        this. website = website;
        this.city = city;
        this.wiki = wiki;
        this.category = category;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.image_4 = image_4;

    }

    public String getName() {
        return name;
    }

    public  String   getnumber() {
        return number;
    }

    public  String getAddress() {
        return address;
    }

    public  String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getMap() {
        return map;
    }

    public String getWebsite() {
        return website;
    }

    public String getWiki() {
        return wiki;
    }

    public String getCity() {
        return city;
    }

    public String getCategory() {
        return category;
    }

    public String getImage_1() {
        return image_1;
    }

    public String getImage_2() {
        return image_2;
    }

    public String getImage_3() {
        return image_3;
    }

    public String getImage_4() {
        return image_4;
    }
}
