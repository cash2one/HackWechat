package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    private static final Map<String, i> gMS = new a();
    private static final i irH = new i();
    public volatile String irI;
    public final AtomicInteger irJ = new AtomicInteger();
    public final AtomicBoolean irK = new AtomicBoolean(false);
    public int irL = 0;
    public volatile acn irM;
    public volatile String irN;
    public volatile String irO;

    private i() {
    }

    static i pi(String str) {
        return pj(str);
    }

    private static i pj(String str) {
        if (bh.ov(str)) {
            return null;
        }
        i iVar;
        synchronized (gMS) {
            iVar = (i) gMS.get(str);
            if (iVar == null) {
                iVar = new i();
                gMS.put(str, iVar);
            }
        }
        return iVar;
    }

    private static i pk(String str) {
        if (bh.ov(str)) {
            return null;
        }
        i iVar;
        synchronized (gMS) {
            iVar = (i) gMS.get(str);
        }
        return iVar;
    }

    static void remove(String str) {
        if (!bh.ov(str)) {
            synchronized (gMS) {
                gMS.remove(str);
            }
        }
    }

    public static i pl(String str) {
        i pk = pk(str);
        return pk == null ? irH : pk;
    }

    public static i pm(String str) {
        return pj(str);
    }
}
