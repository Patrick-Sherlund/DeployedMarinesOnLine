import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "${project.properties["semver"]}-${project.properties["build"]}"

extra["mockKVersion"] = "1.12.1"
extra["springMockKVersion"] = "3.1.0"

plugins {
	val kotlinVersion = "1.7.10"

	id("org.springframework.boot") version "3.0.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	kotlin("jvm") version kotlinVersion
	kotlin("kapt") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	jacoco
}

java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.postgresql:postgresql")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.session:spring-session-core")
	implementation("org.flywaydb:flyway-core")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("io.mockk:mockk:${property("mockKVersion")}")
	testImplementation("com.ninja-squad:springmockk:${property("springMockKVersion")}")

	kapt("org.springframework.boot:spring-boot-configuration-processor")
}



configurations.all {
	exclude(group = "org.apache.logging.log4j")

}

tasks {
	val jacocoTestReport = withType<JacocoReport> {
		reports {
			xml.isEnabled = true
		}
	}

	withType<Test> {
		useJUnitPlatform()

		testLogging {
			exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
			events(org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED, org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED, org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED)
		}

		finalizedBy(jacocoTestReport)
	}

	val copyFrontend by register<Sync>("copyFrontend") {
		dependsOn(":frontend:buildFrontend")
		from(project(":frontend").buildDir)
		into(file("$buildDir/resources/main/static"))
		doLast {
			println("copied built frontend to static resources")
		}
	}

	withType<org.springframework.boot.gradle.plugin.ResolveMainClassName> {
		dependsOn(copyFrontend)
	}

	withType<org.springframework.boot.gradle.tasks.run.BootRun> {
		environment("spring.output.ansi.console-available", true)
	}

	withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
		archiveBaseName.set("DMOL")
	}

	// disable plain jar - prior to spring-boot 2.5.0 this was disabled by default
	getByName<Jar>("jar") {
		enabled = false
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}