package com.tencent.mm.ui.friend;

import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.ae;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.friend.a.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class e$2 implements a {
    final /* synthetic */ e zda;

    e$2(e eVar) {
        this.zda = eVar;
    }

    public final void ZN(String str) {
        ae OI = af.OI();
        ad lc = OI.lc(str);
        if (lc == null) {
            x.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[]{str});
            return;
        }
        lc.hwS = 2;
        OI.a(lc.hwR, lc);
        this.zda.notifyDataSetChanged();
        ar.Hg();
        com.tencent.mm.g.b.af WO = c.EY().WO(str);
        if (WO == null) {
            ad lc2 = af.OI().lc(str);
            if (lc2 != null) {
                lc2.OB();
                x.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + lc2.hwR);
                af.OI().a(lc2.hwR, lc2);
            }
        } else if (!((WO.field_conRemark != null && !WO.field_conRemark.equals("")) || lc == null || lc.Oy() == null || lc.Oy().equals(""))) {
            s.b(WO, lc.Oy());
        }
        bo.HS().c(26, new Object[0]);
    }

    public final void bp(String str, boolean z) {
        if (z) {
            ad lc = af.OI().lc(str);
            if (lc != null) {
                lc.OB();
                x.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + lc.hwR);
                af.OI().a(lc.hwR, lc);
            } else {
                x.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[]{str});
            }
        }
        this.zda.notifyDataSetChanged();
    }
}
