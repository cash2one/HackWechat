package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.tools.h;

class ContactLabelUI$7 implements a {
    final /* synthetic */ ContactLabelUI nPX;

    ContactLabelUI$7(ContactLabelUI contactLabelUI) {
        this.nPX = contactLabelUI;
    }

    public final void yI(String str) {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[]{str});
        ContactLabelUI.b(this.nPX).removeTag(str);
        if (ContactLabelUI.c(this.nPX) != null) {
            ContactLabelUI.c(this.nPX).bj(str, false);
        }
        ContactLabelUI.a(this.nPX, str);
    }

    public final void yJ(String str) {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[]{str});
    }

    public final void yK(String str) {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[]{str});
        if (ContactLabelUI.c(this.nPX) != null) {
            ContactLabelUI.c(this.nPX).bj(str, false);
        }
        ContactLabelUI.a(this.nPX, str);
    }

    public final void aDz() {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
    }

    public final void yL(String str) {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[]{str});
        ContactLabelUI.b(this.nPX, str);
    }

    public final void yM(String str) {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[]{str});
        if (bh.ov(str)) {
            x.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
            return;
        }
        ContactLabelUI.b(this.nPX).bi(str, true);
        if (ContactLabelUI.c(this.nPX) != null) {
            ContactLabelUI.c(this.nPX).bj(str, true);
        }
        ContactLabelUI.a(this.nPX, str, ContactLabelUI.d(this.nPX));
    }

    public final void j(boolean z, int i) {
        x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[]{String.valueOf(z), Integer.valueOf(i)});
        if (z) {
            this.nPX.enableOptionMenu(false);
            ContactLabelUI.e(this.nPX).setVisibility(0);
            ContactLabelUI.e(this.nPX).setText(R.l.esC);
            ContactLabelUI.e(this.nPX).setText(String.format(this.nPX.getString(R.l.esC), new Object[]{Integer.valueOf(h.aY(36, "")), Integer.valueOf(i)}));
            return;
        }
        this.nPX.enableOptionMenu(true);
        ContactLabelUI.e(this.nPX).setVisibility(8);
    }
}
