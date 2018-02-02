package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.avy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class a extends l {
    private b gJQ;
    private e gJT;
    public String jumpUrl;
    public String prepayId;
    public String tan;
    public String tay;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new avx();
        aVar.hmk = new avy();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggenprepay";
        this.gJQ = aVar.JZ();
        avx com_tencent_mm_protocal_c_avx = (avx) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_avx.ngo = str;
        com_tencent_mm_protocal_c_avx.vWh = str4;
        com_tencent_mm_protocal_c_avx.vWg = str2;
        com_tencent_mm_protocal_c_avx.vWi = str5;
        com_tencent_mm_protocal_c_avx.vWj = str6;
        com_tencent_mm_protocal_c_avx.vLX = str3;
        com_tencent_mm_protocal_c_avx.vVu = str7;
        com_tencent_mm_protocal_c_avx.whp = str8;
        com_tencent_mm_protocal_c_avx.vDY = i;
        x.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str2, str5, str6, str3, str7, str8}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        avy com_tencent_mm_protocal_c_avy = (avy) ((b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(com_tencent_mm_protocal_c_avy.lOr), com_tencent_mm_protocal_c_avy.lOs);
            str = com_tencent_mm_protocal_c_avy.lOs;
            i2 = com_tencent_mm_protocal_c_avy.lOr;
            this.jumpUrl = com_tencent_mm_protocal_c_avy.nfg;
            this.prepayId = com_tencent_mm_protocal_c_avy.whq;
            this.tan = com_tencent_mm_protocal_c_avy.whr;
            this.tay = com_tencent_mm_protocal_c_avy.wDy;
        } else {
            x.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
            this.jumpUrl = null;
        }
        if (bh.ov(str)) {
            str = ac.getContext().getString(i.uRf);
        }
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 1563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
