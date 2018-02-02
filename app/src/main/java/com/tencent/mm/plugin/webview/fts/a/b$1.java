package com.tencent.mm.plugin.webview.fts.a;

import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

class b$1 implements k {
    final /* synthetic */ b tnj;

    b$1(b bVar) {
        this.tnj = bVar;
    }

    public final void b(h hVar) {
        a aVar = (a) hVar.mMa.mLn;
        if (aVar != null) {
            CountDownLatch countDownLatch = (CountDownLatch) this.tnj.tng.remove(aVar);
            switch (hVar.bjW) {
                case -3:
                case -2:
                case -1:
                    aVar.ck(Collections.emptyList());
                    break;
                case 0:
                    if (hVar.mMc != null && hVar.mMc.size() != 0) {
                        aVar.ck(hVar.mMc);
                        break;
                    }
                    x.i("FTSMatchContact", "local contact search size 0");
                    aVar.ck(Collections.emptyList());
                    countDownLatch.countDown();
                    return;
            }
            countDownLatch.countDown();
        }
    }
}
