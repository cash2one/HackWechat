package com.tencent.mm.z;

@Deprecated
public final class bp {
    public final synchronized boolean a(String str, ap apVar) {
        p gq = p.gq(str);
        if (gq == null) {
            gq = p.a(str, new p(apVar.getClass()));
        }
        gq.a(apVar);
        return true;
    }

    public static ap hY(String str) {
        p gq = p.gq(str);
        if (gq == null) {
            return null;
        }
        return gq.FP();
    }
}
