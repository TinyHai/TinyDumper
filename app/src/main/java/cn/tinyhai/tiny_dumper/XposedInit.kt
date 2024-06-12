package cn.tinyhai.tiny_dumper

import android.content.Context
import cn.tinyhai.tiny_dumper.util.logI
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class XposedInit : IXposedHookLoadPackage {

    companion object {
        @JvmStatic
        external fun nativeDump()
    }

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != lpparam.processName) {
            return
        }
        val entryClassName = lpparam.appInfo.className ?: return
        try {
            System.loadLibrary("dumper")
            XposedHelpers.findAndHookMethod(
                entryClassName,
                lpparam.classLoader,
                "attachBaseContext",
                Context::class.java,
                object : XC_MethodHook() {
                    override fun afterHookedMethod(param: MethodHookParam) {
                        nativeDump()
                    }
                })
        } catch (th: Throwable) {
            logI(th)
        }
    }
}