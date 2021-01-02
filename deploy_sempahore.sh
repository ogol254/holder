#!/bin/bash

set -e

cd build/distributions
git init

git config user.name "semaphore"
git config user.email "${COMMIT_AUTHOR_EMAIL}"

git add .
git commit -m "Deploying Semaphore Build #${SEMAPHORE_BUILD_NUMBER} artifacts to GitHub"

git push --force --quiet "https://${GH_TOKEN}@${GH_REF}" \
  master:build-artifacts > /dev/null 2>&1