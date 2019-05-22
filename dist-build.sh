#!/bin/sh

./gradlew clean build fatJar createApp bundleJRE createAppZip createDmg
./gradlew assembleDist -p restclient-ui
