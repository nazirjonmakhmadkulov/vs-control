package ru.vs.convention.kmp

import ru.vs.configuration.projectConfiguration
import ru.vs.utils.android

/**
 * Базовая настройка android-library таргета для KMP.
 */

plugins {
    id("ru.vs.convention.kmp.common")
    id("com.android.library")
    id("ru.vs.convention.android.base")
}

kotlin {
    androidTarget {
        // Настраиваем версию jvm для сборки андроид модулей.
        compilations.all {
            kotlinOptions {
                jvmTarget = project.projectConfiguration.core.jvmVersion
            }
        }
    }
}

android {
    // Указываем директорию для поиска в ней AndroidManifest.xml.
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}