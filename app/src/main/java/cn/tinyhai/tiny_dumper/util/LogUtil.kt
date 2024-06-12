package cn.tinyhai.tiny_dumper.util

import de.robv.android.xposed.XposedBridge

private const val TAG = "TinyDumper"

fun logI(vararg infos: Any) {
    infos.forEach {
        XposedBridge.log("$TAG >>> $it")
        if (it is Throwable) {
            XposedBridge.log(it)
        }
    }
}