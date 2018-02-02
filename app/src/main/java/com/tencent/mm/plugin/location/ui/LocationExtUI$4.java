package com.tencent.mm.plugin.location.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LocationExtUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ LocationExtUI nSF;

    LocationExtUI$4(LocationExtUI locationExtUI) {
        this.nSF = locationExtUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nSF.finish();
        return true;
    }
}
