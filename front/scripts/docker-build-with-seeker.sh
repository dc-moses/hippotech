#!/bin/bash
docker build -f Dockerfile-with-seeker -t hippotech-front-with-seeker:latest --network docker-compose_default .