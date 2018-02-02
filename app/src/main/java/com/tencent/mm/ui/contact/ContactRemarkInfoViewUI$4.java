package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.bb.c.a;
import com.tencent.mm.ui.base.h;

class ContactRemarkInfoViewUI$4 implements a {
    final /* synthetic */ ContactRemarkInfoViewUI ySk;

    ContactRemarkInfoViewUI$4(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        this.ySk = contactRemarkInfoViewUI;
    }

    public final void bQ(final boolean z) {
        ContactRemarkInfoViewUI.f(this.ySk).post(new Runnable(this) {
            final /* synthetic */ ContactRemarkInfoViewUI$4 ySl;

            public final void run() {
                if (z) {
                    ContactRemarkInfoViewUI.e(this.ySl.ySk);
                } else {
                    h.bu(this.ySl.ySk, this.ySl.ySk.getString(R.l.dEP));
                }
            }
        });
    }
}
