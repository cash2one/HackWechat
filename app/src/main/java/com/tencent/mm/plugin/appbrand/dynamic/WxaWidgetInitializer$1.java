package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.sdk.platformtools.x;

class WxaWidgetInitializer$1 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ int hLI;
    final /* synthetic */ int iCP;
    final /* synthetic */ int iSi;
    final /* synthetic */ int iSj;
    final /* synthetic */ String iSk;
    final /* synthetic */ WxaWidgetInitializer$a iSl;
    final /* synthetic */ String iSm;
    final /* synthetic */ String uR;

    WxaWidgetInitializer$1(String str, int i, int i2, String str2, int i3, int i4, String str3, WxaWidgetInitializer$a wxaWidgetInitializer$a, String str4) {
        this.uR = str;
        this.iCP = i;
        this.iSi = i2;
        this.fgU = str2;
        this.iSj = i3;
        this.hLI = i4;
        this.iSk = str3;
        this.iSl = wxaWidgetInitializer$a;
        this.iSm = str4;
    }

    public final void run() {
        x.d("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", new Object[]{this.uR, Integer.valueOf(this.iCP), Integer.valueOf(this.iSi)});
        d a = a.a(this.fgU, this.iCP, this.iSi, this.iSj, this.hLI, this.iSk);
        if (a == null) {
            x.e("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[]{this.uR, Integer.valueOf(this.iCP), Integer.valueOf(this.iSi)});
            if (this.iSl != null) {
                this.iSl.a(this.uR, this.fgU, false, null);
                return;
            }
            return;
        }
        WxaPkgWrappingInfo a2 = a.a(this.uR, this.fgU, this.iSm, this.iCP, this.iSi);
        if (a2 != null) {
            WxaWidgetContext a3 = WxaWidgetInitializer.a(this.uR, this.fgU, a2, a);
            if (this.iSl != null) {
                this.iSl.a(this.uR, this.fgU, a3 != null, a3);
                return;
            }
            return;
        }
        x.e("MicroMsg.WxaWidgetInitializer", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[]{this.uR, Integer.valueOf(this.iCP), Integer.valueOf(this.iSi)});
        if (this.iSl != null) {
            this.iSl.aX(this.uR, this.fgU);
        }
        String str = this.uR;
        String str2 = this.fgU;
        String str3 = this.iSm;
        int i = this.iCP;
        e 1 = new 1(this, a);
        if (i != Integer.MIN_VALUE && a.a(str, str2, str3, i, 0) == null) {
            Parcelable bundle = new Bundle();
            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle.putString("appId", str2);
            bundle.putInt("debugType", i);
            f.a("com.tencent.mm", bundle, a.d.class, new 2(1));
        }
    }
}
