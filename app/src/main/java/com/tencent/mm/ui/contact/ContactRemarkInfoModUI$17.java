package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.t;

class ContactRemarkInfoModUI$17 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ySf;

    ContactRemarkInfoModUI$17(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ySf = contactRemarkInfoModUI;
    }

    public final void onClick(View view) {
        if (t.ov(ContactRemarkInfoModUI.m(this.ySf)) || ContactRemarkInfoModUI.p(this.ySf)) {
            ContactRemarkInfoModUI.a(this.ySf, false);
            ContactRemarkInfoModUI.k(this.ySf);
        }
    }
}
