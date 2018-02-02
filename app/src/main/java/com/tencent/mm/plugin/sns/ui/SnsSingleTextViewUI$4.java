package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsSingleTextViewUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SnsSingleTextViewUI rGK;

    SnsSingleTextViewUI$4(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.rGK = snsSingleTextViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rGK.finish();
        return true;
    }
}
