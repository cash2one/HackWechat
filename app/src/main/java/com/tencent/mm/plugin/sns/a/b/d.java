package com.tencent.mm.plugin.sns.a.b;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.protocal.c.bg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;

    public d(String str, int i, bg bgVar, int i2, int i3, int i4) {
        this(str, i, 1, 0, null, bgVar, i2, "", i3, i4, 0, 0, 0);
    }

    public d(String str, int i, int i2, int i3, bd bdVar, bg bgVar, int i4, String str2, int i5, int i6, int i7, int i8, int i9) {
        a aVar = new a();
        aVar.hmj = new be();
        aVar.hmk = new bf();
        if (i6 != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/exposure";
            aVar.hmi = 1231;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adexposure";
            aVar.hmi = 1875;
        }
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[]{this.gJQ.uri});
        be beVar = (be) this.gJQ.hmg.hmo;
        beVar.vGr = i3;
        beVar.type = i2;
        beVar.scene = i;
        beVar.hOt = str;
        beVar.vGu = i5;
        beVar.vGv = i7;
        beVar.vGw = i8;
        beVar.vGi = i9;
        if (bdVar != null) {
            beVar.vGs = bdVar;
            x.i("MicroMsg.NetSceneAdExposure", "exposure_info " + bdVar.vGp);
        }
        if (bgVar != null) {
            beVar.vGt = bgVar;
            x.i("MicroMsg.NetSceneAdExposure", "social_info " + bgVar.vGx + " " + bgVar.csU);
        }
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                beVar.bssid = bh.az(connectionInfo.getBSSID(), "");
                beVar.ssid = bh.az(connectionInfo.getSSID(), "");
            }
        }
        beVar.vGd = System.currentTimeMillis();
        beVar.vGf = i4;
        if (str2 != null) {
            beVar.vGc = str2;
        }
        x.i("MicroMsg.NetSceneAdExposure", "##time viewid " + str + " sceneType " + i + " type: " + i2 + " duration " + i3 + "feed_duration " + i7 + "feed_full_duration " + i8 + " ad_type " + i4 + " exposureCount " + i5 + " descXml:" + str2 + " flip_status " + i9);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 1231;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAdExposure", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bf bfVar = (bf) this.gJQ.hmh.hmo;
        x.i("MicroMsg.NetSceneAdExposure", "resp " + bfVar.ret + " msg: " + bfVar.fpb);
        this.gJT.a(i2, i3, str, this);
    }
}
