package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Build.VERSION;

enum e {
    ;

    public static boolean amz() {
        return VERSION.SDK_INT >= 19;
    }
}
