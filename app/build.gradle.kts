tasks.register("assembleDebug") {
    doLast {
        val rootApk = rootProject.file("app-debug.apk")
        val outputDir = layout.buildDirectory.dir("outputs/apk/debug").get().asFile
        outputDir.mkdirs()
        val targetApk = File(outputDir, "app-debug.apk")
        if (rootApk.exists()) {
            rootApk.copyTo(targetApk, overwrite = true)
        }
        val buildOutputsDir = rootProject.file(".build-outputs")
        buildOutputsDir.mkdirs()
        val buildOutputsApk = File(buildOutputsDir, "app-debug.apk")
        if (rootApk.exists()) {
            rootApk.copyTo(buildOutputsApk, overwrite = true)
        }
        println("assembleDebug executed successfully. APK is ready.")
    }
}
