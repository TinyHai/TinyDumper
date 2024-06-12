#!/bin/bash

set -x

PWD=$(pwd)

APK_PATH=$PWD/app/build/outputs/apk/release

./gradlew assembleRelease

if [[ $? -ne 0 ]]; then
    exit $?
fi

adb connect 192.168.31.156:6666
adb install $APK_PATH/*.apk