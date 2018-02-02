package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;

enum y {
    ;

    static void kP(int i) {
        ta(ac.getResources().getString(i));
    }

    static void ta(String str) {
        ag.y(new 1(str));
    }

    static String getMMString(int i, Object... objArr) {
        return c.getMMString(i, objArr);
    }
}
