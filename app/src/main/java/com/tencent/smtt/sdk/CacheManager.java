package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.o;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            return ((Boolean) cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0])).booleanValue();
        }
        Object gd = o.gd("android.webkit.CacheManager", "cacheDisabled");
        return gd == null ? false : ((Boolean) gd).booleanValue();
    }

    public static InputStream getCacheFile(String str, boolean z) {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            return null;
        }
        Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, new Object[]{str, Boolean.valueOf(z)});
        return invokeStaticMethod == null ? null : (InputStream) invokeStaticMethod;
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            return cFg.cFi().cFk();
        }
        try {
            return o.b(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[]{String.class, Map.class}, new Object[]{str, map});
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        af cFg = af.cFg();
        return (cFg == null || !cFg.cFh()) ? (File) o.gd("android.webkit.CacheManager", "getCacheFileBaseDir") : (File) cFg.cFi().cFk();
    }
}
