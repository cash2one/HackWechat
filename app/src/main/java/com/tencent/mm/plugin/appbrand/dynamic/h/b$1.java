package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.sdk.platformtools.ak.a;

class b$1 implements a {
    b$1() {
    }

    public final boolean uF() {
        BaseIPCService fl = k.Bv().fl("com.tencent.mm:support");
        if (fl != null) {
            fl.bs(false);
        }
        return false;
    }
}
