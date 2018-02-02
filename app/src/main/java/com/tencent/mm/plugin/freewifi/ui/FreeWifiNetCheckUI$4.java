package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.k$a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiNetCheckUI$4 implements e {
    final /* synthetic */ String jde;
    final /* synthetic */ FreeWifiNetCheckUI mIe;
    final /* synthetic */ String mIf;
    final /* synthetic */ String mIg;

    FreeWifiNetCheckUI$4(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2, String str3) {
        this.mIe = freeWifiNetCheckUI;
        this.mIf = str;
        this.mIg = str2;
        this.jde = str3;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            wi aLZ = ((h) kVar).aLZ();
            if (aLZ != null) {
                Intent intent = this.mIe.getIntent();
                intent.putExtra("free_wifi_appid", aLZ.nkv);
                intent.putExtra("free_wifi_head_img_url", aLZ.nfZ);
                intent.putExtra("free_wifi_welcome_msg", aLZ.wgH);
                intent.putExtra("free_wifi_welcome_sub_title", aLZ.nfL);
                intent.putExtra("free_wifi_privacy_url", aLZ.wgI);
                intent.putExtra("free_wifi_app_nickname", aLZ.kub);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", this.mIf);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", this.mIg);
                intent.setClass(this.mIe, FreeWifiPcUI.class);
                this.mIe.finish();
                this.mIe.startActivity(intent);
            }
        } else if (!m.cA(i, i2) || m.AA(str)) {
            FreeWifiNetCheckUI.a(this.mIe, this.mIe.getString(R.l.ejE), this.mIe.getString(R.l.ejF));
        } else {
            FreeWifiNetCheckUI.a(this.mIe, str + "(" + m.a(m.F(FreeWifiNetCheckUI.b(this.mIe)), b.mDd, i2) + ")", "");
        }
        k$a aLe = com.tencent.mm.plugin.freewifi.k.aLe();
        aLe.mCs = this.mIf;
        aLe.mCt = this.jde;
        aLe.mCu = this.mIg;
        aLe.mCw = b.mDd.mDi;
        aLe.mCx = b.mDd.name;
        aLe.result = i2;
        aLe.aLg().aLf();
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", new Object[]{m.D(this.mIe.getIntent()), Integer.valueOf(m.E(this.mIe.getIntent())), Integer.valueOf(i2)});
    }
}
