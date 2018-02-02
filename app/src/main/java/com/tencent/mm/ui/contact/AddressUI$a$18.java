package com.tencent.mm.ui.contact;

import com.tencent.mm.ui.contact.i.a;

class AddressUI$a$18 implements a {
    final /* synthetic */ AddressUI.a yQF;

    AddressUI$a$18(AddressUI.a aVar) {
        this.yQF = aVar;
    }

    public final void Gl(int i) {
        if (AddressUI.a.d(this.yQF) != null) {
            if (i <= 0) {
                AddressUI.a.d(this.yQF).setVisibility(8);
            } else {
                AddressUI.a.d(this.yQF).setVisibility(0);
            }
        }
    }
}
