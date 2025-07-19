plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.shadow)
}

dependencies {
    implementation(project(":common"))
    compileOnly("com.velocitypowered:velocity-api:3.1.1")
    implementation(libs.hikaricp)
}
