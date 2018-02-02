package com.tencent.mm.sdk.platformtools;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import java.lang.ref.WeakReference;

public final class av {
    private static final String xhE = Media.EXTERNAL_CONTENT_URI.toString();
    private static final String[] xhF = new String[]{"_display_name", "_data", "date_added"};
    private static ContentObserver xhG;
    private static WeakReference<a> xhH;

    public static void a(a aVar) {
        x.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback callback[%s], stack[%s]", new Object[]{aVar, bh.cgy()});
        if (aVar == null) {
            if (xhG != null) {
                ac.getContext().getContentResolver().unregisterContentObserver(xhG);
                xhG = null;
            }
            if (xhH != null) {
                xhH.clear();
                xhH = null;
                return;
            }
            return;
        }
        xhH = new WeakReference(aVar);
        if (xhG == null) {
            xhG = new 1(new Handler(Looper.myLooper()));
            ac.getContext().getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, xhG);
        }
    }
}
