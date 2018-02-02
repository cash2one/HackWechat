package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NearbyPersonalInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyPersonalInfoUI oPg;

    NearbyPersonalInfoUI$1(NearbyPersonalInfoUI nearbyPersonalInfoUI) {
        this.oPg = nearbyPersonalInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oPg.finish();
        return true;
    }
}
