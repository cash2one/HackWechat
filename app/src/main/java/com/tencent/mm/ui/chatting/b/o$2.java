package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

class o$2 implements a {
    final /* synthetic */ o yAu;

    o$2(o oVar) {
        this.yAu = oVar;
    }

    public final boolean uF() {
        c.MR();
        boolean MS = c.MS();
        int lastVisiblePosition = this.yAu.fhr.csx().getLastVisiblePosition() - this.yAu.fhr.csx().getHeaderViewsCount();
        int max = Math.max(this.yAu.fhr.csx().getFirstVisiblePosition() - this.yAu.fhr.csx().getHeaderViewsCount(), 0);
        int max2 = Math.max(Math.min(lastVisiblePosition, this.yAu.fhr.csy().getCount()), 0);
        x.d("MicroMsg.ChattingUI.GetImageImp", "first: " + max + " last: " + max2);
        if (max2 < max) {
            x.d("MicroMsg.ChattingUI.GetImageImp", "start timer to wait listview refresh");
            this.yAu.yAs.J(1000, 1000);
        } else {
            o.Px().hzH = true;
            for (int i = max; i <= max2; i++) {
                au auVar = (au) this.yAu.fhr.csy().getItem(i);
                if (auVar != null && auVar.field_isSend == 0 && auVar.cje()) {
                    e bh = o.Pw().bh(auVar.field_msgSvrId);
                    if (!(bh.Pd() || auVar.gjP == 2)) {
                        if (auVar.gjP != 1) {
                            if (MS) {
                                c.MR();
                                if (!c.l(auVar)) {
                                }
                            }
                        }
                        g.MJ().hsy.add("image_" + auVar.field_msgId);
                        o.Px().a(bh.hzP, auVar.field_msgId, 0, Integer.valueOf(i), R.g.bAH, this.yAu);
                    }
                }
            }
            o.Px().Pc();
        }
        return false;
    }
}
