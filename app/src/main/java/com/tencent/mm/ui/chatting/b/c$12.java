package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ag.e$a$a;
import com.tencent.mm.ag.e$a$b;
import com.tencent.mm.ag.e.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$12 implements a {
    final /* synthetic */ c yyQ;

    c$12(c cVar) {
        this.yyQ = cVar;
    }

    public final void a(e$a$b com_tencent_mm_ag_e_a_b) {
        if (com_tencent_mm_ag_e_a_b != null && com_tencent_mm_ag_e_a_b.hpD == e$a$a.hpB && com_tencent_mm_ag_e_a_b.hog != null && com_tencent_mm_ag_e_a_b.hog.equals(this.yyQ.fhr.crz())) {
            ar.Hg();
            com.tencent.mm.l.a WO = c.EY().WO(com_tencent_mm_ag_e_a_b.hog);
            if (WO == null || ((int) WO.gJd) == 0) {
                x.i("MicroMsg.ChattingUI.BizMgr", "Get contact from db return null.(username : %s)", new Object[]{com_tencent_mm_ag_e_a_b.hog});
                return;
            }
            ag.y(new 1(this, com_tencent_mm_ag_e_a_b, WO));
        }
    }
}
