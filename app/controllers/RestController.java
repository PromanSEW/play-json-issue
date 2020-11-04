package controllers;

import io.ebean.DB;
import models.Tournament;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class RestController extends Controller {
    public Result toursEbean() {
        return ok(DB.json().toJson(Tournament.getTours()));
    }

    public Result toursPlay() {
        return ok(Json.toJson(Tournament.getTours()));
    }
}
