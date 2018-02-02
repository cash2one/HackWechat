package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.p$a;
import com.tencent.mm.plugin.appbrand.appcache.p$b;

public final class d implements p$b {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iSJ = new int[a.acR().length];

        static {
            try {
                iSJ[a.iSL - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iSJ[a.iSM - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public final p$a a(ab abVar) {
        if (ak.class == abVar.getClass()) {
            return new a(abVar, (byte) 0);
        }
        return null;
    }
}
