package com.tencent.mm.ui.chatting.e;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.e.a.2;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class a$2$2 implements d {
    final /* synthetic */ 2 yHd;
    final /* synthetic */ b yHe;

    a$2$2(2 2, b bVar) {
        this.yHd = 2;
        this.yHe = bVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        ar.Hg();
        this.yHd.yHc.d(menuItem.getItemId(), c.Fa().dH(this.yHe.fqm));
    }
}
