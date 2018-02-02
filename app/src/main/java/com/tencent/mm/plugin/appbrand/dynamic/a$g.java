package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.x;

class a$g implements a {
    private a$g() {
    }

    public final void a(Bundle bundle, c cVar) {
        String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
        Bundle bundle2 = bundle.getBundle("__env_args");
        if (bundle2 == null) {
            x.i("MicroMsg.IPCInvoke_UpdateEnvArgs", "envArgs is null.");
            return;
        }
        c rm = d.acE().rm(string);
        if (rm == null) {
            x.e("MicroMsg.IPCInvoke_UpdateEnvArgs", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
            return;
        }
        rm.o(bundle2);
    }
}
