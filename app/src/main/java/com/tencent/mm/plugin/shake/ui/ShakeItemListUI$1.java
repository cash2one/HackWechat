package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShakeItemListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeItemListUI qqB;

    ShakeItemListUI$1(ShakeItemListUI shakeItemListUI) {
        this.qqB = shakeItemListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.qqB, true, this.qqB.getString(R.l.eHj), "", this.qqB.getString(R.l.dEo), this.qqB.getString(R.l.dEn), new 1(this), null);
        return true;
    }
}
