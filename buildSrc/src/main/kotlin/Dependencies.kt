import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    // AndroidX
    const val androidXCoreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val preferencesDataStore = "androidx.datastore:datastore-preferences:${Versions.preferencesDataStore}"

    const val androidXMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    // Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJUnit}"

    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    // Compose
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val lifeCycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"

    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"

    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // Koin
    const val koinCore =  "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid =  "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompose =  "io.insert-koin:koin-androidx-compose:${Versions.koin}"

    const val koinWorkManager =  "io.insert-koin:koin-workmanager:${Versions.koin}"
    // Ktor
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val ktorAuth = "io.ktor:ktor-client-auth:${Versions.ktor}"
    const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val ktorNavigation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorClientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val ktorClientSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"

    // KotlinXSerializationJson
    const val kotlinXSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinXSerialization}"

    // Coil
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

}

fun DependencyHandler.androidX() {
    implementation(Dependencies.androidXCoreKtx)
    implementation(Dependencies.androidXMaterial)
    implementation(Dependencies.androidAppCompat)
}

fun DependencyHandler.dataStore() {
    implementation(Dependencies.preferencesDataStore)
}

fun DependencyHandler.unitTest() {
    implementation(Dependencies.jUnit)
    implementation(Dependencies.extJUnit)
    implementation(Dependencies.espressoCore)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.androidXCoreKtx)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.lifeCycleRuntimeKtx)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    debugImplementation(Dependencies.composeUiToolingPreview)
    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeUiTestManifest)
}

fun DependencyHandler.koin() {
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.koinCompose)
    implementation(Dependencies.koinCore)
}

fun DependencyHandler.kotlinCoroutines() {
    implementation(Dependencies.coroutines)
}

fun DependencyHandler.kotlinXSerializationJson() {
    implementation(Dependencies.kotlinXSerializationJson)
}

fun DependencyHandler.ktor() {
    implementation(Dependencies.ktorAndroid)
    implementation(Dependencies.ktorCore)
    implementation(Dependencies.ktorAuth)
    implementation(Dependencies.ktorLogging)
    implementation(Dependencies.ktorNavigation)
    implementation(Dependencies.ktorClientSerialization)
    implementation(Dependencies.ktorClientSerializationJson)
}

fun DependencyHandler.coil() {
    implementation(Dependencies.coil)
}

fun DependencyHandler.dataModule() {
    implementation(project(":data"))
}


