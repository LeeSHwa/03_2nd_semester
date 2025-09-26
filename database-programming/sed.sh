#!/usr/bin/bash

sed -i -e '/org.springframework.boot/ s/latest.release/3.5.5/g' **/settings.gradle

