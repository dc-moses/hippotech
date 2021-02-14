#!/bin/bash
docker build -f Dockerfile-with-seeker -t demo:latest --network docker-compose_default .