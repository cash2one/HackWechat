package com.tencent.mm.plugin.mmsight.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SightSettingsUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SightSettingsUI oDm;

    SightSettingsUI$2(SightSettingsUI sightSettingsUI) {
        this.oDm = sightSettingsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oDm.finish();
        return false;
    }
}
