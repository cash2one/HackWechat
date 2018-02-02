package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI.6;

class ContactRemarkInfoModUI$6$1 implements Runnable {
    final /* synthetic */ boolean lbn;
    final /* synthetic */ 6 ySg;

    ContactRemarkInfoModUI$6$1(6 6, boolean z) {
        this.ySg = 6;
        this.lbn = z;
    }

    public final void run() {
        if (this.lbn) {
            ContactRemarkInfoModUI.v(this.ySg.ySf);
            return;
        }
        h.bu(this.ySg.ySf, this.ySg.ySf.getString(R.l.dEP));
        ContactRemarkInfoModUI.s(this.ySg.ySf).setVisibility(0);
        ContactRemarkInfoModUI.t(this.ySg.ySf).setVisibility(8);
        ContactRemarkInfoModUI.u(this.ySg.ySf).setVisibility(8);
    }
}
