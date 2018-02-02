package com.tencent.mm.plugin.n;

import com.tencent.mm.aq.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.z.p;

public final class b extends p {
    private static b nBF;

    private b() {
        super(o.class);
    }

    public static synchronized b aSL() {
        b bVar;
        synchronized (b.class) {
            if (nBF == null) {
                nBF = new b();
            }
            bVar = nBF;
        }
        return bVar;
    }

    public static at Ff() {
        g.Dh().Ct();
        return ((a) g.h(a.class)).Ff();
    }
}
