package controllers;

import models.Tour;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class RestController extends Controller {

    public Result tours() {
        return ok(Json.toJson(Tour.getTours()));
    }
}
