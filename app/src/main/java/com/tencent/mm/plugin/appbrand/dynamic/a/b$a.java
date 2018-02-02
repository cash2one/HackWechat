package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.h.b;

class b$a implements a {
    private b$a() {
    }

    public final void a(Bundle bundle, c cVar) {
        boolean z = false;
        if (bundle != null && bundle.getBoolean("forceKillProcess", false)) {
            z = true;
        }
        if (z) {
            b.adg();
        } else {
            b.adf();
        }
        cVar.i(null);
    }
}
