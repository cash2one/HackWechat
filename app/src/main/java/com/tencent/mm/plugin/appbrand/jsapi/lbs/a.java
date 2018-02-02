package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.j;

abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a() {
    }

    static boolean i(j jVar) {
        return com.tencent.mm.pluginsdk.g.a.aZ(jVar.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
    }
}
