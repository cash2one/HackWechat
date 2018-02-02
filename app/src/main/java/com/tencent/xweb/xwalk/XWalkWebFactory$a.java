package com.tencent.xweb.xwalk;

import android.content.Context;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;

class XWalkWebFactory$a {
    private static boolean ArZ = false;
    private static boolean Ark = false;
    private static boolean lVG = false;

    public static boolean hasInited() {
        return lVG;
    }

    public static boolean hasInitedCallback() {
        return Ark;
    }

    public static boolean isCoreReady() {
        return ArZ;
    }

    public static boolean iS(Context context) {
        if (lVG) {
            return lVG;
        }
        Log.i("XWebViewHelper", "preInit");
        if (h.ec(context)) {
            Log.i("XWebViewHelper", "preInit finished");
            lVG = true;
            ArZ = true;
        } else {
            Log.i("XWebViewHelper", "preInit xwalk is not available");
        }
        return lVG;
    }

    public static void initCallback(WebViewExtensionListener webViewExtensionListener) {
        if (!Ark) {
            Log.i("XWebViewHelper", "initCallback");
            WebViewExtension.SetExtension(webViewExtensionListener);
            Ark = true;
        }
    }
}
