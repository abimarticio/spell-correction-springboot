# Spell Correction Spring Boot

## Overview

A Spring Boot application for spell correction that uses dictionary substitution method. The dictionary we use in this repository is from [Peter Norvig](https://norvig.com/ngrams/spell-errors.txt).

## Pre-requisites

This project has the following dependencies:

* Java JDK 11
* Spring Boot 2.3.4

## Usage

In this repository, we implement the spell correction that uses dictionary substitution method. To use this, we have the `/spell-correction` view function that accepts request parameter `text`.

To run this app, we can use Maven:

```buildoutcfg
$ ./mvnw spring-boot:run
```

We can call our API in Python in the following manner,

```python
>>> import requests
>>> r = requests.get("http://localhost:8080/spell-correction?text=raning")
>>> r.status_code
200
>>> r.text
'raining'
>>> r = requests.get("http://localhost:8080/spell-correction?text=agresion")
>>> r.text
'aggression'
>>> r = requests.get("http://localhost:8080/spell-correction?text=canned")
>>> r.text
'caned'
```

We can call out API using `curl` command in the following manner,

```buildoutcfg
$ curl -s -X GET "localhost:8080/spell-correction?text=raning"
raining
$ curl -s -X GET "localhost:8080/spell-correction?text=agresion"
aggression
$ curl -s -X GET "localhost:8080/spell-correction?text=canned"
caned
```