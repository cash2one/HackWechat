package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;

class UnfamiliarContactDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI qma;

    UnfamiliarContactDetailUI$1(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qma = unfamiliarContactDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        UnfamiliarContactDetailUI.a(this.qma, !UnfamiliarContactDetailUI.a(this.qma));
        UnfamiliarContactDetailUI.b(this.qma).clear();
        UnfamiliarContactDetailUI.b(this.qma, UnfamiliarContactDetailUI.a(this.qma));
        if (UnfamiliarContactDetailUI.a(this.qma)) {
            UnfamiliarContactDetailUI.c(this.qma).setEnabled(false);
            UnfamiliarContactDetailUI.d(this.qma).setEnabled(false);
            this.qma.updateOptionMenuText(1, this.qma.getString(R.l.eRG));
        } else {
            this.qma.updateOptionMenuText(1, this.qma.getString(R.l.eRK));
        }
        if (UnfamiliarContactDetailUI.e(this.qma) != null) {
            UnfamiliarContactDetailUI.e(this.qma).UR.notifyChanged();
        }
        return true;
    }
}
