package com.tencent.mm.plugin.sns.a.b;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.az;
import com.tencent.mm.protocal.c.ba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;

    public c(String str, String str2) {
        this(str, 18, 5, str2, 2, -1);
    }

    public c(String str, int i, int i2, String str2, int i3, long j) {
        this(str, i, i2, str2, i3, "", j);
    }

    public c(String str, int i, int i2, String str2, int i3, String str3) {
        this(str, i, i2, str2, i3, 0, 0, "", str3);
    }

    private c(String str, int i, int i2, String str2, int i3, String str3, long j) {
        this(str, i, i2, str2, i3, 0, str3, n.qQE.en(j), 0);
    }

    private c(String str, int i, int i2, String str2, int i3, int i4, String str3, int i5, int i6) {
        a aVar = new a();
        aVar.hmj = new az();
        aVar.hmk = new ba();
        if (i5 != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/click";
            aVar.hmi = 1232;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adclick";
            aVar.hmi = 1817;
        }
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.NetSceneAdClick", "uri %s", new Object[]{this.gJQ.uri});
        x.i("MicroMsg.NetSceneAdClick", "NetSceneAdClick clickPos: " + i + " viewId: " + str + " sceneType: " + i2 + " adtype " + i3 + ", clickAction " + i4 + ",source " + i5 + ", descXml " + str2);
        if (!bh.ov(str2)) {
            x.i("MicroMsg.NetSceneAdClick", "descXml: " + str2);
        }
        az azVar = (az) this.gJQ.hmg.hmo;
        azVar.hOx = i;
        azVar.hOt = str;
        azVar.scene = i2;
        azVar.vGc = str2;
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                azVar.bssid = bh.az(connectionInfo.getBSSID(), "");
                azVar.ssid = bh.az(connectionInfo.getSSID(), "");
            }
        }
        azVar.vGd = System.currentTimeMillis();
        azVar.vGf = i3;
        azVar.vGg = i4;
        azVar.cOY = i5;
        azVar.vGh = str3;
        azVar.vGi = i6;
    }

    public c(String str, int i, int i2, String str2, int i3, int i4, int i5, String str3, String str4) {
        this(str, i, i2, str2, i3, i4, str3, str4, 0);
    }

    public c(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4, int i5) {
        this(str, i, i2, str2, i3, i4, str3, n.qQE.JB(str4), i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 1232;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAdClick", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gJT.a(i2, i3, str, this);
    }
}
