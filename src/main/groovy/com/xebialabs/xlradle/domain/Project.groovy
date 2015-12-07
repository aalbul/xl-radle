package com.xebialabs.xlradle.domain

/**
 * Created by aalbul on 07/12/15.
 */
class Project {
    String group
    Object version

    void group(String group) {
        this.group = group
    }

    void version(String version) {
        this.version = version
    }
}
