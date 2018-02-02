package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$8 implements Runnable {
    final /* synthetic */ a yQF;

    AddressUI$a$8(a aVar) {
        this.yQF = aVar;
    }

    public final void run() {
        x.v("MicroMsg.AddressUI", "post search adapter to do refresh");
        a.e(this.yQF).a(null, null);
    }
}
