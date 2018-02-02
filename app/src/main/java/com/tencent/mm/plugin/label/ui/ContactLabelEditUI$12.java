package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;

class ContactLabelEditUI$12 implements Runnable {
    final /* synthetic */ ContactLabelEditUI nOY;

    ContactLabelEditUI$12(ContactLabelEditUI contactLabelEditUI) {
        this.nOY = contactLabelEditUI;
    }

    public final void run() {
        Collection WE = e.aUW().WE(ContactLabelEditUI.i(this.nOY));
        if (WE == null) {
            x.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
            return;
        }
        if (WE != null) {
            ContactLabelEditUI.a(this.nOY, WE);
            if (ContactLabelEditUI.j(this.nOY) == null) {
                ContactLabelEditUI.b(this.nOY, new ArrayList());
            } else {
                ContactLabelEditUI.j(this.nOY).clear();
            }
            ContactLabelEditUI.j(this.nOY).addAll(WE);
        }
        if (ContactLabelEditUI.k(this.nOY) != null) {
            ContactLabelEditUI.k(this.nOY).sendEmptyMessage(6001);
        }
    }

    public final String toString() {
        return super.toString() + "|initView";
    }
}
