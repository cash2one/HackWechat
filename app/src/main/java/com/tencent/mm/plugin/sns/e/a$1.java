package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.g.a.pw;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;

class a$1 extends c<pw> {
    final /* synthetic */ a qRl;

    a$1(a aVar) {
        this.qRl = aVar;
        this.xen = pw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pw pwVar = (pw) bVar;
        if (pwVar instanceof pw) {
            if (pwVar.fHB.fpr == 1) {
                x.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "start do download id %s", new Object[]{pwVar.fHB.fHC.nGJ});
                e eVar = new e(pwVar.fHB.fHC);
                eVar.qQR = 1;
                eVar.hKZ = pwVar.fHB.fHC.nGJ;
                if (pwVar.fHB.fHC.ktN == 6) {
                    ae.bvq().a(pwVar.fHB.fHC, 5, eVar, an.xza);
                } else {
                    ae.bvq().a(pwVar.fHB.fHC, 1, eVar, an.xza);
                }
            } else if (pwVar.fHB.fpr == 3) {
                String r = am.r(ae.getAccSnsPath(), pwVar.fHB.mediaId);
                String JD = i.JD(pwVar.fHB.mediaId);
                pwVar.fHB.path = r + JD;
            }
        }
        return false;
    }
}
