package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;

class ContactLabelEditUI$11 implements a {
    final /* synthetic */ ContactLabelEditUI nOY;

    ContactLabelEditUI$11(ContactLabelEditUI contactLabelEditUI) {
        this.nOY = contactLabelEditUI;
    }

    public final void Dv(String str) {
        ContactLabelEditUI.b(this.nOY, str);
        ContactLabelEditUI.c(this.nOY, str);
        ContactLabelEditUI.e(this.nOY).gk(false);
    }

    public final void gi(boolean z) {
        if (ContactLabelEditUI.f(this.nOY) || !ContactLabelEditUI.g(this.nOY)) {
            this.nOY.enableOptionMenu(z);
            return;
        }
        this.nOY.enableOptionMenu(false);
        ContactLabelEditUI.h(this.nOY);
    }
}
