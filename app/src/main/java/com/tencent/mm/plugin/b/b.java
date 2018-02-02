package com.tencent.mm.plugin.b;

import com.tencent.mm.z.c.c;
import com.tencent.mm.z.p;

public final class b extends p {
    private static b ikB;

    private b() {
        super(c.class);
    }

    public static synchronized b Xm() {
        b bVar;
        synchronized (b.class) {
            if (ikB == null) {
                ikB = new b();
            }
            bVar = ikB;
        }
        return bVar;
    }

    public final void fN(String str) {
        super.fN(str);
    }
}
