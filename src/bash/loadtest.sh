#!/bin/bash 
date
COUNTER=0
while [  $COUNTER -lt 10 ]; do
 echo The counter is $COUNTER
 let COUNTER=COUNTER+1 
 time wget  http://site.paneris.net
done
echo The counter is $COUNTER
date         