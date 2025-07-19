plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.shadow)
    alias(libs.plugins.run.paper)
}

dependencies {
    implementation(project(":common"))
    compileOnly(libs.paper.api)
    compileOnly(libs.commandapi)
    compileOnly(libs.configlib.yaml)
    compileOnly(libs.configlib.paper)
    implementation(libs.hikaricp)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand(
            "version" to project.version,
            "configlibVersion" to libs.versions.configlib.get()
        )
    }
}


tasks {
    val version = "1.21.4"
    val javaVersion = JavaLanguageVersion.of(21)

    val jvmArgsExternal = listOf(
        "-Dcom.mojang.eula.agree=true"
    )

    runServer {
        minecraftVersion(version)
        runDirectory = rootDir.resolve("run/paper/$version")

        javaLauncher = project.javaToolchains.launcherFor {
            languageVersion = javaVersion
        }

        downloadPlugins {
            url("https://github.com/CommandAPI/CommandAPI/releases/download/10.0.1/CommandAPI-10.0.1.jar")
            url("https://github.com/EssentialsX/Essentials/releases/download/2.21.1/EssentialsX-2.21.1.jar")
            url("https://download.luckperms.net/1587/bukkit/loader/LuckPerms-Bukkit-5.5.2.jar")
            url("https://ci.lucko.me/job/spark/487/artifact/spark-bukkit/build/libs/spark-1.10.138-bukkit.jar")
            url("https://hangarcdn.papermc.io/plugins/ViaVersion/ViaBackwards/versions/5.3.2/PAPER/ViaBackwards-5.3.2.jar")
            url("https://hangarcdn.papermc.io/plugins/ViaVersion/ViaVersion/versions/5.3.2/PAPER/ViaVersion-5.3.2.jar")
        }

        jvmArgs = jvmArgsExternal
    }
}



