package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axc;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Map;

public final class f extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    boolean kAN = false;

    public f() {
        a aVar = new a();
        aVar.hmj = new axc();
        aVar.hmk = new axd();
        aVar.uri = "/cgi-bin/micromsg-bin/pickbottle";
        aVar.hmi = 155;
        aVar.hml = 54;
        aVar.hmm = 1000000054;
        this.gJQ = aVar.JZ();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 155;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetScenePickBottle", "onGYNetEnd type:" + i2 + " code:" + i3);
        if (i2 == 4 && (i3 == -2002 || i3 == -56)) {
            c.ng(0);
            c.nh(0);
        }
        axd com_tencent_mm_protocal_c_axd = (axd) this.gJQ.hmh.hmo;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.nh(com_tencent_mm_protocal_c_axd.wjm);
                    c.ng(com_tencent_mm_protocal_c_axd.wjl);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            this.kAN = true;
            x.d("MicroMsg.NetScenePickBottle", "bottle pack:pack:" + com_tencent_mm_protocal_c_axd.wjm + " throw:" + com_tencent_mm_protocal_c_axd.wjl);
            String[] strArr = null;
            if (com_tencent_mm_protocal_c_axd.wCw != null) {
                strArr = com_tencent_mm_protocal_c_axd.wCw.split(":");
            }
            if (strArr != null && strArr.length >= 2) {
                String str2 = strArr[0];
                ar.Hg();
                af WO = c.EY().WO(str2);
                if (WO == null || !WO.field_username.equals(str2)) {
                    af xVar = new com.tencent.mm.storage.x();
                    xVar.setUsername(str2);
                    xVar.dc(com_tencent_mm_protocal_c_axd.kub == null ? "" : com_tencent_mm_protocal_c_axd.kub);
                    xVar.eC(3);
                    h hVar = new h();
                    hVar.username = str2;
                    hVar.fWe = 3;
                    hVar.bA(true);
                    hVar.fDt = -1;
                    try {
                        Map y = bi.y(com_tencent_mm_protocal_c_axd.wli, "userinfo");
                        if (y != null) {
                            xVar.eD(bh.getInt((String) y.get(".userinfo.$sex"), 0));
                            xVar.dp((String) y.get(".userinfo.$signature"));
                            xVar.dv(RegionCodeDecoder.ah((String) y.get(".userinfo.$country"), (String) y.get(".userinfo.$province"), (String) y.get(".userinfo.$city")));
                            x.d("MicroMsg.NetScenePickBottle", "user:" + str2 + " sig:" + xVar.signature + " sex" + xVar.fWf + " city:" + xVar.getCity() + " prov:" + xVar.getProvince());
                            hVar.hly = (String) y.get(".userinfo.$bigheadimgurl");
                            hVar.hlx = (String) y.get(".userinfo.$smallheadimgurl");
                            hVar.fDt = -1;
                            x.d("MicroMsg.NetScenePickBottle", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{str2, hVar.JG(), hVar.JH()});
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.NetScenePickBottle", "Set Contact failed " + e.getMessage() + " user:" + str2);
                    }
                    ar.Hg();
                    c.EY().P(xVar);
                    n.JQ().a(hVar);
                }
            }
            x.d("MicroMsg.NetScenePickBottle", "getBottleType " + com_tencent_mm_protocal_c_axd.wEq);
            x.d("MicroMsg.NetScenePickBottle", "getMsgType " + com_tencent_mm_protocal_c_axd.ngq);
            x.d("MicroMsg.NetScenePickBottle", "getBottleInfo " + com_tencent_mm_protocal_c_axd.wCw);
            x.d("MicroMsg.NetScenePickBottle", "getUserInfo " + com_tencent_mm_protocal_c_axd.wli);
            x.d("MicroMsg.NetScenePickBottle", "getNickName " + com_tencent_mm_protocal_c_axd.kub);
            x.d("MicroMsg.NetScenePickBottle", "getUserStatus " + com_tencent_mm_protocal_c_axd.wEr);
            x.d("MicroMsg.NetScenePickBottle", "getThrowCount " + com_tencent_mm_protocal_c_axd.wjl);
            x.d("MicroMsg.NetScenePickBottle", "getPickCount " + com_tencent_mm_protocal_c_axd.wjm);
            x.d("MicroMsg.NetScenePickBottle", "getDistance " + com_tencent_mm_protocal_c_axd.wEs);
        } else if (i3 == -56) {
            c.nh(com_tencent_mm_protocal_c_axd.wjm);
            c.nh(com_tencent_mm_protocal_c_axd.wjl);
        }
        this.gJT.a(i2, i3, str, this);
    }

    final axd arD() {
        return (axd) this.gJQ.hmh.hmo;
    }
}
