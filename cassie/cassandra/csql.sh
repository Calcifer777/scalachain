#!/bin/bash - 
#===============================================================================
#
#          FILE: csql.sh
# 
#         USAGE: ./csql.sh 
# 
#   DESCRIPTION: 
# 
#       OPTIONS: ---
#  REQUIREMENTS: ---
#          BUGS: ---
#         NOTES: ---
#        AUTHOR: Marco Filippone, 
#  ORGANIZATION: 
#       CREATED: 07/18/2020 11:32
#      REVISION:  ---
#===============================================================================

set -o nounset                              # Treat unset variables as an error

docker exec -it cassandra0 cqlsh


