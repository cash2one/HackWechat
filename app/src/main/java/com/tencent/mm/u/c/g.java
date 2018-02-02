package com.tencent.mm.u.c;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.u.b.e;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private final Map<String, e> gOW = new HashMap();

    public final void a(e eVar) {
        this.gOW.put(eVar.getName(), eVar);
    }

    public final e fs(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return (e) this.gOW.get(str);
    }
}
