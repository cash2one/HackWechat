package com.tencent.mm.plugin.record.b;

import com.tencent.mm.g.a.fv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.b.a;

public final class b {
    public static String a(com.tencent.mm.plugin.record.ui.a.b bVar) {
        com.tencent.mm.sdk.b.b fvVar = new fv();
        fvVar.fvq.type = 2;
        fvVar.fvq.fvs = bVar.fve;
        a.xef.m(fvVar);
        return fvVar.fvr.path;
    }

    public static String b(com.tencent.mm.plugin.record.ui.a.b bVar) {
        com.tencent.mm.sdk.b.b fvVar = new fv();
        fvVar.fvq.type = 2;
        fvVar.fvq.fvs = bVar.fve;
        a.xef.m(fvVar);
        return fvVar.fvr.fvC;
    }

    public static boolean c(com.tencent.mm.plugin.record.ui.a.b bVar) {
        com.tencent.mm.sdk.b.b fvVar = new fv();
        fvVar.fvq.type = 14;
        fvVar.fvq.fvs = bVar.fve;
        a.xef.m(fvVar);
        if (fvVar.fvr.ret == 1) {
            return true;
        }
        return false;
    }

    public static f ea(long j) {
        return ((r) g.k(r.class)).getFavItemInfoStorage().db(j);
    }
}
