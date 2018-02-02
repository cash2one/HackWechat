package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.AddressUI.a;
import com.tencent.mm.ui.f;

class AddressUI$a$11 implements Runnable {
    final /* synthetic */ a yQF;

    AddressUI$a$11(a aVar) {
        this.yQF = aVar;
    }

    public final void run() {
        f a = a.a(this.yQF);
        x.i(a.TAG, "newcursor resume ");
        a.xEr = true;
        a.bh("resume", true);
    }
}
