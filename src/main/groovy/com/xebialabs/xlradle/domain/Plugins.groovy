package com.xebialabs.xlradle.domain

/**
 * Created by aalbul on 07/12/15.
 */
class Plugins {
    List<String> plugins = new ArrayList<>()

    void apply(Map<String, String> pluginParams) {
        if (pluginParams.containsKey("plugin")) {
            plugins.add(pluginParams.get("plugin"))
        }
    }
}
