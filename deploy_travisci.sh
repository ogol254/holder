#!/bin/bash

set -e # exit with nonzero exit code if anything fails

cd build/distributions
git init

git config user.name "travis-ci"
git config user.email "email@email.co.ke"

git add .
git commit -m "Deploy Travis CI Build #${TRAVIS_BUILD_NUMBER} artifacts to GitHub"

git push --force --quiet "https://${GH_TOKEN}@${GH_REF}" \
  master:build-artifacts > /dev/null 2>&1