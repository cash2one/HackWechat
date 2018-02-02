package com.tencent.mm.plugin.ext.ui;

class RedirectToChattingByPhoneStubUI$1 implements Runnable {
    final /* synthetic */ RedirectToChattingByPhoneStubUI mby;

    RedirectToChattingByPhoneStubUI$1(RedirectToChattingByPhoneStubUI redirectToChattingByPhoneStubUI) {
        this.mby = redirectToChattingByPhoneStubUI;
    }

    public final void run() {
        this.mby.hideVKB();
    }
}
