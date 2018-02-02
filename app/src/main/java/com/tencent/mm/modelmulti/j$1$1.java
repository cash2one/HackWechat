package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelmulti.j.1;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;

class j$1$1 implements e {
    final /* synthetic */ 1 hFI;

    j$1$1(1 1) {
        this.hFI = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        kVar.hmF = true;
        x.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(j.b(this.hFI.hFH).size()), str, Boolean.valueOf(j.c(this.hFI.hFH)), Integer.valueOf(j.d(this.hFI.hFH))});
        if (i == 0 && i2 == 0) {
            j.b(this.hFI.hFH).clear();
            j.a(this.hFI.hFH, str);
        } else {
            j.a(this.hFI.hFH, j.b(this.hFI.hFH));
            j.e(this.hFI.hFH).a(4, -49, this.hFI.hFG, this.hFI.hFH);
            j.b(this.hFI.hFH, j.b(this.hFI.hFH));
            j.b(this.hFI.hFH).clear();
        }
        j.f(this.hFI.hFH);
        r.iea = false;
    }
}
