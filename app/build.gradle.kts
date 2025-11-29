import org.gradle.internal.impldep.com.fasterxml.jackson.core.JsonPointer.compile
import org.gradle.kotlin.dsl.annotationProcessor

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.experiencechannel"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.experiencechannel"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.swiperefreshlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    // Java language implementation
    implementation("androidx.fragment:fragment:1.8.9")
  implementation ("androidx.recyclerview:recyclerview:1.3.2") // 版本可按需更新
    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    implementation("org.projectlombok:lombok:1.18.30")
    implementation("cn.hutool:hutool-all:5.8.26")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    // 添加 Glide 依赖
    implementation("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")

}