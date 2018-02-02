package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgv;
import com.tencent.mm.protocal.c.bgw;
import com.tencent.mm.sdk.platformtools.x;

public final class aj extends w {
    public int cmdId;
    private String vfb;

    public aj(String str, int i, String str2) {
        a aVar = new a();
        aVar.hmj = new bgv();
        aVar.hmk = new bgw();
        aVar.uri = "/cgi-bin/micromsg-bin/setappsetting";
        aVar.hmi = 396;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        bgv com_tencent_mm_protocal_c_bgv = (bgv) this.lMW.hmg.hmo;
        com_tencent_mm_protocal_c_bgv.nfn = str;
        com_tencent_mm_protocal_c_bgv.wKY = i;
        com_tencent_mm_protocal_c_bgv.wKZ = str2;
        this.cmdId = i;
        this.vfb = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i2 == 0) {
            bgw com_tencent_mm_protocal_c_bgw = (bgw) this.lMW.hmh.hmo;
            if (com_tencent_mm_protocal_c_bgw != null) {
                i biq = com.tencent.mm.plugin.y.a.a.a.bis().biq();
                f aZ = g.aZ(com_tencent_mm_protocal_c_bgw.nfn, false);
                if (aZ != null) {
                    aZ.field_authFlag = com_tencent_mm_protocal_c_bgw.vIl;
                    x.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + biq.a(aZ, new String[0]) + ", appId = " + com_tencent_mm_protocal_c_bgw.nfn);
                }
            }
        }
    }

    public final byte[] aQX() {
        try {
            return ((b) this.lMW.Kb()).Hq();
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ax(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
            return;
        }
        try {
            this.lMW.hmh.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 2;
    }
}
