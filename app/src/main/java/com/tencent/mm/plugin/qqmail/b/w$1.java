package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class w$1 implements Runnable {
    final /* synthetic */ w ppX;

    w$1(w wVar) {
        this.ppX = wVar;
    }

    public final void run() {
        if (ar.Hj()) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = new s();
            if (sVar.ppr.omU.size() > 0) {
                for (int i = 0; i < sVar.ppr.omU.size(); i++) {
                    s.HN(((q) sVar.ppr.omU.get(i)).poi);
                }
                sVar.ppr.omU.clear();
                sVar.save();
            }
            x.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }
}
