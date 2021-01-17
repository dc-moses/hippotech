#!/bin/bash
docker build -f Dockerfile-with-seeker -t hippotech-approval-with-seeker:latest --network docker-compose_default .