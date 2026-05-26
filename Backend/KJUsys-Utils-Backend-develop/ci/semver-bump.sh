#!/usr/bin/env bash
set -euo pipefail

# Outputs: major | minor | patch
# Rules:
# - major: feat!: or BREAKING CHANGE:
# - minor: feat:
# - patch: fix:
# - default: patch

LAST_TAG="${1:-}"

if [[ -z "${LAST_TAG}" ]]; then
  RANGE=""
else
  RANGE="${LAST_TAG}..HEAD"
fi

# Get commit messages (subject+body) since last tag, excluding CI skip commits
LOG="$(git log ${RANGE} --pretty=%B | grep -Ev '\\[(skip ci|ci skip)\\]' || true)"

# Normalize to lowercase-ish checks where useful (breaking change is case-sensitive in CC, but people vary)
if echo "${LOG}" | grep -Eq '(^feat!:\s)|(^.*BREAKING CHANGE:)|(^.*BREAKING-CHANGE:)' ; then
  echo "major"
  exit 0
fi

if echo "${LOG}" | grep -Eq '(^feat:\s)' ; then
  echo "minor"
  exit 0
fi

if echo "${LOG}" | grep -Eq '(^fix:\s)' ; then
  echo "patch"
  exit 0
fi

# Force patch if no match
echo "patch"