#!/bin/bash

MY_PATH="`dirname \"$0\"`"              # relative
MY_PATH="`( cd \"$MY_PATH\" && pwd )`"  # absolutized and normalized
if [ -z "$MY_PATH" ] ; then
  # error; for some reason, the path is not accessible
  # to the script (e.g. permissions re-evaled after suid)
  exit 1  # fail
fi

java -cp $MY_PATH/modules/wso2jsonmerger/target/wso2jsonmerger-1.5.7-SNAPSHOT.jar org.wso2jsonmerger.App
