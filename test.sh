#!/bin/bash

METHODS="$1"

if [[ -z "$METHODS" ]]; then
	METHODS="hardcoded scannotation reflections reflections2 corn classindex"
fi

for METHOD in $METHODS; do
	echo "Method: $METHOD"
	/usr/bin/time --format '%E' /usr/java/jdk1.8.0/bin/java -jar target/benchmark-1.0-SNAPSHOT.jar $METHOD
done
