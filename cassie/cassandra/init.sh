#!/bin/bash - 
#===============================================================================
#
#          FILE: init.sh
# 
#         USAGE: ./init.sh 
# 
#   DESCRIPTION: 
# 
#       OPTIONS: ---
#  REQUIREMENTS: ---
#          BUGS: ---
#         NOTES: ---
#        AUTHOR: YOUR NAME (), 
#  ORGANIZATION: 
#       CREATED: 07/18/2020 11:24
#      REVISION:  ---
#===============================================================================

set -o nounset                              # Treat unset variables as an error

docker-compose -f cassie-compose.yaml --remove-orphans up 

docker exec cassandra0 nodetool status


