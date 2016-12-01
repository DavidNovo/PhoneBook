package com.dwbook.phonebook.api;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by davidnovogrodsky_wrk on 11/30/16.
 */
public class Contact {

    private int id = 0;
    private String firstName = null;
    private String lastName = null;
    private String phone = null;

    // to make class immutable, empty default constructor
    public Contact() {

    }

    public Contact(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    // now to make this object be serialized/deserialize
    @JsonProperty
    public int getId(){
        return this.id;
    }

    @JsonProperty
    public String getFirstName(){
        return this.firstName;
    }

    @JsonProperty
    public String getLastName(){
        return this.lastName;
    }

    @JsonProperty
    public String phone() {
        return this.phone;
    }


}

