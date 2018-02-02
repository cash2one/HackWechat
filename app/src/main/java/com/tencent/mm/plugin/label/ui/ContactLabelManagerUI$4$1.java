package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.4;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.b;

class ContactLabelManagerUI$4$1 implements Runnable {
    final /* synthetic */ 4 nPm;

    ContactLabelManagerUI$4$1(4 4) {
        this.nPm = 4;
    }

    public final void run() {
        ContactLabelManagerUI.a(this.nPm.nPj, b.nPp);
        if (this.nPm.nPl && ContactLabelManagerUI.c(this.nPm.nPj) != null) {
            ContactLabelManagerUI.c(this.nPm.nPj).removeMessages(5002);
            ContactLabelManagerUI.c(this.nPm.nPj).sendEmptyMessageDelayed(5003, 0);
        }
    }
}
