package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.g.a.pw;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements b {
    public c qRk = new 1(this);

    public a() {
        com.tencent.mm.sdk.b.a.xef.b(this.qRk);
        ae.bvq().a((b) this);
    }

    public final void JT(String str) {
        x.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[]{str});
        com.tencent.mm.sdk.b.b pwVar = new pw();
        pwVar.fHB.fpr = 2;
        pwVar.fHB.mediaId = str;
        String r = am.r(ae.getAccSnsPath(), str);
        pwVar.fHB.path = r + i.JD(str);
        com.tencent.mm.sdk.b.a.xef.m(pwVar);
    }

    public final void aE(String str, boolean z) {
    }

    public final void bun() {
    }

    public final void aF(String str, boolean z) {
    }
}
