package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class NearbySayHiListUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$5(NearbySayHiListUI nearbySayHiListUI) {
        this.oPo = nearbySayHiListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.oPo.mController.xIM, true, this.oPo.getResources().getString(R.l.eHj), "", this.oPo.getResources().getString(R.l.eHi), this.oPo.getString(R.l.dEn), new 1(this), null);
        return true;
    }
}
