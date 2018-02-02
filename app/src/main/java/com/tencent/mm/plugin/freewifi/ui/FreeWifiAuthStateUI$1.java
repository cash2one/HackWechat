package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiAuthStateUI$1 implements b {
    final /* synthetic */ FreeWifiAuthStateUI mGA;

    FreeWifiAuthStateUI$1(FreeWifiAuthStateUI freeWifiAuthStateUI) {
        this.mGA = freeWifiAuthStateUI;
    }

    public final void bn(String str, int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[]{str, this.mGA.mFa, d.aLB()});
        if (!bh.ov(str)) {
            String str2 = str;
            new a(this.mGA.mFa, this.mGA.ssid, r3, this.mGA.mGr, str2, "", i, m.D(this.mGA.getIntent())).b(new 1(this));
        }
    }
}
