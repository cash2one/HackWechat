package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.plugin.appbrand.dynamic.a.b.a;

class b$3 implements Runnable {
    final /* synthetic */ b iSB;

    b$3(b bVar) {
        this.iSB = bVar;
    }

    public final void run() {
        if (g.fk("com.tencent.mm:support")) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("forceKillProcess", true);
            f.a("com.tencent.mm:support", bundle, a.class, new 1(this));
        }
    }
}
