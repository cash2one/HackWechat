package com.tencent.mm.ui.contact;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;

class SnsAddressUI$3 implements a {
    final /* synthetic */ SnsAddressUI yUF;

    SnsAddressUI$3(SnsAddressUI snsAddressUI) {
        this.yUF = snsAddressUI;
    }

    public final void oE(String str) {
        if (str != null) {
            SnsAddressUI.a(this.yUF).remove(str);
            SnsAddressUI.b(this.yUF);
        }
    }
}
