package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.g.a.le;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class MallIndexUI$1 extends c<le> {
    final /* synthetic */ MallIndexUI omF;

    MallIndexUI$1(MallIndexUI mallIndexUI) {
        this.omF = mallIndexUI;
        this.xen = le.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicorMsg.MallIndexUI", "open ecard finish");
        MallIndexUI.a(this.omF);
        return false;
    }
}
