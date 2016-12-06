package com.dwbook.phonebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created by davidnovogrodsky_wrk on 11/29/16.
 *
 * This class reads the config.yaml file and changes it into a POJO.
 * The @JsonProperty tells jackson what to parse from the yaml file.
 * The @NotBlank and @NotEmpty validates the values serialized by Jackson.
 *
 * To define default values, initialize the variables in this class.
 *
 */
public class PhonebookConfiguration extends Configuration {
    @JsonProperty
    @NotBlank
    private String message;

    @JsonProperty
    @NotNull
    @Max(10)
    private int messageRepetitions;


    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();


    public DataSourceFactory getDataSourceFactory() {
        return database;
    }




    public String getMessage() {
        return message;
    }

    public int getMessageRepetitions() {
        return messageRepetitions;
    }
}