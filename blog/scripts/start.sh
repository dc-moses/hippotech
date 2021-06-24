#!/bin/bash

# Uncomment to add Seeker
#export SEEKER_SERVER_URL=http://seeker-server:8080
#export SEEKER_PROJECT_KEY=BLOG  
#export SEEKER_AGENT_NAME=Blog
#npm install --strict-ssl=false --prefix seeker "http://seeker-server:8080/rest/api/latest/installers/agents/binaries/NODEJS?projectKey=BLOG&flavor=TARGZ"

echo "Starting HippoTech blog backend..."

output=$(mktemp "${TMPDIR:-/tmp/}$(basename 0).XXX")

echo $output

npm start  &> $output &
server_pid=$!
echo "Server pid: $server_pid"
echo "Output: $output"
echo "Wait:"
until grep -q -i 'Blog Backend is listening' $output
do
  if ! ps $server_pid > /dev/null
  then
    echo "The server died" >&2
    exit 1
  fi
  echo -n "."
  sleep 1
done
echo
echo "HippoTech blog back-end is running."
