package com.tencent.mm.plugin.appbrand.p;

import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ac;

public final class m {
    private static DisplayMetrics jRI = ac.getContext().getResources().getDisplayMetrics();

    public static int alF() {
        if (jRI == null) {
            return 16;
        }
        return (int) (jRI.density * 16.0f);
    }
}
