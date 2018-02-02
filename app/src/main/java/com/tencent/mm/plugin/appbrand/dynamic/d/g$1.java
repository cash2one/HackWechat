package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.u.b.b$a;

class g$1 implements i<Bundle> {
    final /* synthetic */ b$a iTn;
    final /* synthetic */ g iTo;

    g$1(g gVar, b$a com_tencent_mm_u_b_b_a) {
        this.iTo = gVar;
        this.iTn = com_tencent_mm_u_b_b_a;
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
        this.iTn.aw(this.iTo.a(z, string, bundle));
    }
}
