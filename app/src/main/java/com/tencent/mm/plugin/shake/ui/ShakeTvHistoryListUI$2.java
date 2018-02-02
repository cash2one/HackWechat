package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShakeTvHistoryListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeTvHistoryListUI qsv;

    ShakeTvHistoryListUI$2(ShakeTvHistoryListUI shakeTvHistoryListUI) {
        this.qsv = shakeTvHistoryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.qsv.mController.xIM, true, this.qsv.getString(R.l.ePa), "", this.qsv.getString(R.l.eHi), this.qsv.getString(R.l.dEn), new 1(this), new 2(this));
        return true;
    }
}
