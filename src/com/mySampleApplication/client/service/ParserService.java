package com.mySampleApplication.client.service;

import com.mySampleApplication.client.model.Something;

import java.io.IOException;

/**
 * @author Igor Hnes on 9/21/17.
 */
public interface ParserService {

    /**
     * @return instance of {@link Something} by given url.
     */
    String parseJsonByUrl(String url) throws IOException;
}
