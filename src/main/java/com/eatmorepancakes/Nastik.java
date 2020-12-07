package com.eatmorepancakes;

import spark.Spark;

import static spark.Spark.*;

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

        get("/api/v1/en/:word", "application/json", (req, res) ->
                WordService.getWordEN(req.params(":word")), new JsonTransformer());

        get("/api/v1/en/exact/:word", "application/json", (req, res) ->
                WordService.getExactWordEN(req.params(":word")), new JsonTransformer());

        get("/api/v1/et/:word", "text", (req, res) ->
                WordService.getWordET(req.params(":word")), new JsonTransformer());

        get("/api/v1/et/exact/:word", "application/json", (req, res) ->
                WordService.getExactWordET(req.params(":word")), new JsonTransformer());

        // For checking whether service is alive
        get("/api/v1/ping", (req, res) -> {
                    res.type("application/json");
                    return "{\"message\":\"It's alive!\"}";
                });

        notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Endpoint not available\"}";
        });
    }
}
