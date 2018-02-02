package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.protocal.c.cbr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.viewitems.q.1.2;
import com.tencent.mm.z.ar;

class q$1$2$3 implements e {
    final /* synthetic */ 2 yLL;

    q$1$2$3(2 2) {
        this.yLL = 2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(1198, this);
        x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false)});
        if (q.d(this.yLL.yLJ.yLH) != null) {
            q.d(this.yLL.yLJ.yLH).dismiss();
            q.a(this.yLL.yLJ.yLH, null);
        }
        if (i == 0 && i2 == 0) {
            cbr Jf = ((o) kVar).Jf();
            if (Jf == null) {
                u.makeText(this.yLL.jLA.getContext(), R.l.ezu, 0).show();
                return;
            }
            String str2 = Jf.xaL;
            x.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[]{this.yLL.tIq});
            ((b) g.h(b.class)).a(this.yLL.tIq, new 1(this, str2));
            return;
        }
        u.makeText(this.yLL.jLA.getContext(), R.l.ezu, 0).show();
    }
}
