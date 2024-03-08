plugins {
    `android-library`
    `kotlin-android`
    id("kotlinx-serialization")
}

apply<MainGradle>()

android {
    namespace = "ir.hoseinsa.data"
}

dependencies {
    androidX()
    ktor()
    koin()
    pagingRuntime()
    kotlinXSerializationJson()

    domainModule()
}