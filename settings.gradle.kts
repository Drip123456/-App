pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
include(":chapter03")
include(":chapter04")
include(":chapter06")
include(":chapter_test")
include(":mysql")
include(":sql2")
include(":cloud")
include(":personwork")
