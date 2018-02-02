package com.tencent.magicbrush.handler;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.tencent.magicbrush.handler.a.a;
import com.tencent.magicbrush.handler.a.b;
import com.tencent.magicbrush.handler.a.c;
import com.tencent.magicbrush.handler.a.i;
import java.nio.FloatBuffer;

public class MBFontManagerJNI {
    private static c sMBFontManager;

    public static void registerFontManager(b bVar, a aVar) {
        sMBFontManager = new i(bVar, aVar);
    }

    @Keep
    public static void init(int i, int i2) {
        if (sMBFontManager != null) {
            sMBFontManager.init(i, i2);
        }
    }

    @Keep
    public static String loadFont(String str) {
        if (sMBFontManager == null) {
            return null;
        }
        return sMBFontManager.loadFont(str);
    }

    @Keep
    public static void useFont(String str, float f, boolean z, boolean z2) {
        if (sMBFontManager != null) {
            sMBFontManager.useFont(str, f, z, z2);
        }
    }

    @Keep
    public static void enableStroke(boolean z) {
        if (sMBFontManager != null) {
            sMBFontManager.enableStroke(z);
        }
    }

    @Keep
    public static void setStrokeWidth(float f) {
        if (sMBFontManager != null) {
            sMBFontManager.setStrokeWidth(f);
        }
    }

    @Keep
    public static int[] checkAndFlushDirtySignal() {
        if (sMBFontManager == null) {
            return null;
        }
        return sMBFontManager.checkAndFlushDirtySignal();
    }

    @Keep
    public static boolean checkAndFlushClearSignal() {
        if (sMBFontManager == null) {
            return false;
        }
        sMBFontManager.checkAndFlushClearSignal();
        return true;
    }

    @Keep
    public static Bitmap getBitmapAtlas() {
        if (sMBFontManager == null) {
            return null;
        }
        return sMBFontManager.getBitmapAtlas();
    }

    @Keep
    public static FloatBuffer drawText(String str) {
        if (sMBFontManager == null) {
            return null;
        }
        return sMBFontManager.drawText(str);
    }

    @Keep
    public static float measureText(String str) {
        if (sMBFontManager == null) {
            return 0.0f;
        }
        return sMBFontManager.measureText(str);
    }

    @Keep
    public static void release() {
        if (sMBFontManager != null) {
            sMBFontManager.release();
        }
    }

    @Keep
    public static float getTextLineHeight(String str) {
        if (sMBFontManager == null) {
            return 0.0f;
        }
        return sMBFontManager.getTextLineHeight(str);
    }
}
