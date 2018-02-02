package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.c.aaa;
import com.tencent.mm.protocal.c.zz;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class y extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public y() {
        a aVar = new a();
        aVar.hmj = new zz();
        aVar.hmk = new aaa();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardcount";
        aVar.hmi = 663;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 663;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aaa com_tencent_mm_protocal_c_aaa = (aaa) this.gJQ.hmh.hmo;
            x.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + com_tencent_mm_protocal_c_aaa.wjr + " has_share_card:" + com_tencent_mm_protocal_c_aaa.wjs);
            if (com_tencent_mm_protocal_c_aaa.wjr > 0) {
                l.axe();
                ar.Hg();
                if (TextUtils.isEmpty((String) c.CU().get(w.a.xoh, null))) {
                    am.auz();
                    com.tencent.mm.plugin.card.a.b.nF(1);
                }
            }
            if (com_tencent_mm_protocal_c_aaa.wjs > 0) {
                l.axg();
                ar.Hg();
                Long l = (Long) c.CU().get(w.a.xor, Long.valueOf(0));
                if (l != null && l.longValue() == 0) {
                    am.auH().auR();
                }
            }
        }
        ar.Hg();
        c.CU().set(282882, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        this.gJT.a(i2, i3, str, this);
    }
}
