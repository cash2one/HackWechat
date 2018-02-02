package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b.b;

class ShakeItemListUI$a$2 implements b {
    final /* synthetic */ a qqE;

    ShakeItemListUI$a$2(a aVar) {
        this.qqE = aVar;
    }

    public final String hC(int i) {
        if (i < 0 || i >= this.qqE.getCount()) {
            x.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
            return null;
        }
        d dVar = (d) this.qqE.getItem(i);
        return dVar == null ? null : dVar.field_username;
    }

    public final int NJ() {
        return this.qqE.getCount();
    }
}
