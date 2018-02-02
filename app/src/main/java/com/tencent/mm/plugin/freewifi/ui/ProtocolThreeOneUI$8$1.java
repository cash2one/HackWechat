package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.8;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeOneUI$8$1 implements e {
    final /* synthetic */ 8 mIS;

    ProtocolThreeOneUI$8$1(8 8) {
        this.mIS = 8;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.D(this.mIS.mIQ.getIntent()), Integer.valueOf(m.E(this.mIS.mIQ.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            ei aMc = ((a) kVar).aMc();
            if (aMc != null) {
                x.i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw});
                this.mIS.mIQ.fFm = aMc.nkv;
                this.mIS.mIQ.mFc = aMc.kub;
                this.mIS.mIQ.fvL = aMc.ksU;
                this.mIS.mIQ.mIq = aMc.vJH;
                this.mIS.mIQ.mIr = aMc.vJI;
                this.mIS.mIQ.signature = aMc.hvw;
                this.mIS.mIQ.mIs = aMc.vJJ;
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.D(this.mIS.mIQ.getIntent()), Integer.valueOf(m.E(this.mIS.mIQ.getIntent())), this.mIS.mIQ.fFm, this.mIS.mIQ.mFc, this.mIS.mIQ.fvL, Integer.valueOf(this.mIS.mIQ.mIq), this.mIS.mIQ.mIr, this.mIS.mIQ.signature, this.mIS.mIQ.mIs});
            }
            d.a(this.mIS.mIQ.ssid, 2, this.mIS.mIQ.getIntent());
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.D(this.mIS.mIQ.getIntent()), Integer.valueOf(m.E(this.mIS.mIQ.getIntent())), Integer.valueOf(2)});
        }
    }
}
