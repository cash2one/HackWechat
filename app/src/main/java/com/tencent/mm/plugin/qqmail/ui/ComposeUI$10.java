package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ComposeUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$10(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if ((ComposeUI.a(this.prr, false) && ComposeUI.a(this.prr) == 5) || ComposeUI.a(this.prr) == 6) {
            h.a(this.prr.mController.xIM, this.prr.getString(R.l.eAw), "", this.prr.getString(R.l.eAy), this.prr.getString(R.l.dEn), new 1(this), null);
        } else {
            this.prr.setResult(0);
            this.prr.finish();
        }
        return true;
    }
}
