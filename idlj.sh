#!/bin/bash

rm -rf src/main/generated_java/com/example/democorba/service
idlj -fall -td src/main/generated_java src/main/resources/GreetingService.idl
