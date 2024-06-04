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

rootProject.name = "HiltMemoryAnalyze"
include(":app")
include(":menual")
include(":hilt-singleton")
//include(":ui")
include(":hilt-componenttree")
include(":tts")
include(":graffiti")
