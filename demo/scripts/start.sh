#!/bin/bash

echo "Starting Demo..."
output=$(mktemp "${TMPDIR:-/tmp/}$(basename 0).XXX")
java $JAVA_OPTS -jar ./target/demo.jar  &> $output &
server_pid=$!
echo "Server pid: $server_pid"
echo "Output: $output"
echo "Wait:"
until grep -q -i 'Started DemoApplication' $output
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
echo "Demo is running."
