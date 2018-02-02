package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.p.a;
import com.tencent.mm.plugin.appbrand.appcache.p.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.concurrent.ConcurrentHashMap;

public final class i implements b {
    private static final ConcurrentHashMap<String, Boolean> iEb = new ConcurrentHashMap();

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iEc = new int[a.values().length];

        static {
            try {
                iEc[a.iEm.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iEc[a.iEn.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iEc[a.iEo.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iEc[a.iEp.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iEc[a.iEq.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static /* synthetic */ boolean pA(String str) {
        return !bh.ov(str) && Boolean.TRUE.equals(iEb.get(str));
    }

    public final a a(ab abVar) {
        if (ab.class == abVar.getClass() || aa$b.class == abVar.getClass() || x.class == abVar.getClass()) {
            return new a(abVar, (byte) 0);
        }
        return null;
    }

    public static void pz(String str) {
        if (!bh.ov(str)) {
            iEb.put(str, Boolean.valueOf(true));
        }
    }
}
