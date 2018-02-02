package com.tencent.mm.plugin.wallet_core.c;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class b extends l {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;
    public int sIh;
    public ns sIi;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        this(str, str2, str3, str4, str5, str6, str7, 5, str8, i);
    }

    private b(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2) {
        this.sIh = 0;
        this.sIh = 5;
        a aVar = new a();
        aVar.hmj = new nr();
        aVar.hmk = new ns();
        aVar.uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
        aVar.hmi = 2728;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        nr nrVar = (nr) this.gJQ.hmg.hmo;
        nrVar.ngo = str;
        nrVar.vLX = str2;
        nrVar.vWg = str3;
        nrVar.vWh = str4;
        nrVar.vWj = str5;
        nrVar.vWi = str6;
        nrVar.vVu = str7;
        nrVar.vWk = 5;
        nrVar.vQS = i.bLf();
        nrVar.vGR = 1;
        nrVar.ksU = null;
        nrVar.nkx = null;
        nrVar.vWn = str8;
        nrVar.vWm = i2;
        boolean aJW = ((com.tencent.mm.pluginsdk.l) g.h(com.tencent.mm.pluginsdk.l.class)).aJW();
        SharedPreferences cft = ac.cft();
        String str9 = null;
        String str10 = null;
        if (cft != null) {
            str9 = cft.getString("cpu_id", null);
            str10 = cft.getString("uid", null);
        }
        nrVar.vWz = 0;
        nrVar.rSm = str9;
        nrVar.rSn = str10;
        nrVar.vWA = aJW ? 1 : 0;
        x.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[]{str9, str10});
        x.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[]{str, str7, Integer.valueOf(5), Boolean.valueOf(aJW)});
    }

    public final int getType() {
        return 580;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            this.sIi = (ns) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
            nr nrVar = (nr) ((com.tencent.mm.ae.b) qVar).hmg.hmo;
            if (nrVar.vVu != null) {
                if (Uri.parse(nrVar.vVu).getQueryParameter("appid") != nrVar.ngo) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{this.sIi.vzI, "", Integer.valueOf(nrVar.vWk), nrVar.vWn, nrVar.ngo, Integer.valueOf(nrVar.vGR), Integer.valueOf(nrVar.vWm), nrVar.vVu, r1});
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{this.sIi.vzI, "", Integer.valueOf(nrVar.vWk), nrVar.vWn, nrVar.ngo, Integer.valueOf(nrVar.vGR), Integer.valueOf(nrVar.vWm), nrVar.vVu});
                }
            } else if (!(nrVar.ksU == null || nrVar.nkx == null)) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{this.sIi.vzI, "", Integer.valueOf(nrVar.vWk), nrVar.vWn, nrVar.ngo, Integer.valueOf(nrVar.vGR), Integer.valueOf(nrVar.vWm), nrVar.nkx, nrVar.ksU});
            }
            x.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.sIi.lOr + " resp.ErrMsg is " + this.sIi.lOs);
            str = this.sIi.lOs;
        }
        this.gJT.a(i, i2, str, this);
    }
}
