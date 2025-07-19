plugins {
    `java-library`
}

allprojects {
    repositories {
        mavenCentral()
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://repo.velocitypowered.com/releases")
    }
}

val projectPrefix = "ShardLink"

subprojects {
    apply(plugin = "java-library")

    version = "1.0.0"

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(21)
    }

    tasks.withType<Jar> {
        archiveBaseName.set("$projectPrefix-${project.name}")
        archiveVersion.set(project.version.toString())
        archiveClassifier.set("")
        manifest {
            attributes(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            )
        }
    }
}



