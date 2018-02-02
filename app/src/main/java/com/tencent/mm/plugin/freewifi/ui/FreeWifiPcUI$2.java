package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiPcUI$2 implements OnClickListener {
    final /* synthetic */ FreeWifiPcUI mIm;

    FreeWifiPcUI$2(FreeWifiPcUI freeWifiPcUI) {
        this.mIm = freeWifiPcUI;
    }

    public final void onClick(View view) {
        FreeWifiPcUI.b(this.mIm).setClickable(false);
        ak akVar = new ak(new 1(this), false);
        akVar.J(2000, 2000);
        a aLe = k.aLe();
        aLe.mCs = String.valueOf(FreeWifiPcUI.e(this.mIm));
        aLe.mCt = FreeWifiPcUI.d(this.mIm);
        aLe.mCu = FreeWifiPcUI.c(this.mIm);
        aLe.mCw = b.mDe.mDi;
        aLe.mCx = b.mDe.name;
        aLe.aLg().aLf();
        x.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[]{m.D(this.mIm.getIntent()), Integer.valueOf(m.E(this.mIm.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.mIm)), FreeWifiPcUI.d(this.mIm), FreeWifiPcUI.c(this.mIm)});
        new l(FreeWifiPcUI.d(this.mIm), FreeWifiPcUI.e(this.mIm), FreeWifiPcUI.c(this.mIm)).b(new 2(this, akVar));
    }
}
