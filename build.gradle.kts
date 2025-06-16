plugins {
    `java-library`
}

group = "com.rtm516"
version = "2.0.1"

repositories {
    mavenCentral()

    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }

    maven {
        name = "spigotmc-repo"
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    maven {
        name = "placeholderapi-repo"
        url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    }

    maven {
        name = "geysermc-repo-snapshots"
        url = uri("https://repo.opencollab.dev/maven-snapshots/")
    }

    maven {
        name = "geysermc-repo-releases"
        url = uri("https://repo.opencollab.dev/maven-releases/")
    }

    maven {
        name = "viaversion-repo"
        url = uri("https://repo.viaversion.com")
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")
    compileOnly("org.geysermc.floodgate:api:2.2.3-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly("com.viaversion:viaversion-api:4.9.3")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.jar {
    archiveFileName = "Expansion-${project.name}-${project.version}.${archiveExtension.get()}"
}