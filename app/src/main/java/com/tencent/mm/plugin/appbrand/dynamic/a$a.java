package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.x;

class a$a implements a {
    private a$a() {
    }

    public final void a(Bundle bundle, c cVar) {
        String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
        String string2 = bundle.getString("appId");
        Bundle bundle2 = bundle.getBundle("extData");
        c rm = d.acE().rm(string);
        if (rm == null) {
            x.e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
            return;
        }
        b.n(new 1(this, rm, string, string2, bundle2));
    }
}
