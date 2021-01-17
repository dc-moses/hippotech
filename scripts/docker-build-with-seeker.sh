#!/bin/bash
cd front
./scripts/docker-build.sh
./scripts/docker-build-with-seeker.sh
cd ..
cd approval
./scripts/docker-build.sh
./scripts/docker-build-with-seeker.sh
cd ..
cd blog
./scripts/docker-build.sh
./scripts/docker-build-with-seeker.sh
cd ..