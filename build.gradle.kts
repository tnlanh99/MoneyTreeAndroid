plugins {
    id("com.android.application").version("7.3.0").apply(false)
    id("com.android.library").version("7.3.0").apply(false)
    id("org.jetbrains.kotlin.android").version("1.7.0").apply(false)
    id("com.diffplug.spotless").version("6.10.0")
}

spotless {
    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint()
    }

    kotlin {
        target("**/*.kt")
        ktlint()
    }

    format("xml") {
        target("**/*.xml")
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}
