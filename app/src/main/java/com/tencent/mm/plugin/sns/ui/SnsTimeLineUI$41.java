package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.ui.base.p.d;

class SnsTimeLineUI$41 implements d {
    final /* synthetic */ SnsTimeLineUI rIN;
    final /* synthetic */ b rIX;

    SnsTimeLineUI$41(SnsTimeLineUI snsTimeLineUI, b bVar) {
        this.rIN = snsTimeLineUI;
        this.rIX = bVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                g.pQN.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                e.rdF.b(this.rIX);
                this.rIX.Sx();
                SnsTimeLineUI.h(this.rIN).rLl = this.rIX;
                SnsTimeLineUI.h(this.rIN).xQ(1);
                return;
            case 3:
                SnsTimeLineUI.G(this.rIN);
                return;
            default:
                return;
        }
    }
}
