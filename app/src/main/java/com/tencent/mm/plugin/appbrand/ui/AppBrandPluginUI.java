package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class AppBrandPluginUI extends AppBrandUI {
    private boolean jLj = false;

    protected void initActivityOpenAnimation(Intent intent) {
        super.overridePendingTransition(MMFragmentActivity.a.xKg, MMFragmentActivity.a.xKh);
    }

    protected void initActivityCloseAnimation() {
        if (!this.jLj) {
            super.overridePendingTransition(MMFragmentActivity.a.xKi, MMFragmentActivity.a.xKj);
        }
    }

    public void onSwipeBack() {
        super.onSwipeBack();
        this.jLj = true;
    }

    public final boolean akK() {
        return true;
    }
}
