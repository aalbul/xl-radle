package com.xebialabs.xlradle

import com.xebialabs.xlradle.domain.BuildScript

def buildScript(@DelegatesTo(BuildScript) Closure closure) {
    def script = new BuildScript()
    script.with(closure)
    println(script)
}

buildScript {
    apply plugin: 'java'
    apply plugin: 'groovy'

    group "com.xebialabs.gradle"
    version "1.5"

    repositories {
        maven {
            name "Local"
            url "http://localhost"
        }
        mavenCentral()
    }

    dependencies {
        compile groupId: "org.apache.commons", artifactId: "commons-lang3", version: "3.4"
        compile "org.codehaus.groovy:groovy-all:2.4.5"
        testCompile "org.testng:testng:6.9.9"
    }
}
