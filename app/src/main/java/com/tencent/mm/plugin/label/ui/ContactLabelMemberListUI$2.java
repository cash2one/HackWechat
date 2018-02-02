package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelMemberListUI$2 implements b {
    final /* synthetic */ ContactLabelMemberListUI nPB;

    ContactLabelMemberListUI$2(ContactLabelMemberListUI contactLabelMemberListUI) {
        this.nPB = contactLabelMemberListUI;
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[]{Integer.valueOf(i), obj});
        if (ContactLabelMemberListUI.b(this.nPB) != null) {
            ContactLabelMemberListUI.b(this.nPB).removeMessages(5001);
            ContactLabelMemberListUI.b(this.nPB).sendEmptyMessageDelayed(5001, 300);
        }
    }
}
