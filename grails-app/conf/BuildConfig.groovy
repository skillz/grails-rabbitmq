grails.project.work.dir = 'target/work'
grails.project.class.dir = 'target/classes'
grails.project.test.class.dir = 'target/test-classes'
grails.project.test.reports.dir = 'target/test-reports'

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits('global') {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        mavenRepo name: 'Skillz Nexus Grails Repository', url: 'http://nexus.skillz.com/content/groups/grails'
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        build 'org.springframework:spring-context:3.2.9.RELEASE'

        runtime ('org.springframework.amqp:spring-rabbit:1.1.3.RELEASE') {
            excludes 'junit',
                     'spring-aop',
                     'spring-core', // Use spring-core from Grails.
                     'spring-oxm',
                     'spring-test',
                     'spring-tx',
                     'slf4j-log4j12',
                     'log4j'
        }

        runtime "org.springframework.retry:spring-retry:1.0.0.RELEASE"
    }

    plugins {
        build (':release:3.0.1', ':rest-client-builder:1.0.3') {
            export = false
        }
    }
}

grails.project.repos.releases.url = 'http://nexus.skillz.com/content/repositories/releases/'
grails.project.repos.default = 'releases'
grails.release.scm.enabled = false
