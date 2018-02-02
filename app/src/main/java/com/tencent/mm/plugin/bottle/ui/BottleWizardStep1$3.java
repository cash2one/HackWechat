package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleWizardStep1$3 implements OnMenuItemClickListener {
    final /* synthetic */ BottleWizardStep1 kCq;

    BottleWizardStep1$3(BottleWizardStep1 bottleWizardStep1) {
        this.kCq = bottleWizardStep1;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kCq.startActivity(new Intent().setClass(this.kCq, BottleWizardStep2.class));
        this.kCq.finish();
        return true;
    }
}
