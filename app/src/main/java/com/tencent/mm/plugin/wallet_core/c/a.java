package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.protocal.c.ni;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.o;

public final class a extends l {
    public b gJQ;
    private e gJT;
    public int sIh;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2) {
        this.sIh = 0;
        this.sIh = i;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new nh();
        aVar.hmk = new ni();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.hmi = 580;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        nh nhVar = (nh) this.gJQ.hmg.hmo;
        nhVar.ngo = str;
        nhVar.vLX = str2;
        nhVar.vWg = str3;
        nhVar.vWh = str4;
        nhVar.vWj = str5;
        nhVar.vWi = str6;
        nhVar.vVu = str7;
        nhVar.vWk = i;
        nhVar.vQS = i.bLf();
        if (o.cBs()) {
            nhVar.vWl = o.cBu();
        }
        nhVar.vGR = 1;
        nhVar.vWn = str8;
        nhVar.vWm = i2;
        x.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[]{str, str7, Integer.valueOf(i)});
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i) {
        this.sIh = 0;
        this.sIh = 16;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new nh();
        aVar.hmk = new ni();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.hmi = 580;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        nh nhVar = (nh) this.gJQ.hmg.hmo;
        nhVar.ngo = str;
        nhVar.vLX = str2;
        nhVar.vWg = str3;
        nhVar.vWh = str4;
        nhVar.vWj = str5;
        nhVar.vWi = str6;
        nhVar.vWk = 16;
        nhVar.ksU = str7;
        nhVar.nkx = str8;
        nhVar.vGR = 2;
        nhVar.vWn = str9;
        nhVar.vWm = i;
        nhVar.vQS = i.bLf();
        if (o.cBs()) {
            nhVar.vWl = o.cBu();
        }
        x.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[]{str, str7, str8});
    }

    public final int getType() {
        return 580;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            ni niVar = (ni) ((b) qVar).hmh.hmo;
            x.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + niVar.lOr + " resp.ErrMsg is " + niVar.lOs);
            nh nhVar = (nh) ((b) qVar).hmg.hmo;
            if (nhVar.vVu != null) {
                if (Uri.parse(nhVar.vVu).getQueryParameter("appid") != nhVar.ngo) {
                    g.pQN.h(14954, new Object[]{niVar.vzI, "", Integer.valueOf(nhVar.vWk), nhVar.vWn, nhVar.ngo, Integer.valueOf(nhVar.vGR), Integer.valueOf(nhVar.vWm), nhVar.vVu, r2});
                } else {
                    g.pQN.h(14954, new Object[]{niVar.vzI, "", Integer.valueOf(nhVar.vWk), nhVar.vWn, nhVar.ngo, Integer.valueOf(nhVar.vGR), Integer.valueOf(nhVar.vWm), nhVar.vVu});
                }
            } else if (!(nhVar.ksU == null || nhVar.nkx == null)) {
                g.pQN.h(14954, new Object[]{niVar.vzI, "", Integer.valueOf(nhVar.vWk), nhVar.vWn, nhVar.ngo, Integer.valueOf(nhVar.vGR), Integer.valueOf(nhVar.vWm), nhVar.nkx, nhVar.ksU});
            }
            x.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + niVar.lOr + " resp.ErrMsg is " + niVar.lOs);
            str = niVar.lOs;
        }
        this.gJT.a(i, i2, str, this);
    }

    public final String bhV() {
        return ((ni) this.gJQ.hmh.hmo).token;
    }

    public final String bKH() {
        return ((ni) this.gJQ.hmh.hmo).vzI;
    }
}
