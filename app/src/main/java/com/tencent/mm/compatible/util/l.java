package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.mm.sdk.platformtools.bh;

public final class l {
    public static boolean xg() {
        if (bh.az(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0) {
            return true;
        }
        return false;
    }
}
