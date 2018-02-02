package com.tencent.mm.plugin.sight.draft.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SightDraftUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SightDraftUI qwc;

    SightDraftUI$1(SightDraftUI sightDraftUI) {
        this.qwc = sightDraftUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qwc.finish();
        return false;
    }
}
