package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;

public final class g extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT;
    private aic nFB = null;
    public aid nFC = null;

    public g(int i) {
        a aVar = new a();
        aVar.hmj = new aic();
        aVar.hmk = new aid();
        aVar.hmi = 257;
        aVar.uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nFB = (aic) this.gJQ.hmg.hmo;
        this.nFB.rYW = i;
        aic com_tencent_mm_protocal_c_aic = this.nFB;
        ar.Hg();
        com_tencent_mm_protocal_c_aic.wpp = ((Integer) c.CU().get(w.a.xpy, Integer.valueOf(0))).intValue();
        com_tencent_mm_protocal_c_aic = this.nFB;
        ar.Hg();
        com_tencent_mm_protocal_c_aic.wpq = ((Integer) c.CU().get(w.a.xpm, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[]{Integer.valueOf(this.nFB.rYW), Integer.valueOf(this.nFB.wpp), Integer.valueOf(this.nFB.wpq)});
    }

    public final int getType() {
        return 257;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.nFC = (aid) ((b) qVar).hmh.hmo;
        if ((i2 == 0 || i3 == 0) && i2 == 0 && i3 == 0) {
            aid com_tencent_mm_protocal_c_aid = this.nFC;
            if (com_tencent_mm_protocal_c_aid != null) {
                x.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[]{com_tencent_mm_protocal_c_aid.wpu, com_tencent_mm_protocal_c_aid.wpv, com_tencent_mm_protocal_c_aid.wpr, com_tencent_mm_protocal_c_aid.nGK, com_tencent_mm_protocal_c_aid.fon, com_tencent_mm_protocal_c_aid.nfe, com_tencent_mm_protocal_c_aid.wps, com_tencent_mm_protocal_c_aid.wpt, com_tencent_mm_protocal_c_aid.wpw, com_tencent_mm_protocal_c_aid.wpC});
                try {
                    ar.Hg();
                    c.CU().a(w.a.xqs, bh.by(com_tencent_mm_protocal_c_aid.toByteArray()));
                } catch (IOException e) {
                    x.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[]{e.getMessage()});
                }
            }
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
