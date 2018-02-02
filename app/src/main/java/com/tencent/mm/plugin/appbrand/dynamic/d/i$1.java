package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.u.b.b.a;

class i$1 implements i<Bundle> {
    final /* synthetic */ a iTn;
    final /* synthetic */ i iTv;

    i$1(i iVar, a aVar) {
        this.iTv = iVar;
        this.iTn = aVar;
    }

    public final /* synthetic */ void as(Object obj) {
        boolean z;
        String string;
        Bundle bundle = null;
        Bundle bundle2 = (Bundle) obj;
        if (bundle2 != null) {
            z = bundle2.getBoolean("ret");
            string = bundle2.getString("reason");
            bundle = bundle2.getBundle(SlookAirButtonFrequentContactAdapter.DATA);
        } else {
            z = false;
            string = null;
        }
        this.iTn.aw(this.iTv.a(z, string, bundle));
    }
}
