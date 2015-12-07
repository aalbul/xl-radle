package com.xebialabs.xlradle.domain

import com.xebialabs.xlradle.domain.dependencies.Dependencies
import com.xebialabs.xlradle.domain.repository.Repositories

/**
 * Created by nuru on 5/28/15.
 */
class BuildScript {
    private @Delegate Project project = new Project()
    private @Delegate Plugins plugins = new Plugins()
    Repositories repositories = new Repositories()
    Dependencies dependencies = new Dependencies()

    void repositories(@DelegatesTo(Repositories) Closure configure) {
        def repoClosure = configure.rehydrate(repositories, this, this)
        repoClosure.resolveStrategy = Closure.DELEGATE_ONLY
        repoClosure()
    }

    void dependencies(@DelegatesTo(Dependencies) Closure closure) {
        def depClosure = closure.rehydrate(dependencies, this, this)
        depClosure.resolveStrategy = Closure.DELEGATE_ONLY
        depClosure()
    }
}
