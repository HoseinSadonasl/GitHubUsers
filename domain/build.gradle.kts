plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradle>()

android {
    namespace = "ir.hoseinsa.domain"
}
dependencies {
    koin()
    pagingRuntime()
}