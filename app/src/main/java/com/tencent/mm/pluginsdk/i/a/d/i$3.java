package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

class i$3 implements Runnable {
    final /* synthetic */ l iFL;
    final /* synthetic */ String vgy;
    final /* synthetic */ List vhG;
    final /* synthetic */ i vhH;

    i$3(i iVar, List list, l lVar, String str) {
        this.vhH = iVar;
        this.vhG = list;
        this.iFL = lVar;
        this.vgy = str;
    }

    public final void run() {
        for (d dVar : this.vhG) {
            if (bh.ou(dVar.aab()).equals(this.iFL.groupId)) {
                dVar.OF(this.vgy);
            }
        }
    }
}
