package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class SnsTagDetailUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SnsTagDetailUI rHd;

    SnsTagDetailUI$5(SnsTagDetailUI snsTagDetailUI) {
        this.rHd = snsTagDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!(this.rHd.rHa + " " + bh.d(this.rHd.rGZ, ",")).equals(this.rHd.fqR) || this.rHd.qUC == 0) {
            h.a(this.rHd, j.qMi, j.dGO, new 1(this), null);
        } else {
            this.rHd.finish();
        }
        return true;
    }
}
