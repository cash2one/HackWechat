package com.tencent.mm.plugin.z;

import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.z.p;

public final class a extends p {
    private static a pdw;

    public static synchronized a biL() {
        a aVar;
        synchronized (a.class) {
            if (pdw == null) {
                pdw = new a();
            }
            aVar = pdw;
        }
        return aVar;
    }

    private a() {
        super(c.class);
    }
}
