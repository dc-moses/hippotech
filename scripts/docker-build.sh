#!/bin/bash
cd front
./scripts/docker-build.sh
cd ..
cd approval
./scripts/docker-build.sh
cd ..
cd blog
./scripts/docker-build.sh
cd ..