package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.x;

public final class k extends f {
    private static final int CTRL_INDEX = 248;
    private static final String NAME = "onUserCaptureScreen";
    private static k jcj = new k();

    public static void se(String str) {
        x.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[]{str});
        jcj.az(str, 0).afs();
    }
}
