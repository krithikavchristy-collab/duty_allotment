#!/usr/bin/env bash
set -euo pipefail

NEW_VERSION="${1:?Usage: set-maven-version.sh <version>}"

mvn -B -DskipTests versions:set -DnewVersion="${NEW_VERSION}" -DgenerateBackupPoms=false