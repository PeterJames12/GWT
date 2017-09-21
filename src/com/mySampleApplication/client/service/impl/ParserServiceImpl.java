package com.mySampleApplication.client.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mySampleApplication.client.model.Something;
import com.mySampleApplication.client.service.ParserService;

import java.io.IOException;

/**
 * @author Igor Hnes on 9/21/17.
 */
public class ParserServiceImpl implements ParserService {

    /**
     * {@inheritDoc}.
     */
    public String parseJsonByUrl(String url) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, Something.class).getUrl();
    }
}
