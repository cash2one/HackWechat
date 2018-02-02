package com.tencent.mm.ui.chatting.e;

import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.e.h.2;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class h$2$2 implements d {
    final /* synthetic */ int kI;
    final /* synthetic */ 2 yHQ;
    final /* synthetic */ b yHe;

    h$2$2(2 2, b bVar, int i) {
        this.yHQ = 2;
        this.yHe = bVar;
        this.kI = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.yHe == null) {
            x.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", new Object[]{Integer.valueOf(this.kI)});
            return;
        }
        ar.Hg();
        this.yHQ.yHO.d(i, c.Fa().dH(this.yHe.fqm));
    }
}
