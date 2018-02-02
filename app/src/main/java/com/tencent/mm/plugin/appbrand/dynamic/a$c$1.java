package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.a;

class a$c$1 implements a {
    final /* synthetic */ c gMB;
    final /* synthetic */ a.c iRE;

    a$c$1(a.c cVar, c cVar2) {
        this.iRE = cVar;
        this.gMB = cVar2;
    }

    public final void aX(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("op", 0);
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle.putString("appId", str2);
        this.gMB.i(bundle);
    }

    public final void a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext) {
        Bundle bundle = new Bundle();
        bundle.putInt("op", 1);
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle.putString("appId", str2);
        bundle.putBoolean("success", z);
        if (wxaWidgetContext != null) {
            bundle.putParcelable("fwContext", wxaWidgetContext);
            i.a(str, wxaWidgetContext);
        }
        this.gMB.i(bundle);
    }
}
