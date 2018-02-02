package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bsg;
import com.tencent.mm.protocal.c.bsh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends l {
    private int errCode;
    private final b gJQ;
    private e gJT;
    public String lyH = null;
    public String lyJ;
    public int taM = 0;

    public k(String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, String str6) {
        a aVar = new a();
        aVar.hmj = new bsg();
        aVar.hmk = new bsh();
        aVar.uri = "/cgi-bin/micromsg-bin/verifypurchase";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX;
        aVar.hml = bp.CTRL_INDEX;
        aVar.hmm = 1000000215;
        this.gJQ = aVar.JZ();
        bsg com_tencent_mm_protocal_c_bsg = (bsg) this.gJQ.hmg.hmo;
        this.lyH = str;
        com_tencent_mm_protocal_c_bsg.vIR = str;
        com_tencent_mm_protocal_c_bsg.wTB = i;
        com_tencent_mm_protocal_c_bsg.wEY = i3;
        com_tencent_mm_protocal_c_bsg.pbq = i2;
        if (!bh.ov(str6)) {
            com_tencent_mm_protocal_c_bsg.wEW = str6;
            com_tencent_mm_protocal_c_bsg.wEX = str5;
        }
        com_tencent_mm_protocal_c_bsg.wEZ = str2;
        com_tencent_mm_protocal_c_bsg.wTD = str4;
        if (str3 != null) {
            com_tencent_mm_protocal_c_bsg.wTA = new bdn().bj(str3.getBytes());
        } else {
            com_tencent_mm_protocal_c_bsg.wTA = new bdn();
        }
        com_tencent_mm_protocal_c_bsg.wTC = (int) bh.Wo();
        x.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.lyH + ",verifyType:" + i + ",palyType:" + i2 + ",payload:" + str2 + ",purchaseData:" + str3 + ",dataSignature:" + str4);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + i + "   errCode:" + i2);
        this.errCode = 0;
        if (i == 0 && i2 == 0) {
            bsh com_tencent_mm_protocal_c_bsh = (bsh) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_bsh.wJr != null) {
                this.taM = com_tencent_mm_protocal_c_bsh.wTE;
                x.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + com_tencent_mm_protocal_c_bsh.wbo);
                x.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + com_tencent_mm_protocal_c_bsh.ngX);
                this.lyJ = com_tencent_mm_protocal_c_bsh.wbo;
            }
            this.gJT.a(i, i2, str, this);
            return;
        }
        this.errCode = -1;
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
