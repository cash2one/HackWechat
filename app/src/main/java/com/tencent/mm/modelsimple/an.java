package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.cbx;
import com.tencent.mm.protocal.c.cby;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class an extends k implements com.tencent.mm.network.k {
    private e gJT;
    private final b hMV;
    private int retryCount = 3;

    public an(String str, int i) {
        a aVar = new a();
        aVar.hmj = new cbx();
        aVar.hmk = new cby();
        aVar.uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
        aVar.hmi = 729;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hMV = aVar.JZ();
        cbx com_tencent_mm_protocal_c_cbx = (cbx) this.hMV.hmg.hmo;
        com_tencent_mm_protocal_c_cbx.lOo = w.cfi();
        com_tencent_mm_protocal_c_cbx.vJx = d.oSu.tX(0);
        com_tencent_mm_protocal_c_cbx.xaT = str;
        com_tencent_mm_protocal_c_cbx.nfs = i;
        x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[]{com_tencent_mm_protocal_c_cbx.lOo, str, Integer.valueOf(i), bh.cgy()});
    }

    public final int getType() {
        return 729;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hMV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        cbx com_tencent_mm_protocal_c_cbx = (cbx) this.hMV.hmg.hmo;
        cby com_tencent_mm_protocal_c_cby = (cby) this.hMV.hmh.hmo;
        x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(com_tencent_mm_protocal_c_cby.xaU), com_tencent_mm_protocal_c_cby.xaV});
        g gVar;
        Object[] objArr;
        if (i2 == 0 && i3 == 0) {
            if (com_tencent_mm_protocal_c_cby.xaU == 2 || com_tencent_mm_protocal_c_cby.xaU == 3) {
                this.retryCount--;
                if (this.retryCount <= 0) {
                    x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
                    g.pQN.a(322, 2, 1, false);
                    gVar = g.pQN;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4002);
                    objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_cbx.xaT, Integer.valueOf(com_tencent_mm_protocal_c_cbx.nfs)});
                    gVar.h(11098, objArr);
                    this.gJT.a(3, -1, "", this);
                    return;
                }
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[]{Integer.valueOf(this.retryCount)});
                a(this.hmA, this.gJT);
            } else if (com_tencent_mm_protocal_c_cby.xaU == 1) {
                MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "yyb_pkg_sig_prefs", 4).edit().remove(com_tencent_mm_protocal_c_cbx.xaT).commit();
                g.pQN.a(322, 5, 1, false);
                gVar = g.pQN;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4005);
                objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_cbx.xaT, Integer.valueOf(com_tencent_mm_protocal_c_cbx.nfs)});
                gVar.h(11098, objArr);
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[]{com_tencent_mm_protocal_c_cby.xaV});
            } else if (com_tencent_mm_protocal_c_cby.xaU == 4) {
                x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
                g.pQN.a(322, 4, 1, false);
                gVar = g.pQN;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4004);
                objArr[1] = String.format("%s,%d", new Object[]{com_tencent_mm_protocal_c_cbx.xaT, Integer.valueOf(com_tencent_mm_protocal_c_cbx.nfs)});
                gVar.h(11098, objArr);
            } else {
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[]{com_tencent_mm_protocal_c_cby.xaV});
                MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "yyb_pkg_sig_prefs", 4).edit().putString(com_tencent_mm_protocal_c_cbx.xaT, com_tencent_mm_protocal_c_cby.xaV).commit();
                g.pQN.a(322, 3, 1, false);
                gVar = g.pQN;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4003);
                objArr[1] = String.format("%s,%d,%s", new Object[]{com_tencent_mm_protocal_c_cbx.xaT, Integer.valueOf(com_tencent_mm_protocal_c_cbx.nfs), com_tencent_mm_protocal_c_cby.xaV});
                gVar.h(11098, objArr);
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
        g.pQN.a(322, 1, 1, false);
        gVar = g.pQN;
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(4001);
        objArr[1] = String.format("%s,%d,%d,%d", new Object[]{com_tencent_mm_protocal_c_cbx.xaT, Integer.valueOf(com_tencent_mm_protocal_c_cbx.nfs), Integer.valueOf(i2), Integer.valueOf(i3)});
        gVar.h(11098, objArr);
        this.gJT.a(i2, i3, str, this);
    }
}
