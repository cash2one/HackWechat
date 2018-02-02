package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class IPCDynamicPageView$4 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ Bundle iRz;
    final /* synthetic */ IPCDynamicPageView iVu;
    final /* synthetic */ String uR;

    IPCDynamicPageView$4(IPCDynamicPageView iPCDynamicPageView, Bundle bundle, String str, String str2) {
        this.iVu = iPCDynamicPageView;
        this.iRz = bundle;
        this.uR = str;
        this.fgU = str2;
    }

    public final void run() {
        String str = "";
        if (this.iRz != null) {
            str = this.iRz.getString("cache_key", "");
        }
        x.i("MicroMsg.IPCDynamicPageView", "attach(%s, %s, %s)", new Object[]{this.uR, this.fgU, str});
        IPCDynamicPageView.a(this.iVu, b.rC(this.uR));
        if (IPCDynamicPageView.g(this.iVu) == null) {
            IPCDynamicPageView.a(this.iVu, new g());
        }
        IPCDynamicPageView.g(this.iVu).field_id = this.uR;
        IPCDynamicPageView.g(this.iVu).field_cacheKey = str;
        IPCDynamicPageView.g(this.iVu).field_appId = this.fgU;
        this.iVu.qe(this.uR);
        e acF = e.acF();
        String str2 = this.uR;
        IPCDynamicPageView iPCDynamicPageView = this.iVu;
        if (bh.ov(str2)) {
            x.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
        } else if (iPCDynamicPageView == null) {
            x.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
        } else {
            WeakReference weakReference = (WeakReference) acF.iRZ.put(str2, new WeakReference(iPCDynamicPageView));
            if (!(weakReference == null || weakReference.get() == null)) {
                x.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[]{str2});
            }
        }
        if (this.iRz != null) {
            this.iRz.putBundle("__env_args", IPCDynamicPageView.b(this.iVu, this.iRz));
        }
        IPCDynamicPageView.f(this.iVu);
        str = this.uR;
        str2 = this.fgU;
        Bundle bundle = this.iRz;
        Bundle bundle2 = new Bundle();
        bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle2.putString("appId", str2);
        bundle2.putBundle("extData", bundle);
        f.a("com.tencent.mm:support", bundle2, a.class, null);
    }
}
