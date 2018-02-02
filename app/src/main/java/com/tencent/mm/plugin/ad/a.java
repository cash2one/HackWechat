package com.tencent.mm.plugin.ad;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a implements b, c {
    private static a pGV;

    private a() {
    }

    public final List<String> collectStoragePaths() {
        return null;
    }

    public static synchronized a bnl() {
        a aVar;
        synchronized (a.class) {
            if (pGV == null) {
                pGV = new a();
            }
            aVar = pGV;
        }
        return aVar;
    }

    public static String Fk() {
        return g.Dj().gQi + "remark/";
    }
}
