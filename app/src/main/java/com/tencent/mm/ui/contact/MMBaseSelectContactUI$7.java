package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.sdk.platformtools.ag;

class MMBaseSelectContactUI$7 implements Runnable {
    final /* synthetic */ MMBaseSelectContactUI yTk;

    MMBaseSelectContactUI$7(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.yTk = mMBaseSelectContactUI;
    }

    public final void run() {
        MMBaseSelectContactUI.a(this.yTk, a.aUX().aUS());
        MMBaseSelectContactUI.j(this.yTk);
        ag.y(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|updateLabelList";
    }
}
