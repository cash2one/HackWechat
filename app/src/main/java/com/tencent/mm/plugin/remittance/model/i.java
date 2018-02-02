package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;

public final class i extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public iu pKw;

    public i(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6, int i4, int i5, String str7, vu vuVar, String str8, int i6) {
        a aVar = new a();
        aVar.hmj = new it();
        aVar.hmk = new iu();
        aVar.hmi = 1633;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        it itVar = (it) this.hNJ.hmg.hmo;
        itVar.pLn = str;
        itVar.vOW = URLDecoder.decode(str2);
        itVar.scene = i;
        itVar.vOX = str3;
        itVar.pLh = str4;
        itVar.vHv = i2;
        itVar.fCR = i3;
        itVar.pLi = str5;
        itVar.pLo = str6;
        itVar.pLm = i4;
        itVar.vHu = str7;
        if (vuVar != null) {
            itVar.vHt = vuVar;
        }
        itVar.vOQ = str8;
        itVar.pKd = i6;
        if (i5 == 1) {
            WifiInfo wifiInfo = an.getWifiInfo(ac.getContext());
            if (wifiInfo != null) {
                itVar.vOY = wifiInfo.getBSSID();
            } else {
                x.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
            }
            itVar.vOZ = 0;
        }
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), str2, Integer.valueOf(i5), a.a(vuVar)});
    }

    public final int getType() {
        return 1633;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pKw = (iu) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s", new Object[]{Integer.valueOf(this.pKw.kLO), this.pKw.kLP, this.pKw.vHr, this.pKw.vHq, Integer.valueOf(this.pKw.vPe), this.pKw.vHs, this.pKw.fwY});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
