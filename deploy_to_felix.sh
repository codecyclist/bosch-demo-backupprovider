#!/bin/bash

if [ $# -eq 0 ]
  then
    echo "Usage: $0 (gateway-ip)"
    exit -1
fi

curl --silent --fail -X POST \
    -F action=install \
    -F start=start \
    -F bundlestartlevel=6 \
    -F restartpackages=refresh \
    -F bundlefile=@"target/hc-backupprovider-minimaldemo-1.0-SNAPSHOT.jar"  http://$1/system/console/bundles > /dev/null

result=$?

if [ $result -eq 0 ];
then
    echo "Upload completed."
else
    echo "Unable to upload bundle to gateway."
    echo "Is the IP correct, and is the OSGi console installed?"
fi
