package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.e.i.3;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;

class i$3$1 implements e {
    final /* synthetic */ 3 mFw;

    i$3$1(3 3) {
        this.mFw = 3;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.D(this.mFw.mFu.intent), Integer.valueOf(m.E(this.mFw.mFu.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
        a aLe = com.tencent.mm.plugin.freewifi.k.aLe();
        aLe.ssid = this.mFw.mFu.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol33");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol33");
        aLe.fpz = this.mFw.mFu.fpz;
        aLe.mCu = m.D(this.mFw.mFu.intent);
        aLe.mCv = m.F(this.mFw.mFu.intent);
        aLe.mCw = b.mCL.mDi;
        aLe.mCx = b.mCL.name;
        aLe.fCR = m.G(this.mFw.mFu.intent);
        aLe.result = i2;
        aLe.kZo = str;
        aLe.aLg().aLf();
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        FreeWifiFrontPageUI$d freeWifiFrontPageUI$d;
        FreeWifiFrontPageUI.a aVar;
        if (i == 0 && i2 == 0) {
            ei aMc = ((f) kVar).aMc();
            if (aMc != null) {
                x.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw, aMc.vJJ});
                FreeWifiFrontPageUI freeWifiFrontPageUI2 = this.mFw.mFu.mEZ;
                FreeWifiFrontPageUI$d freeWifiFrontPageUI$d2 = FreeWifiFrontPageUI$d.SUCCESS;
                FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                bVar.mHz = aMc;
                freeWifiFrontPageUI2.a(freeWifiFrontPageUI$d2, bVar);
                return;
            }
            freeWifiFrontPageUI = this.mFw.mFu.mEZ;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.mHb = m.a(this.mFw.mFu.mFb, b.mCL, 20);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
        } else if (i2 == -30032) {
            Intent intent = new Intent();
            intent.putExtra("free_wifi_error_ui_error_msg", this.mFw.mFu.mEZ.getString(R.l.ejD));
            intent.setClass(this.mFw.mFu.mEZ, FreeWifiErrorUI.class);
            this.mFw.mFu.mEZ.finish();
            this.mFw.mFu.mEZ.startActivity(intent);
        } else {
            freeWifiFrontPageUI = this.mFw.mFu.mEZ;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.jCk = R.l.ejA;
            aVar.mHb = m.a(this.mFw.mFu.mFb, b.mCL, i2);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
        }
    }
}
