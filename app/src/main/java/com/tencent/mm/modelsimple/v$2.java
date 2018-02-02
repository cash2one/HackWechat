package com.tencent.mm.modelsimple;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd.a;

class v$2 implements a {
    final /* synthetic */ v hNE;
    final /* synthetic */ e hNG;

    v$2(v vVar, e eVar) {
        this.hNE = vVar;
        this.hNG = eVar;
    }

    public final void a(com.tencent.mm.network.e eVar) {
        if (eVar == null || eVar.Kx() == null || this.hNG.hZs == null || this.hNG.vAZ == null || this.hNG.vAZ.wRq == null) {
            d.pPH.a(148, 8, 1, false);
            x.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
            return;
        }
        x.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, uin:%d", new Object[]{bh.VT(bh.bv(this.hNG.hZs)), Integer.valueOf(this.hNG.vAZ.wRq.lOd)});
        eVar.Kx().v(this.hNG.hZs, this.hNG.vAZ.wRq.lOd);
    }
}
