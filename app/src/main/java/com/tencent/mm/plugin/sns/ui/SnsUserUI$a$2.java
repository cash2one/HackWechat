package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.ui.SnsUserUI.a;
import com.tencent.mm.ui.base.p.d;

class SnsUserUI$a$2 implements d {
    final /* synthetic */ a rMc;

    SnsUserUI$a$2(a aVar) {
        this.rMc = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                g.pQN.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                SnsUserUI.j(this.rMc.rMb);
                return;
            case 1:
                g.pQN.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                SnsUserUI.k(this.rMc.rMb).xQ(1);
                return;
            default:
                return;
        }
    }
}
