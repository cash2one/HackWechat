package com.tencent.mm.plugin.appbrand.page;

public final class b {
    public static int a(final p pVar, final boolean z) {
        if (pVar == null) {
            return a.jCF;
        }
        pVar.getContentView().post(new Runnable() {
            public final void run() {
                pVar.jDN.do(!z);
            }
        });
        return a.jCI;
    }
}
