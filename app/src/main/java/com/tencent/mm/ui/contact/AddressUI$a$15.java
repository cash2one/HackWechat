package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$15 implements MMSlideDelView$c {
    final /* synthetic */ a yQF;

    AddressUI$a$15(a aVar) {
        this.yQF = aVar;
    }

    public final int ci(View view) {
        return a.c(this.yQF).getPositionForView(view);
    }
}
