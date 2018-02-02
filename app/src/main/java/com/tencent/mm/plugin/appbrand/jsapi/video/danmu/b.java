package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.mm.bv.a;

public final class b {
    public static int jtS = 18;
    public static int jtT = 10;
    private static int jtU = 3;

    public static float bX(Context context) {
        return ((float) a.fromDPToPix(context, jtS)) * 2.0f;
    }

    public static int x(Context context, int i) {
        return a.fromDPToPix(context, i);
    }

    public static int ahr() {
        return jtU;
    }
}
