package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.a.b.a;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.game.e.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    c$1() {
    }

    public final void loadLibrary(String str) {
        try {
            k.b(str, c.class.getClassLoader());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", e, "hy: link %s error!!", new Object[]{str});
            d.bS(ac.getContext());
        }
    }
}
