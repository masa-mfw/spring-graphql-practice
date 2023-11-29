import com.expediagroup.graphql.plugin.gradle.tasks.GraphQLGenerateSDLTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	id("com.expediagroup.graphql") version "7.0.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.expediagroup:graphql-kotlin-server:7.0.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}



tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

val graphqlGenerateSDL by tasks.getting(GraphQLGenerateSDLTask::class) {
	packages.set(
		listOf(
			"com.example.springgraphqlpractice.graphql"
		)
	)
	schemaFile.set(file("${project.projectDir}/src/main/resources/graphql/server/schema.graphql"))
}
