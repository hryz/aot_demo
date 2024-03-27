
plugins {
    alias(libs.plugins.jvm) // kotlin JVM
    alias(libs.plugins.native) // native compilation

    application
}

repositories {
    mavenCentral() // libs
    gradlePluginPortal() // plugins
}

val sl4jVersion = "2.0.9"
dependencies {
    implementation(libs.aws)
    implementation(libs.http)

    // logging
    implementation("org.slf4j:slf4j-api:$sl4jVersion")
    implementation("org.slf4j:slf4j-simple:$sl4jVersion")
    implementation("org.slf4j:jcl-over-slf4j:$sl4jVersion")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
        vendor = JvmVendorSpec.GRAAL_VM
        implementation = JvmImplementation.VENDOR_SPECIFIC
    }
}

application {
    mainClass = "org.example.AppKt"
}

graalvmNative {
    toolchainDetection = true
    testSupport = false
}