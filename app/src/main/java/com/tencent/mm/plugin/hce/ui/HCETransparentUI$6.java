package com.tencent.mm.plugin.hce.ui;

import android.content.ComponentName;
import android.content.Intent;

class HCETransparentUI$6 implements Runnable {
    final /* synthetic */ HCETransparentUI nAu;
    final /* synthetic */ ComponentName nAv;

    HCETransparentUI$6(HCETransparentUI hCETransparentUI, ComponentName componentName) {
        this.nAu = hCETransparentUI;
        this.nAv = componentName;
    }

    public final void run() {
        HCETransparentUI.g(this.nAu);
        Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
        intent.putExtra("category", "payment");
        intent.putExtra("component", this.nAv);
        this.nAu.startActivityForResult(intent, 2);
    }
}
