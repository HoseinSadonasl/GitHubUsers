plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradle>()

android {
    namespace = "ir.hoseinsa.presenter"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
dependencies {
    androidX()
    compose()
    coil()
    koin()

    domainModule()
}