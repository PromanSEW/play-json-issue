package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Prize;
import models.Tournament;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class RestControllerTest extends WithApplication {
    @Test
    public void testTours() {
        Prize first = new Prize(3000, 300, "rod", "Rod 1", 30);
        Prize second = new Prize(2000, 200, "rod", "Rod 2", 30);
        Prize third = new Prize(1000, 100, "rod", "Rod 3", 30);
        Tournament tournament = new Tournament();
        tournament.first = first;
        tournament.second = second;
        tournament.third = third;
        tournament.save();
        assertResult(route(app, fakeRequest().method(POST).uri("/ebean")));
        assertResult(route(app, fakeRequest().method(POST).uri("/play")));
    }

    private static void assertResult(Result result) {
        assertEquals(OK, result.status());
        String body = contentAsString(result);
        System.out.println(body);
        JsonNode json = Json.parse(body);
        assertNotNull(json);
        assertEquals(1, json.size());
        json = json.get(0).get("first");
        assertNotNull(json);
        json = json.get("name");
        assertNotNull(json);
        assertEquals("Rod 1", json.textValue());
    }
}
