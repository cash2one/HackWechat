package com.tencent.mm.plugin.appbrand.ui.widget;

import android.view.View;

class AppBrandLoadIconPreference$4 implements Runnable {
    final /* synthetic */ AppBrandLoadIconPreference jRA;
    final /* synthetic */ View zS;

    AppBrandLoadIconPreference$4(AppBrandLoadIconPreference appBrandLoadIconPreference, View view) {
        this.jRA = appBrandLoadIconPreference;
        this.zS = view;
    }

    public final void run() {
        this.zS.setVisibility(8);
    }
}
