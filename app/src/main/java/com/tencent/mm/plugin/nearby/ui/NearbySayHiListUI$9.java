package com.tencent.mm.plugin.nearby.ui;

import com.tencent.mm.bf.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;

class NearbySayHiListUI$9 implements e {
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$9(NearbySayHiListUI nearbySayHiListUI) {
        this.oPo = nearbySayHiListUI;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.SayHiListUI", "onItemDel object null");
            return;
        }
        l.Ty().mY(obj.toString());
        NearbySayHiListUI.b(this.oPo).a(null, null);
    }
}
