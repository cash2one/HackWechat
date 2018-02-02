package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.protocal.c.yf;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class aw extends w {
    public aw(String str) {
        a aVar = new a();
        aVar.hmj = new yf();
        aVar.hmk = new yg();
        aVar.uri = "/cgi-bin/micromsg-bin/getauthapplist";
        aVar.hmi = 394;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        yf yfVar = (yf) this.lMW.hmg.hmo;
        yfVar.ktN = 1;
        yfVar.nhF = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        yg ygVar = (yg) this.lMW.hmh.hmo;
        x.i("MicroMsg.NetSceneGetAuthAppList", "errType = " + i2 + ", errCode = " + i3 + ", get authlist count = " + ygVar.wix);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ygVar.wiA;
            if (linkedList != null && linkedList.size() > 0) {
                i biq = com.tencent.mm.plugin.y.a.a.a.bis().biq();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    dt dtVar = (dt) it.next();
                    f aZ = g.aZ(dtVar.nfn, true);
                    if (aZ != null) {
                        a(aZ, dtVar);
                        x.d("MicroMsg.NetSceneGetAuthAppList", "onGYNetEnd, update ret = " + biq.a(aZ, new String[0]) + ", appId = " + aZ.field_appId);
                    } else {
                        aZ = new f();
                        aZ.field_appId = dtVar.nfn;
                        a(aZ, dtVar);
                        x.i("MicroMsg.NetSceneGetAuthAppList", "insert game appinfo:" + dtVar.nfn + ", ret = " + biq.l(aZ));
                    }
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneGetAuthAppList", "errType = " + i2 + ", errCode = " + i3);
    }

    private static void a(f fVar, dt dtVar) {
        fVar.field_appType = dtVar.vIU;
        fVar.field_appIconUrl = dtVar.nfT;
        fVar.field_appName = dtVar.niZ;
        fVar.field_authFlag = dtVar.vIl;
        fVar.cM(dtVar.vIV);
        fVar.cN(dtVar.vIW);
    }

    public final byte[] aQX() {
        try {
            return ((b) this.lMW.Kb()).Hq();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGetAuthAppList", e, "", new Object[0]);
            x.e("MicroMsg.NetSceneGetAuthAppList", "reqToBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ax(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetAuthAppList", "buf is null");
            return;
        }
        try {
            this.lMW.hmh.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAuthAppList", e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAuthAppList", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 3;
    }
}
