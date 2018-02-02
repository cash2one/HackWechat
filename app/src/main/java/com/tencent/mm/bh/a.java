package com.tencent.mm.bh;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public enum a {
    ;

    private a(String str) {
    }

    public static boolean Vb() {
        return !bh.ov(Vc());
    }

    public static String Vc() {
        g.Dk();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageUrl : %s", new Object[]{(String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xtQ, String.valueOf(""))});
        return (String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xtQ, String.valueOf(""));
    }

    public static String Vd() {
        g.Dk();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageTitle : %s", new Object[]{(String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xtS, String.valueOf(""))});
        return (String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xtS, String.valueOf(""));
    }

    public static void q(String str, String str2, String str3) {
        g.Dk();
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xtQ, str);
        g.Dk();
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xtS, str2);
        g.Dk();
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xtR, str3);
    }
}
