package com.eatmorepancakes;

import spark.Spark;

import static spark.Spark.get;
import static spark.Spark.port;

public class Nastik {


    public static void main(String[] args) {
        port(9090);

        // CORS for Spark
        Spark.options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        Spark.before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/en/:word", "application/json", (req, res) ->
                WordService.getWordEN(req.params(":word")), new JsonTransformer());

        get("/en/exact/:word", "application/json", (req, res) ->
                WordService.getExactWordEN(req.params(":word")), new JsonTransformer());

        get("/et/:word", "application/json", (req, res) ->
                WordService.getWordET(req.params(":word")), new JsonTransformer());

        get("/et/exact/:word", "application/json", (req, res) ->
                WordService.getExactWordET(req.params(":word")), new JsonTransformer());
    }
}
