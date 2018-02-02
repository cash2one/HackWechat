package com.tencent.mm.plugin;

import com.tencent.mm.modelstat.q;
import com.tencent.mm.z.p;

public final class a extends p {
    private static a ifr;

    public static synchronized a Wy() {
        a aVar;
        synchronized (a.class) {
            if (ifr == null) {
                ifr = new a();
            }
            aVar = ifr;
        }
        return aVar;
    }

    private a() {
        super(q.class);
    }
}
