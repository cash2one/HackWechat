package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.model.c;

public final class u {
    private static u lQn = null;
    private c lQo;
    private f lQp;

    private static u aEK() {
        if (lQn == null) {
            lQn = new u();
        }
        return lQn;
    }

    public static f aEL() {
        if (aEK().lQp == null) {
            aEK().lQp = new f();
        }
        return aEK().lQp;
    }

    public static void a(m mVar) {
        aEM().lKw = mVar;
    }

    public static c aEM() {
        if (aEK().lQo == null) {
            u aEK = aEK();
            if (c.lKv == null) {
                c.lKv = new c();
            }
            aEK.lQo = c.lKv;
        }
        return aEK().lQo;
    }
}
