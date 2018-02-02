package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class ah$5 implements d {
    final /* synthetic */ ah rvK;

    ah$5(ah ahVar) {
        this.rvK = ahVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (9 - this.rvK.rvD.rvO.size() <= 0) {
                    x.e("MicroMsg.PicWidget", "has select the max image count");
                    return;
                }
                g.pQN.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                k.a(this.rvK.fmM, 11, new Intent(), 2, 2);
                return;
            case 1:
                int size = 9 - this.rvK.rvD.rvO.size();
                if (size <= 0) {
                    x.e("MicroMsg.PicWidget", "has select the max image count");
                    return;
                }
                String string = this.rvK.fmM.getSharedPreferences(ac.cfs(), 0).getString("gallery", "1");
                g.pQN.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                if (string.equalsIgnoreCase("0")) {
                    k.P(this.rvK.fmM);
                    return;
                } else {
                    k.a(this.rvK.fmM, 9, size, 4, 1, false, null);
                    return;
                }
            default:
                return;
        }
    }
}
