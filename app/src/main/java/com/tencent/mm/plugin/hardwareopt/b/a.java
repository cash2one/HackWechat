package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.mm.protocal.c.aka;

public class a {
    private static volatile a nAj = null;
    private aka nAk = null;

    private a() {
    }

    public static a aSo() {
        if (nAj != null) {
            return nAj;
        }
        a aVar;
        synchronized (a.class) {
            if (nAj == null) {
                nAj = new a();
            }
            aVar = nAj;
        }
        return aVar;
    }

    public final aka aSp() {
        if (this.nAk == null) {
            this.nAk = new aka();
        }
        return this.nAk;
    }
}
