package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.sdk.platformtools.x;

class a$f implements j<Bundle, IPCBoolean> {
    private a$f() {
    }

    public final /* synthetic */ Object at(Object obj) {
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
        String string2 = bundle.getString("event");
        String string3 = bundle.getString(SlookAirButtonFrequentContactAdapter.DATA);
        c rm = d.acE().rm(string);
        if (rm != null) {
            return new IPCBoolean(rm.aY(string2, string3));
        }
        x.e("MicroMsg.IPCInvoke_PublishJsEvent", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
        return new IPCBoolean(false);
    }
}
