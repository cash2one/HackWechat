package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.u.c.e.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class a$1 implements a {
    a$1() {
    }

    public final void B(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle.putInt(DownloadInfo.STATUS, i);
        f.a("com.tencent.mm", bundle, a.a.class, null);
    }
}
