package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel.a;

class ContactLabelUI$8 implements a {
    final /* synthetic */ ContactLabelUI nPX;

    ContactLabelUI$8(ContactLabelUI contactLabelUI) {
        this.nPX = contactLabelUI;
    }

    public final void yI(String str) {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[]{str});
        if (ContactLabelUI.b(this.nPX) != null) {
            ContactLabelUI.b(this.nPX).removeTag(str);
        }
        ContactLabelUI.a(this.nPX, str);
    }

    public final void yJ(String str) {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[]{str});
        if (ContactLabelUI.b(this.nPX) != null) {
            ContactLabelUI.b(this.nPX).bi(str, true);
        }
        ContactLabelUI.a(this.nPX, str, ContactLabelUI.d(this.nPX));
    }

    public final void yK(String str) {
    }

    public final void j(boolean z, int i) {
    }

    public final void aDz() {
    }

    public final void yL(String str) {
    }

    public final void yM(String str) {
    }
}
