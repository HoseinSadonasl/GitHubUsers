import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class MainGradle: Plugin<Project> {

    override fun apply(target: Project) {
        applyPlugins(target)
        projectConfigure(target)
    }

    private fun applyPlugins(project: Project) {
        project.apply {
            plugin("android-library")
            plugin("kotlin-android")
            plugin("kotlin-kapt")
        }
    }

    private fun projectConfigure(project: Project) {
        project.android().apply {
            compileSdk = ProjectConfig.compileSdk

            defaultConfig {
                minSdk = ProjectConfig.minSdk
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_18
                targetCompatibility = JavaVersion.VERSION_18
            }
        }
    }

    private fun Project.android(): LibraryExtension {
        return extensions.getByType(LibraryExtension::class.java)
    }

}