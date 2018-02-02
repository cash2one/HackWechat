package com.tencent.mm.ui.contact;

import com.tencent.mm.ui.contact.LabelContainerView.a;

class MMBaseSelectContactUI$5 implements a {
    final /* synthetic */ MMBaseSelectContactUI yTk;

    MMBaseSelectContactUI$5(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.yTk = mMBaseSelectContactUI;
    }

    public final void aDx() {
        if (MMBaseSelectContactUI.d(this.yTk) != null) {
            MMBaseSelectContactUI.d(this.yTk).clearFocus();
        }
        if (MMBaseSelectContactUI.h(this.yTk) != null) {
            MMBaseSelectContactUI.h(this.yTk).clearFocus();
            MMBaseSelectContactUI.h(this.yTk).cxX();
        }
        MMBaseSelectContactUI.i(this.yTk).requestFocus();
        MMBaseSelectContactUI.i(this.yTk).setVisibility(8);
    }

    public final void aDy() {
        this.yTk.aWs();
    }
}
