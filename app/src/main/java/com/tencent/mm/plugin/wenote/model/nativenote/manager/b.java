package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class b {
    private static float tSA = Float.MAX_VALUE;
    private static int tSB = -1;
    public static float tSC = 48.0f;
    private static float tSz = Float.MAX_VALUE;

    private static float bWm() {
        float f;
        synchronized (b.class) {
            if (tSz == Float.MAX_VALUE) {
                tSz = getDisplayMetrics().density;
            }
            f = tSz;
        }
        return f;
    }

    public static float getTextSize() {
        return tSC;
    }

    public static void setTextSize(float f) {
        tSC = f;
    }

    public static int Br(int i) {
        return Math.round(((float) i) * bWn());
    }

    public static int Bs(int i) {
        return Math.round(((float) i) / bWn());
    }

    private static DisplayMetrics getDisplayMetrics() {
        Display defaultDisplay = ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static float bWn() {
        float f;
        synchronized (b.class) {
            if (tSA == Float.MAX_VALUE) {
                tSA = getDisplayMetrics().density * ac.getContext().getResources().getConfiguration().fontScale;
            }
            f = tSA;
        }
        return f;
    }

    public static int bWo() {
        if (tSB == -1) {
            tSB = Math.round(bWm() * 30.0f);
        }
        return tSB;
    }
}
