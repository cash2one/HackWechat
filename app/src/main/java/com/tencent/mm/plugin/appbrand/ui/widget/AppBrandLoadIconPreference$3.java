package com.tencent.mm.plugin.appbrand.ui.widget;

class AppBrandLoadIconPreference$3 implements Runnable {
    final /* synthetic */ AppBrandLoadIconPreference jRA;
    final /* synthetic */ boolean jRB;

    AppBrandLoadIconPreference$3(AppBrandLoadIconPreference appBrandLoadIconPreference, boolean z) {
        this.jRA = appBrandLoadIconPreference;
        this.jRB = z;
    }

    public final void run() {
        if (this.jRB && AppBrandLoadIconPreference.c(this.jRA) != null) {
            AppBrandLoadIconPreference.c(this.jRA).amf();
        }
    }
}
