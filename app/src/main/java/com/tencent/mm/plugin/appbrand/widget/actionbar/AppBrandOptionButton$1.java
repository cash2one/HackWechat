package com.tencent.mm.plugin.appbrand.widget.actionbar;

class AppBrandOptionButton$1 implements Runnable {
    final /* synthetic */ AppBrandOptionButton jWa;

    AppBrandOptionButton$1(AppBrandOptionButton appBrandOptionButton) {
        this.jWa = appBrandOptionButton;
    }

    public final void run() {
        this.jWa.jVZ.setVisibility(0);
        AppBrandOptionButton.a(this.jWa).end();
        AppBrandOptionButton.a(this.jWa).start();
    }
}
