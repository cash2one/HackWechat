package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;
import java.util.Arrays;

public final class h$d {
    public final String[] iJH = new String[9];

    public h$d() {
        Arrays.fill(this.iJH, "0");
        this.iJH[0] = (String) g.Dj().CU().get(a.xrQ, "");
        this.iJH[1] = String.valueOf(g.Dj().CU().get(a.xrR, Long.valueOf(0)));
        this.iJH[2] = String.valueOf(bh.Wo());
    }
}
