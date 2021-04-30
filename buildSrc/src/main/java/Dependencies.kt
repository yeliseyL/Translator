import org.gradle.api.JavaVersion

object Config {
    const val application_id = "com.eliseylobanov.translator"
    const val compile_sdk = 30
    const val min_sdk = 26
    const val target_sdk = 30
    val java_version = JavaVersion.VERSION_1_8
}

object Releases {
    const val version_code = 1
    const val version_name = "1.0"
}

object Modules {
    const val app = ":app"
    const val model = ":model"
    const val repository = ":repository"
}

object Versions {
    // Design
    const val appcompat = "1.2.0"
    const val material = "1.3.0"
    const val constraint = "2.0.4"
    const val legacy = "1.0.0"

    // Kotlin
    const val core = "1.3.2"
    const val stdlib = "1.4.31"
    const val coroutines = "1.4.1"

    // UI
    const val fragment = "1.3.3"
    const val navigation = "1.0.0"

    // Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.7.1"
    const val interceptor = "3.12.1"

    // Koin
    const val koinAndroid = "2.0.1"

    // Picasso
    const val picasso = "2.5.2"

    // Room
    const val room = "2.3.0"

    // Test
    const val jUnit = "4.12"
    const val runner = "1.1.2"
    const val espressoCore = "3.3.0"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.stdlib}"
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object UI {
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val navigation = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
}

object Koin {
    const val koin_android = "org.koin:koin-android:${Versions.koinAndroid}"
    const val koin_view_model = "org.koin:koin-android-viewmodel:${Versions.koinAndroid}"
}

object Picasso {
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
