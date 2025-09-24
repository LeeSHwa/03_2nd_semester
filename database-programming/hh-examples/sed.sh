#!/usr/bin/bash

sed -i -e '/org.springframework.boot/ s/latest.release/3.5.5/g' **/settings.gradle

sed -i -e '/org.springframework.boot/ s/3.5.5/latest.release/g' **/settings.gradle
