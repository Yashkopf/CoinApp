plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
        namespace = "com.example.coinapp"
        compileSdk = 35

        defaultConfig {
            applicationId = "com.example.coinapp"
            minSdk = 24
            targetSdk = 35
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.rxandroid)
    implementation(libs.rxjava)
    implementation(libs.adapter.rxjava2)
    implementation(libs.converter.gson)

    kapt(libs.lifecycle.compiler)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.reactivestreams.ktx)
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.picasso)


}