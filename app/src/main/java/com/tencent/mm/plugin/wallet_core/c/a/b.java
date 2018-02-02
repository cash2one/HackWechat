package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.c.l;

public final class b extends l {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;
    public String jumpUrl;
    public int sIZ = 0;

    public b() {
        boolean booleanValue;
        a aVar = new a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_avz = new avz();
        g.Dk();
        Object obj = g.Dj().CU().get(w.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        com_tencent_mm_protocal_c_avz.wDz = booleanValue ? 1 : 0;
        aVar.hmj = com_tencent_mm_protocal_c_avz;
        aVar.hmk = new awa();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        aVar.hmi = 1564;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        awa com_tencent_mm_protocal_c_awa = (awa) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(com_tencent_mm_protocal_c_awa.lOr), com_tencent_mm_protocal_c_awa.lOs);
            str = com_tencent_mm_protocal_c_awa.lOs;
            i2 = com_tencent_mm_protocal_c_awa.lOr;
            this.jumpUrl = com_tencent_mm_protocal_c_awa.nfg;
            this.sIZ = com_tencent_mm_protocal_c_awa.wDA;
        } else {
            x.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
            this.jumpUrl = null;
        }
        if (bh.ov(str)) {
            str = ac.getContext().getString(i.uRf);
        }
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 1564;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
