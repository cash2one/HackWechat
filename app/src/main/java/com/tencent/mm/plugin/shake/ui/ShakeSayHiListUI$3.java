package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShakeSayHiListUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$3(ShakeSayHiListUI shakeSayHiListUI) {
        this.qsr = shakeSayHiListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.qsr.mController.xIM, true, this.qsr.getString(R.l.eHj), "", this.qsr.getString(R.l.eHi), this.qsr.getString(R.l.dEn), new 1(this), new 2(this));
        return true;
    }
}
