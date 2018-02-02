package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.ui.base.i.a.a;

class SelectConversationUI$4 implements a {
    final /* synthetic */ SelectConversationUI zpv;
    final /* synthetic */ b zpw;
    final /* synthetic */ String zpx;

    SelectConversationUI$4(SelectConversationUI selectConversationUI, b bVar, String str) {
        this.zpv = selectConversationUI;
        this.zpw = bVar;
        this.zpx = str;
    }

    public final void aJL() {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 1);
        intent.putExtra("kwebmap_slat", this.zpw.nQx);
        intent.putExtra("kwebmap_lng", this.zpw.nQy);
        intent.putExtra("Kwebmap_locaion", this.zpx);
        intent.putExtra("kShowshare", false);
        d.b(this.zpv.mController.xIM, "location", ".ui.RedirectUI", intent);
    }
}
