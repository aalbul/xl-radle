package com.xebialabs.xlradle.domain.dependencies

/**
 * Created by aalbul on 07/12/15.
 */
class Dependencies {
    Map<DependencyScope, List<Dependency>> dependencies = new HashMap<>()

    void compile(params) { addDependency(DependencyScope.COMPILE, params) }
    void testCompile(params) { addDependency(DependencyScope.TEST_COMPILE, params) }

    private void addDependency(DependencyScope scope, params) {
        Dependency dependency = null

        if (params instanceof Map) {
            dependency = params as Dependency
        } else if (params instanceof String) {
            def split = params.split(":")
            dependency = [groupId: split[0], artifactId: split[1], version: split[2]]
        }

        if (dependency) {
            def list = dependencies.getOrDefault(scope, new ArrayList<Dependency>())
            list.add(dependency)
            dependencies.put(scope, list)
        }
    }
}
