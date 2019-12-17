package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Tour;
import models.TourType;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Http.RequestBuilder;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class RestControllerTest extends WithApplication {
    @Test
    public void testTours() {
        TourType type = new TourType();
        type.name = "Test";
        type.description = "Test description";
        type.save();
        Tour tour = new Tour();
        tour.tourtype = type;
        tour.save();
        RequestBuilder request = fakeRequest().method(POST).uri("/tours");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        JsonNode json = Json.parse(contentAsString(result));
        assertNotNull(json);
        assertEquals(1, json.size());
        json = json.get(0).get("tourtype");
        assertNotNull(json);
        assertEquals("Test", json.get("name").textValue());
    }
}
