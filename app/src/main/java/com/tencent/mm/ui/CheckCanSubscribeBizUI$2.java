package com.tencent.mm.ui;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.sdk.platformtools.bh;

class CheckCanSubscribeBizUI$2 implements a {
    final /* synthetic */ CheckCanSubscribeBizUI xEb;

    CheckCanSubscribeBizUI$2(CheckCanSubscribeBizUI checkCanSubscribeBizUI) {
        this.xEb = checkCanSubscribeBizUI;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        ms msVar = (ms) bVar.hmh.hmo;
        CheckCanSubscribeBizUI.a(this.xEb, msVar.vVt);
        if (i == 0 && i2 == 0 && !bh.ov(msVar.vVt) && !bh.ov(msVar.nko)) {
            CheckCanSubscribeBizUI.b(this.xEb, msVar.nko);
            CheckCanSubscribeBizUI.c(this.xEb, msVar.vVu);
            CheckCanSubscribeBizUI.b(this.xEb);
        } else if (t.a.a(this.xEb, i, i2, str, 7)) {
            this.xEb.setResult(5);
            this.xEb.finish();
        } else {
            CheckCanSubscribeBizUI.c(this.xEb);
            this.xEb.setResult(3);
            this.xEb.finish();
        }
        return 0;
    }
}
