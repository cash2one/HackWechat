package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements k {
    public static boolean aJZ() {
        boolean aKd = ((l) g.h(l.class)).aKd();
        x.i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is " + aKd);
        return aKd;
    }

    public static int a(com.tencent.mm.pluginsdk.wallet.c cVar, boolean z) {
        return ((l) g.h(l.class)).a(cVar, 0, z);
    }

    public static void release() {
        ((l) g.h(l.class)).aKj();
    }

    public static void abort() {
        ((l) g.h(l.class)).aKk();
    }

    public static void aKa() {
        ((l) g.h(l.class)).aKa();
    }

    public static boolean aKb() {
        return ((l) g.h(l.class)).aKe();
    }

    public static j aKc() {
        return ((l) g.h(l.class)).aKc();
    }
}
