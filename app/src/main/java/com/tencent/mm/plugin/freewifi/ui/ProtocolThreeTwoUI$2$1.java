package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.2;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$2$1 implements e {
    final /* synthetic */ 2 mIX;

    ProtocolThreeTwoUI$2$1(2 2) {
        this.mIX = 2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.D(this.mIX.mIW.getIntent()), Integer.valueOf(m.E(this.mIX.mIW.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            ei aMc = ((a) kVar).aMc();
            if (aMc != null) {
                x.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw});
                this.mIX.mIW.fFm = aMc.nkv;
                this.mIX.mIW.mFc = aMc.kub;
                this.mIX.mIW.fvL = aMc.ksU;
                this.mIX.mIW.mIq = aMc.vJH;
                this.mIX.mIW.mIr = aMc.vJI;
                this.mIX.mIW.signature = aMc.hvw;
                this.mIX.mIW.mIs = aMc.vJJ;
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.D(this.mIX.mIW.getIntent()), Integer.valueOf(m.E(this.mIX.mIW.getIntent())), this.mIX.mIW.fFm, this.mIX.mIW.mFc, this.mIX.mIW.fvL, Integer.valueOf(this.mIX.mIW.mIq), this.mIX.mIW.mIr, this.mIX.mIW.signature, this.mIX.mIW.mIs});
            }
            d.a(this.mIX.mIW.ssid, 2, this.mIX.mIW.getIntent());
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.D(this.mIX.mIW.getIntent()), Integer.valueOf(m.E(this.mIX.mIW.getIntent())), Integer.valueOf(2)});
        }
    }
}
