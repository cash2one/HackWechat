package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.rtmp.TXLiveBase;

public final class k {
    private static boolean jli;

    public static void agu() {
        if (!jli) {
            TXLiveBase.setLogLevel(1);
            TXLiveBase.setConsoleEnabled(false);
            TXLiveBase.setListener(new 1());
            jli = true;
        }
    }
}
