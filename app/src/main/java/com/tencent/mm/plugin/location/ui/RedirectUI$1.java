package com.tencent.mm.plugin.location.ui;

import android.content.Intent;

class RedirectUI$1 implements Runnable {
    final /* synthetic */ double mtY;
    final /* synthetic */ double mtZ;
    final /* synthetic */ RedirectUI nTz;
    final /* synthetic */ Intent val$intent;

    RedirectUI$1(RedirectUI redirectUI, Intent intent, double d, double d2) {
        this.nTz = redirectUI;
        this.val$intent = intent;
        this.mtY = d;
        this.mtZ = d2;
    }

    public final void run() {
        RedirectUI.a(this.nTz, this.val$intent, this.mtY, this.mtZ);
    }
}
