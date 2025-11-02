#!/bin/bash
# Script helper para executar Maven com Java 21

export JAVA_HOME=$(/usr/libexec/java_home -v 21)

mvn -s .mvn/settings.xml "$@"
