package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelManagerUI$8 implements b {
    final /* synthetic */ ContactLabelManagerUI nPj;

    ContactLabelManagerUI$8(ContactLabelManagerUI contactLabelManagerUI) {
        this.nPj = contactLabelManagerUI;
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", Integer.valueOf(i), obj);
        if (ContactLabelManagerUI.c(this.nPj) != null) {
            ContactLabelManagerUI.c(this.nPj).removeMessages(5001);
            ContactLabelManagerUI.c(this.nPj).sendEmptyMessageDelayed(5001, 400);
        }
    }
}
