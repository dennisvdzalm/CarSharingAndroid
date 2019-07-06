import org.gradle.api.JavaVersion

object Config {
    val minSdk = 23
    val compileSdk = 28
    val targetSdk = 28
    val javaVersion = JavaVersion.VERSION_1_8
    val buildTools = "28.0.3"
}

object Versions {
    // <editor-fold desc="google">
    val androidx_core = "1.0.1"
    val androidx_recyclerview = "1.0.0"
    val androidx_navigation = "2.0.0"
    val androidx_constraintLayout = "1.1.3"
    val material = "1.1.0-alpha04"
    // </editor-fold>

    // <editor-fold desc="testing">
    val junit = "4.12"
    val androidx_espresso = "3.1.0"
    val androidx_testing = "1.1.1"
    //</editor-fold>

    // <editor-fold desc="tools">
    val gradleandroid = "3.4.1"
    val kotlin = "1.3.20"
    val gradleversions = "0.21.0"
    // </editor-fold>
    //rx
    val rxJava = "2.1.12"
    val rxAndroid = "2.0.2"

    //android
    val lifecycle_version = "2.0.0"

    //di
    val dagger = "2.23.2"

    //networking
    val retrofit = "2.4.0"

    //database
    val room = "1.1.1"

    //gson
    val gson = "2.8.2"

    //logging
    val timber = "4.7.1"
}

object Deps {
    val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    val androidx_material = "com.google.android.material:material:${Versions.material}"
    val androidx_navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidx_navigation}"
    val androidx_navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.androidx_navigation}"
    val androidx_recyclerview = "androidx.recyclerview:recyclerview:${Versions.androidx_recyclerview}"

    val testlib_junit = "junit:junit:${Versions.junit}"

    val testandroidx_rules = "androidx.test:rules:${Versions.androidx_testing}"
    val testandroidx_runner = "androidx.test:runner:${Versions.androidx_testing}"
    val testandroidx_espressocore = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"

    val tools_gradleandroid = "com.android.tools.build:gradle:${Versions.gradleandroid}"
    val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val tools_gradleversions = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleversions}"

    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    val gson = "com.google.code.gson:gson:${Versions.gson}"

    val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"

    val room_rx = "android.arch.persistence.room:rxjava2:${Versions.room}"
    val room_runtime = "android.arch.persistence.room:runtime:${Versions.room}"
    val room_compiler = "android.arch.persistence.room:compiler:${Versions.room}"

    val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
    val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"
    val lifecycle_testing = "androidx.arch.core:core-testing:${Versions.lifecycle_version}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofit_rx_adapter = "com.squareup.retrofit2:adapter-rxjava:${Versions.retrofit}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

