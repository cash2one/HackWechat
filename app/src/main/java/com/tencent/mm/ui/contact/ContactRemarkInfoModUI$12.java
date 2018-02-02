package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;

class ContactRemarkInfoModUI$12 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ySf;

    ContactRemarkInfoModUI$12(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ySf = contactRemarkInfoModUI;
    }

    public final void onClick(View view) {
        ContactRemarkInfoModUI.f(this.ySf);
        ContactRemarkInfoModUI.a(this.ySf, false, view.getId());
        ContactRemarkInfoModUI.g(this.ySf).performClick();
        ContactRemarkInfoModUI.g(this.ySf).requestFocus();
        this.ySf.showVKB();
    }
}
