package com.tencent.mm.plugin.label.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelMemberListUI$1 extends af {
    final /* synthetic */ ContactLabelMemberListUI nPB;

    ContactLabelMemberListUI$1(ContactLabelMemberListUI contactLabelMemberListUI) {
        this.nPB = contactLabelMemberListUI;
    }

    public final void handleMessage(Message message) {
        x.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[]{Integer.valueOf(message.what)});
        switch (message.what) {
            case 5001:
                ContactLabelMemberListUI.a(this.nPB);
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
                return;
        }
    }
}
