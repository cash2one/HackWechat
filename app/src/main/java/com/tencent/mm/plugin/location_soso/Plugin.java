package com.tencent.mm.plugin.location_soso;

import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.tencentmap.mapsdk.map.g;
import com.tencent.tencentmap.mapsdk.map.g.b;

public class Plugin implements c {
    public static final String TAG = "MicroMsg.Plugin";

    public Plugin() {
        x.d(TAG, "initLoctionInit");
        g.Aed = new b() {
            public void collectErrorInfo(String str) {
                x.i(Plugin.TAG, "error by map " + str);
            }
        };
    }

    public p createApplication() {
        return null;
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return null;
    }
}
