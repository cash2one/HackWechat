package com.tencent.mm.plugin.webview.fts.a;

import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.webview.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;

class b$2 implements k {
    final /* synthetic */ b tnj;

    b$2(b bVar) {
        this.tnj = bVar;
    }

    public final void b(h hVar) {
        a aVar = (a) hVar.mMa.mLn;
        if (aVar != null) {
            a aVar2 = (a) this.tnj.gKa.remove(aVar);
            if (aVar2 != null) {
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
                        aVar2.bPg();
                        return;
                        break;
                }
                aVar2.bPg();
            }
        }
    }
}
