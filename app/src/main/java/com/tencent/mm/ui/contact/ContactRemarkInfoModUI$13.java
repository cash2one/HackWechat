package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;

class ContactRemarkInfoModUI$13 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ySf;

    ContactRemarkInfoModUI$13(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ySf = contactRemarkInfoModUI;
    }

    public final void onClick(View view) {
        ContactRemarkInfoModUI.f(this.ySf);
        ContactRemarkInfoModUI.a(this.ySf, false, view.getId());
        ContactRemarkInfoModUI.h(this.ySf).performClick();
        ContactRemarkInfoModUI.h(this.ySf).requestFocus();
        this.ySf.showVKB();
    }
}
