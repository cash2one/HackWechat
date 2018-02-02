package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.bf.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;

class ShakeSayHiListUI$6 implements e {
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$6(ShakeSayHiListUI shakeSayHiListUI) {
        this.qsr = shakeSayHiListUI;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.SayHiListUI", "onItemDel object null");
            return;
        }
        l.Tz().mY(obj.toString());
        ShakeSayHiListUI.b(this.qsr).a(null, null);
    }
}
