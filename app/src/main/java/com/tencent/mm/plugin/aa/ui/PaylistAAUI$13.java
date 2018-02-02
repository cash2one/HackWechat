package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.ui.widget.g;

class PaylistAAUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ PaylistAAUI ikp;
    final /* synthetic */ v ikt;

    PaylistAAUI$13(PaylistAAUI paylistAAUI, v vVar) {
        this.ikp = paylistAAUI;
        this.ikt = vVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.ikp, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
        return true;
    }
}
