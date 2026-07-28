plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    // implementaciones de google services krish

    id("com.google.gms.google-services")
}

android {
    namespace = "mihaela.mindra.ecoscanner"
    compileSdk = 36

    defaultConfig {
        applicationId = "mihaela.mindra.ecoscanner"
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    //libreria constraint para poner elementos linkeados
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    //iconos predeterminados
    implementation("androidx.compose.material:material-icons-extended")
    implementation(libs.androidx.navigation.compose)
    implementation(libs.play.services.location)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    //dependecias para el grafico
    //implementation("io.github.ehsannarmani:compose-charts:0.1.11")
    // No funciona implementation ("com.github.tehras:charts:0.2.4")

    implementation("com.patrykandpatrick.vico:compose:2.0.0")
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.compose.foundation.layout)

    //dependencias de scanner
    //implementation("com.google.mlkit:barcode-scanning:17.2.0")
    //implementation("androidx.camera:camera-core:1.3.1")
    //implementation("androidx.camera:camera-camera2:1.3.1")
    //implementation("androidx.camera:camera-lifecycle:1.3.1")
    //implementation("androidx.camera:camera-view:1.3.1")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // dependencias de google servicies/firebase/firestore
    implementation(platform("com.google.firebase:firebase-bom:34.12.0"))
    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")


    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries
}