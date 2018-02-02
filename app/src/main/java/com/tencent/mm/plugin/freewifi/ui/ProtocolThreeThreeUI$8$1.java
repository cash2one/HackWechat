package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.8;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeThreeUI$8$1 implements e {
    final /* synthetic */ 8 mIV;

    ProtocolThreeThreeUI$8$1(8 8) {
        this.mIV = 8;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.D(this.mIV.mIT.getIntent()), Integer.valueOf(m.E(this.mIV.mIT.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            ei aMc = ((f) kVar).aMc();
            if (aMc != null) {
                x.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw});
                this.mIV.mIT.mFc = aMc.kub;
                this.mIV.mIT.fvL = aMc.ksU;
                this.mIV.mIT.mIq = aMc.vJH;
                this.mIV.mIT.mIr = aMc.vJI;
                this.mIV.mIT.signature = aMc.hvw;
                this.mIV.mIT.mIs = aMc.vJJ;
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.D(this.mIV.mIT.getIntent()), Integer.valueOf(m.E(this.mIV.mIT.getIntent())), this.mIV.mIT.appId, this.mIV.mIT.mFc, this.mIV.mIT.fvL, Integer.valueOf(this.mIV.mIT.mIq), this.mIV.mIT.mIr, this.mIV.mIT.signature, this.mIV.mIT.mIs});
            }
            d.a(this.mIV.mIT.ssid, 2, this.mIV.mIT.getIntent());
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.D(this.mIV.mIT.getIntent()), Integer.valueOf(m.E(this.mIV.mIT.getIntent())), Integer.valueOf(2)});
        } else if (i2 == -30032) {
            Intent intent = new Intent();
            intent.putExtra("free_wifi_error_ui_error_msg", this.mIV.mIT.getString(R.l.ejD));
            intent.setClass(this.mIV.mIT, FreeWifiErrorUI.class);
            this.mIV.mIT.finish();
            this.mIV.mIT.startActivity(intent);
        } else {
            d.a(this.mIV.mIT.ssid, 3, this.mIV.mIT.getIntent());
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", new Object[]{m.D(this.mIV.mIT.getIntent()), Integer.valueOf(m.E(this.mIV.mIT.getIntent())), Integer.valueOf(i2)});
        }
    }
}
