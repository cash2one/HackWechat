package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class m$2 implements Runnable {
    final /* synthetic */ int mCA;
    final /* synthetic */ String mDl;
    final /* synthetic */ String mDn;
    final /* synthetic */ int mDo;
    final /* synthetic */ a mDp;
    final /* synthetic */ Intent val$intent;

    m$2(String str, String str2, Intent intent, int i, int i2, a aVar) {
        this.mDl = str;
        this.mDn = str2;
        this.val$intent = intent;
        this.mCA = i;
        this.mDo = i2;
        this.mDp = aVar;
    }

    public final void run() {
        k.a aLe = k.aLe();
        aLe.ssid = m.AD(this.mDl);
        aLe.bssid = m.AE(this.mDl);
        aLe.fpA = m.AF(this.mDl);
        aLe.fpz = this.mDn;
        aLe.mCu = m.D(this.val$intent);
        aLe.mCv = this.mCA;
        aLe.mCw = b.mCI.mDi;
        aLe.mCx = b.mCI.name;
        aLe.fCR = m.G(this.val$intent);
        aLe.result = 0;
        aLe.aLg().aLf();
        String AE = m.AE(this.mDl);
        String AD = m.AD(this.mDl);
        int aLC = d.aLC();
        x.i(this.mDl, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + an.getNetType(ac.getContext()));
        x.i(this.mDl, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.D(this.val$intent), Integer.valueOf(m.E(this.val$intent)), this.mDn, AE, AD, Integer.valueOf(aLC)});
        new com.tencent.mm.plugin.freewifi.d.a(this.mDn, AE, AD, aLC, this.mDo, m.D(this.val$intent)).b(new 1(this));
    }
}
