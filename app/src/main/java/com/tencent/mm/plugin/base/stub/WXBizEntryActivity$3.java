package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.boo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;

class WXBizEntryActivity$3 implements a {
    final /* synthetic */ WXBizEntryActivity kuU;

    WXBizEntryActivity$3(WXBizEntryActivity wXBizEntryActivity) {
        this.kuU = wXBizEntryActivity;
    }

    public final void a(int i, int i2, String str, k kVar, boolean z) {
        x.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z)});
        if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ak))) {
            boo Sq = ((ak) kVar).Sq();
            if (!(Sq == null || this.kuU.isFinishing())) {
                u.makeText(this.kuU, this.kuU.getString(R.l.dGO) + " : " + bh.ou(Sq.wQX), 0).show();
            }
        }
        this.kuU.finish();
    }
}
