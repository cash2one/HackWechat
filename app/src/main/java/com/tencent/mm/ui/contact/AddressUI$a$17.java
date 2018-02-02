package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$17 implements e {
    final /* synthetic */ a yQF;

    AddressUI$a$17(a aVar) {
        this.yQF = aVar;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.AddressUI", "onItemDel object null");
        } else {
            a.a(this.yQF, obj.toString());
        }
    }
}
