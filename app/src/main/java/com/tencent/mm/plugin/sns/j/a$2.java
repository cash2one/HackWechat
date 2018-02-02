package com.tencent.mm.plugin.sns.j;

import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.app.a.a;
import com.tencent.mm.z.q;

class a$2 extends a<c$a> {
    final /* synthetic */ a rRS;

    a$2(a aVar) {
        this.rRS = aVar;
        super(aVar);
    }

    protected final /* synthetic */ Object WN() {
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", new Object[]{c$a.class});
        com.tencent.mm.vending.app.a aVar = this.rRS;
        c$a com_tencent_mm_plugin_sns_j_c_a = new c$a();
        aVar.rIc = aVar.zAZ.getIntExtra("sns_source", 0);
        aVar.jKk = aVar.zAZ.getStringExtra("sns_userName");
        if (aVar.jKk == null) {
            aVar.jKk = "";
        }
        g.Dk();
        aVar.rIb = ((h) g.h(h.class)).EY().WK(aVar.jKk);
        aVar.rIa = q.FS();
        aVar.rtl = aVar.rIa.equals(aVar.jKk);
        ar bvj = ae.bvj();
        String az = bh.az(aVar.zAZ.getStringExtra("sns_signature"), "");
        String az2 = bh.az(aVar.zAZ.getStringExtra("sns_nickName"), "");
        af WO = (aVar.jKk == null || aVar.jKk.equals("")) ? bvj.WO(aVar.rIa) : bvj.WO(aVar.jKk);
        if (WO != null && ((int) WO.gJd) > 0) {
            az = WO.signature;
            az2 = WO.AP();
            x.i("MicroMsg.SnsTimelineInteractor", "contact:user[%s] id[%d] nickname[%s]", new Object[]{WO.field_username, Integer.valueOf((int) WO.gJd), az2});
        }
        com_tencent_mm_plugin_sns_j_c_a.jKk = aVar.jKk;
        com_tencent_mm_plugin_sns_j_c_a.rIa = aVar.rIa;
        com_tencent_mm_plugin_sns_j_c_a.rIb = aVar.rIb;
        com_tencent_mm_plugin_sns_j_c_a.rtl = aVar.rtl;
        com_tencent_mm_plugin_sns_j_c_a.rIc = aVar.rIc;
        com_tencent_mm_plugin_sns_j_c_a.nlp = az2;
        com_tencent_mm_plugin_sns_j_c_a.rLk = az;
        return com_tencent_mm_plugin_sns_j_c_a;
    }
}
