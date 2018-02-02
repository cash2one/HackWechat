package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class l$1 implements Runnable {
    final /* synthetic */ LinkedList nbJ;

    l$1(LinkedList linkedList) {
        this.nbJ = linkedList;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.nbJ.iterator();
        while (it.hasNext()) {
            Iterator it2 = k.n(((l) it.next()).optJSONArray("items")).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (!bh.ov(dVar.field_appId)) {
                    linkedList.add(dVar.field_appId);
                }
            }
        }
        it = c.aRU().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!linkedList.contains(fVar.field_appId)) {
                an.bin().b(fVar, new String[0]);
                x.i("MicroMsg.GameDataSearchGameList", "delete appid : " + fVar.field_appId);
            }
        }
    }
}
