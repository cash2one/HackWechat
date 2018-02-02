package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.1;
import com.tencent.mm.ui.base.p.d;

class PreviewHdHeadImg$1$2 implements d {
    final /* synthetic */ 1 qhw;

    PreviewHdHeadImg$1$2(1 1) {
        this.qhw = 1;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                a.ift.d(this.qhw.qhv);
                return;
            case 2:
                PreviewHdHeadImg.b(this.qhw.qhv);
                return;
            default:
                return;
        }
    }
}
