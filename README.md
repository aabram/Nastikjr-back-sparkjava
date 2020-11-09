# Nastikjr-back-sparkjava

Nastikjr-back-sparkjava is backend for Nastik Jr.
Nastik Jr is English-Estonian dictionary, new version of an old [service](https://nastik.palat.ee/) from 2004.

Nastikjr-back-sparkjava is written in Java with [Spark Java](https://sparkjava.com/) (see Why? below) and contains only backend API server and database. There is React JS based frontend [available here](https://github.com/aabram/Nastikjr-front-reactjs), but you can write your own.

Demo of front + back-end: http://nastik.eatmorepancakes.com/

## Requirements

* Java version 11+
* Maven

## Quickstart

```
mvn package
```

This will produce fat jar with included dependencies

```
target/Nastikjr-sparkjava-{VERSION}-jar-with-dependencies.jar
```

where {VERSION} is the current version, for example 1.0.
Server can be started with

```
java -jar Nastikjr-sparkjava-1.0-jar-with-dependencies.jar
```

Server will start on port 9090, and API can be accessed on http://localhost:9090 or with fully qualified hostname if applicable.

## API endpoints

Only GET methods are available: 

- /en/exact/{word}
- /en/{word}
- /en/exact/{word}
- /et/{word}

Response type is _application/json_.

/en/exact/bear will return exact match for the english word „bear“ if there is one. It will not return partial matches, for example „bear cub“.

/en/bear will return all entries from the database which contain „bear“ in their English definition. This will include „polar bear“, „teddy bear“ etc, but NOT „bear“.

In order to get exact match and all partial matches two requests have to be made. This is design decision that may or may not change in future versions.

## Limitations and gotchas (aka TODO)

List of notable limitations and things to be aware of.

* No HTTPS. When using HTTPS frontend we’ll get mixed content warning.
* File-based log in [TSV](https://www.iana.org/assignments/media-types/text/tab-separated-values) format. No log rotation, size/entry limits, etc.
* No comprehensive input sanitization. May or may not fall over if you poke it hard enough.
* [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS) is enabled (for testing purposes and for public demo), so service may be exposed on the network or internet. 
* No pagination, some queries return loads of matches.
* No API versioning. Breaking changes may or may not be expected.

## Why?

**Why Spark Java and not Spring/Micronaut etc?**
First iteration was written in Spring Boot + Spring Data JPA + H2, but when it became apparent that since functionality-wise the application will stay very small for now then Spring Boot overhead did not seem justified. Spark Java + JDBC + SQLite gives fast startup and small memory footprint.

**Why SQLite?**
The database is read-only at the moment so performance will most likely be no issue with expected traffic. Nastik classic has been on SQLite database for 16 years and it has proven itself for projects of this size and scope. There are no benefits of using database server at this time. This may change in the future.