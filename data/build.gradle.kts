plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradle>()

android {
    namespace = "ir.hoseinsa.githubusers.data"
}

dependencies {
    androidX()
    ktor()
    koin()
    kotlinXSerializationJson()
}