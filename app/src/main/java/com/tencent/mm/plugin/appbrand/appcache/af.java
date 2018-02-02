package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;

public final class af {
    public static final Runnable iGd = new 1();

    static /* synthetic */ void ej(String str) {
        b.deleteFile(str);
        try {
            Runtime.getRuntime().exec("rm -r " + str + "_xdir");
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.WxaPkgPruner", "rm -r %s, e = %s", new Object[]{str + "_xdir", e});
        }
    }

    public static void aal() {
        c.Dm().F(iGd);
    }
}
