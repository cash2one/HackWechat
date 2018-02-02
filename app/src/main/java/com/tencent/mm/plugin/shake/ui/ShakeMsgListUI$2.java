package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShakeMsgListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeMsgListUI qqQ;

    ShakeMsgListUI$2(ShakeMsgListUI shakeMsgListUI) {
        this.qqQ = shakeMsgListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.qqQ.mController.xIM, true, this.qqQ.getString(R.l.eOE), "", this.qqQ.getString(R.l.eHi), this.qqQ.getString(R.l.dEn), new 1(this), new 2(this));
        return true;
    }
}
