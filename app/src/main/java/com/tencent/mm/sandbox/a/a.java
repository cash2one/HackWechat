package com.tencent.mm.sandbox.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.c.i;
import com.tencent.mm.modelsimple.an;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.pluginsdk.q$t;
import com.tencent.mm.protocal.c.agv;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class a extends k implements com.tencent.mm.network.k, q$t {
    public final b gJQ;
    private e gJT;

    public a(int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new agv();
        aVar.hmk = new agw();
        aVar.uri = "/cgi-bin/micromsg-bin/getupdateinfo";
        this.gJQ = aVar.JZ();
        agv com_tencent_mm_protocal_c_agv = (agv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_agv.wof = i;
        com_tencent_mm_protocal_c_agv.vDY = f.fdS;
        if (10012 == r.idt && r.idu > 0) {
            com_tencent_mm_protocal_c_agv.vDY = r.idu;
        }
        switch (i) {
            case 1:
                g.pQN.a(405, 3, 1, true);
                break;
            case 2:
                g.pQN.a(405, 4, 1, true);
                break;
            case 3:
                g.pQN.a(405, 5, 1, true);
                break;
            case 4:
                g.pQN.a(405, 6, 1, true);
                break;
        }
        x.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", Integer.valueOf(com_tencent_mm_protocal_c_agv.wof), Integer.valueOf(com_tencent_mm_protocal_c_agv.vDY), Integer.valueOf(f.fdS), bh.cgy());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 11;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            g.pQN.a(405, 7, 1, true);
        } else {
            g.pQN.a(405, 8, 1, true);
            if (i2 == 4) {
                g.pQN.a(405, 9, 1, true);
                if (i3 == -16) {
                    g.pQN.a(405, 10, 1, true);
                } else if (i3 == -17) {
                    g.pQN.a(405, 11, 1, true);
                } else if (i3 == -18) {
                    g.pQN.a(405, 12, 1, true);
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
        String cee = cee();
        if (cee != null) {
            i cj = i.cj(cee);
            if (cj != null) {
                x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", Integer.valueOf(cj.versionCode));
                ar.CG().a(new an(ac.getPackageName(), r0), 0);
                g.pQN.a(405, 13, 1, true);
                return;
            }
            x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", cee);
            return;
        }
        x.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
        g.pQN.a(405, 14, 1, true);
    }

    public final int cec() {
        return ((agw) this.gJQ.hmh.hmo).woi;
    }

    public final String ced() {
        return ((agw) this.gJQ.hmh.hmo).woh;
    }

    public final int bYa() {
        return ((agw) this.gJQ.hmh.hmo).wog;
    }

    public final String[] bYb() {
        agw com_tencent_mm_protocal_c_agw = (agw) this.gJQ.hmh.hmo;
        String[] strArr = new String[com_tencent_mm_protocal_c_agw.wol.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = ((bdo) com_tencent_mm_protocal_c_agw.wol.get(i)).wJF;
        }
        return strArr;
    }

    public final String cee() {
        x.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", ((agw) this.gJQ.hmh.hmo).wom, bh.cgy());
        return ((agw) this.gJQ.hmh.hmo).wom;
    }

    public final agw bYc() {
        int i = 1;
        if (SubCoreSandBox.pSd) {
            agw com_tencent_mm_protocal_c_agw = (agw) this.gJQ.hmh.hmo;
            com_tencent_mm_protocal_c_agw.won = 1;
            com_tencent_mm_protocal_c_agw.woo = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
            if (!SubCoreSandBox.pSe) {
                i = 0;
            }
            com_tencent_mm_protocal_c_agw.wop = i;
        }
        return (agw) this.gJQ.hmh.hmo;
    }
}
