package controllers;

import models.Tour;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class RestController extends Controller {

    public Result tours() {
        // com.fasterxml.jackson.databind.JsonMappingException: Infinite recursion (StackOverflowError)
        return ok(Json.toJson(Tour.getTours()));
    }
}
