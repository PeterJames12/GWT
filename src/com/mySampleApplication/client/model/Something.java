package com.mySampleApplication.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author Igor Hnes on 9/21/17.
 */
public class Something {

    @Getter
    @JsonProperty("url")
    private String url;
}
