#!/bin/bash
cd approval
mvn package
cd ..

cd blog
npm install
cd ..

cd front
mvn package
cd ..
