#!/bin/bash
DOCKER_BUILDKIT=0 DOCKER_BUILDKIT=0 docker build -f Dockerfile-with-seeker -t hippotech-front-with-seeker:latest --network docker-compose_default .
