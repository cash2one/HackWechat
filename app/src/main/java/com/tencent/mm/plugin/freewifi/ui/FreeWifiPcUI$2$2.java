package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.k$b;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiPcUI$2$2 implements e {
    final /* synthetic */ 2 mIn;
    final /* synthetic */ ak mIp;

    FreeWifiPcUI$2$2(2 2, ak akVar) {
        this.mIn = 2;
        this.mIp = akVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.mIp.TG();
        if (i == 0 && i2 == 0) {
            this.mIn.mIm.finish();
        } else if (!m.cA(i, i2) || m.AA(str)) {
            FreeWifiPcUI.a(this.mIn.mIm, this.mIn.mIm.getString(R.l.ejG), this.mIn.mIm.getString(R.l.ejH));
        } else {
            FreeWifiPcUI.a(this.mIn.mIm, str + "(" + m.a(m.F(this.mIn.mIm.getIntent()), k$b.SetPcLoginUserInfoReturn, i2) + ")", "");
        }
        a aLe = com.tencent.mm.plugin.freewifi.k.aLe();
        aLe.mCs = String.valueOf(FreeWifiPcUI.e(this.mIn.mIm));
        aLe.mCt = FreeWifiPcUI.d(this.mIn.mIm);
        aLe.mCu = FreeWifiPcUI.c(this.mIn.mIm);
        aLe.mCw = k$b.SetPcLoginUserInfoReturn.mDi;
        aLe.mCx = k$b.SetPcLoginUserInfoReturn.name;
        aLe.result = i2;
        aLe.aLg().aLf();
        x.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", m.D(this.mIn.mIm.getIntent()), Integer.valueOf(m.E(this.mIn.mIm.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.mIn.mIm)), FreeWifiPcUI.d(this.mIn.mIm), FreeWifiPcUI.c(this.mIn.mIm));
    }
}
