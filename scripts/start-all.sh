#!/bin/bash

blogOutput=$(mktemp "${TMPDIR:-/tmp/}$(basename 0).XXX")
approvalOutput=$(mktemp "${TMPDIR:-/tmp/}$(basename 0).XXX")
frontOutput=$(mktemp "${TMPDIR:-/tmp/}$(basename 0).XXX")
echo Blog $blogOutput
echo Approval $approvalOutput
echo Front $frontOutput

#cd blog
#./scripts/start.sh  &> $blogOutput &
#cd ..

/approval/scripts/start.sh  &> $approvalOutput &

#cd front
#./scripts/start.sh  &> $frontOutput &
#cd ..

#until grep -q -i 'blog back-end is running' $blogOutput
#do
#  echo -n "."
#  sleep 1
#done

until grep -q -i 'approval back-end is running' $approvalOutput
do
  echo -n "."
  sleep 1
done

##until grep -q -i 'front-end is running' $frontOutput
#do
#  echo -n "."
#  sleep 1
#done

echo "HippoTech system is up and running."
