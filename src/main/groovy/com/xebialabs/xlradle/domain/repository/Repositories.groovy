package com.xebialabs.xlradle.domain.repository

/**
 * Created by nuru on 5/28/15.
 */
class Repositories {
    List<Repository> repositories = new ArrayList<>()

    def maven(@DelegatesTo(Repository) Closure closure) {
        def repository = new Repository()
        def repoClosure = closure.rehydrate(repository, this, this)
        repoClosure.resolveStrategy = Closure.DELEGATE_ONLY
        repoClosure()
        repositories.add(repository)
    }

    def mavenCentral() {
        maven {
            name "Maven Central"
            url "https://repo1.maven.org/maven2"
        }
    }
}
