package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.viewitems.q.1.2;
import com.tencent.mm.z.ar;

class q$1$2$1 implements e {
    final /* synthetic */ 2 yLL;

    q$1$2$1(2 2) {
        this.yLL = 2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(1176, this);
        x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true)});
        if (this.yLL.heR != this.yLL.jLA.getTag(R.h.czI)) {
            x.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[]{Long.valueOf(this.yLL.heR.field_msgId)});
        } else if (i != 0 || i2 != 0) {
            ((aw) this.yLL.jLA.getTag(R.h.czp)).yOZ.setVisibility(8);
            u.makeText(this.yLL.jLA.getContext(), R.l.ezy, 0).show();
            b sgVar = new sg();
            sgVar.fJX.fnl = this.yLL.tIq;
            sgVar.fJX.action = 2;
            sgVar.fJX.fJZ = 1;
            a.xef.m(sgVar);
            if (q.c(this.yLL.yLJ.yLH) != null) {
                q.c(this.yLL.yLJ.yLH).cpl();
            }
        }
    }
}
