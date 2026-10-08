#!/bin/sh
DOCKERFILE="$1"
THRESHOLD="$2"

hadolint --no-fail "$DOCKERFILE" > /tmp/report.txt
cat /tmp/report.txt
echo "findings=$(wc -l < /tmp/report.txt | tr -d ' ')" >> "$GITHUB_OUTPUT"
hadolint --failure-threshold "$THRESHOLD" "$DOCKERFILE" > /dev/null