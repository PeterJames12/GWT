package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.mySampleApplication.client.service.ParserService;
import com.mySampleApplication.client.service.impl.ParserServiceImpl;

import java.io.IOException;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

    private static final String JSON_PATH = "https://api.nasa.gov/planetary/apod?api_key=NNKOjkoul8n1CH18TWA9gwngW1s1SmjESPjNoUFo ";

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();

        final Image image = new Image();

        final ParserService parserService = new ParserServiceImpl();
        String text = "";
        try {
            text = parserService.parseJsonByUrl(JSON_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String finalText = text;
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                image.setUrl(finalText);
            }
        });

        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
        RootPanel.get("slot3").add(image);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
