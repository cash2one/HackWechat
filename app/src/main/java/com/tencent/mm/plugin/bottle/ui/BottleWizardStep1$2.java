package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleWizardStep1$2 implements OnMenuItemClickListener {
    final /* synthetic */ BottleWizardStep1 kCq;

    BottleWizardStep1$2(BottleWizardStep1 bottleWizardStep1) {
        this.kCq = bottleWizardStep1;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kCq.aWs();
        this.kCq.finish();
        return true;
    }
}
