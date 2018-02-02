package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.a.e;

class IPCDynamicPageView$6 implements Runnable {
    final /* synthetic */ IPCDynamicPageView iVu;

    IPCDynamicPageView$6(IPCDynamicPageView iPCDynamicPageView) {
        this.iVu = iPCDynamicPageView;
    }

    public final void run() {
        IPCDynamicPageView.f(this.iVu);
        String e = IPCDynamicPageView.e(this.iVu);
        Bundle bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
        f.a("com.tencent.mm:support", bundle, e.class, null);
    }
}
