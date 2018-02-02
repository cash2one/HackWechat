package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.ak;
import com.tencent.mm.plugin.appbrand.jsapi.ax;
import com.tencent.mm.plugin.appbrand.jsapi.bm;

public enum aa {
    APP_LAUNCH("appLaunch"),
    NAVIGATE_TO(ak.NAME),
    NAVIGATE_BACK(aj.NAME),
    REDIRECT_TO(ax.NAME),
    RE_LAUNCH("reLaunch"),
    AUTO_RE_LAUNCH("autoReLaunch"),
    SWITCH_TAB(bm.NAME);
    
    private final String type;

    private aa(String str) {
        this.type = str;
    }

    public final String toString() {
        return this.type;
    }
}
