plugins {
    base
}

tasks {

    val install by register<Exec>("install") {
        inputs.file(file("$projectDir/yarn.lock"))
        inputs.file(file("$projectDir/package.json"))
        outputs.dir(file("$projectDir/node_modules"))
        commandLine("yarn", "install")
    }

    val test by register<Exec>("test") {
        dependsOn(install)
        commandLine("yarn", "test", "--watchAll=false")
    }

    register<Exec>("buildFrontend") {
        dependsOn(install)
        mustRunAfter(test)
        inputs.dir(file("$projectDir/src"))
        inputs.dir(file("$projectDir/public"))
        outputs.dir(buildDir)
        commandLine("yarn", "build")
    }
}
