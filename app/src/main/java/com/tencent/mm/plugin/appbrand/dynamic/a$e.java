package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.x;

class a$e implements a {
    private a$e() {
    }

    public final void a(Bundle bundle, c cVar) {
        c rm = d.acE().rm(bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
        if (rm == null) {
            x.e("MicroMsg.IPCInvoke_OnResume", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{r0});
            return;
        }
        b.n(new 1(this, rm));
    }
}
