#!/bin/bash
set -e 
set -o pipefail

. /etc/profile.d/codio-xserver.sh

$1 $2
nohup $3 $4 $5 $6 &> /dev/null &