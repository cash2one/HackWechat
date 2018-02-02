package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.plugin.appbrand.dynamic.d.g.b;

class g$b$1 implements p {
    final /* synthetic */ i gMv;
    final /* synthetic */ Bundle iTp;
    final /* synthetic */ b iTq;

    g$b$1(b bVar, Bundle bundle, i iVar) {
        this.iTq = bVar;
        this.iTp = bundle;
        this.gMv = iVar;
    }

    public final void b(boolean z, String str, Bundle bundle) {
        this.iTp.putBoolean("ret", z);
        this.iTp.putString("reason", str);
        this.iTp.putBundle(SlookAirButtonFrequentContactAdapter.DATA, bundle);
        this.gMv.as(this.iTp);
    }
}
