package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelEditUI$10 implements a {
    final /* synthetic */ ContactLabelEditUI nOY;

    ContactLabelEditUI$10(ContactLabelEditUI contactLabelEditUI) {
        this.nOY = contactLabelEditUI;
    }

    public final void oe(int i) {
        if (ContactLabelEditUI.c(this.nOY).Ca(i)) {
            String Cb = ContactLabelEditUI.c(this.nOY).Cb(i);
            String Cc = ContactLabelEditUI.c(this.nOY).Cc(i);
            if (!bh.ov(Cb)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", Cb);
                intent.putExtra("Contact_RoomNickname", Cc);
                com.tencent.mm.plugin.label.a.ifs.d(intent, this.nOY);
            }
        }
    }

    public final void axM() {
        if (ContactLabelEditUI.c(this.nOY) != null) {
            ContactLabelEditUI.c(this.nOY).caZ();
        }
    }

    public final void of(int i) {
        ContactLabelEditUI.d(this.nOY);
    }

    public final void od(int i) {
        x.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[]{Integer.valueOf(i), ContactLabelEditUI.c(this.nOY).Cb(i)});
        ContactLabelEditUI.a(this.nOY, r0);
    }
}
