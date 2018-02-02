package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class a$a implements a {
    private a$a() {
    }

    public final void a(Bundle bundle, c cVar) {
        b.B(bundle.getString(SlookAirButtonFrequentContactAdapter.ID), bundle.getInt(DownloadInfo.STATUS));
    }
}
