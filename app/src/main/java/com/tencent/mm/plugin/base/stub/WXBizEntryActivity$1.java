package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;

class WXBizEntryActivity$1 implements a {
    final /* synthetic */ WXBizEntryActivity kuU;

    WXBizEntryActivity$1(WXBizEntryActivity wXBizEntryActivity) {
        this.kuU = wXBizEntryActivity;
    }

    public final void dP(boolean z) {
        if (z) {
            d.a(this.kuU, "game", ".ui.CreateOrJoinChatroomUI", this.kuU.getIntent(), false);
        } else {
            x.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
        }
        this.kuU.finish();
    }
}
