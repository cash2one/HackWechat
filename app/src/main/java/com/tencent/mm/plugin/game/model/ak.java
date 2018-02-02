package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.c.bl;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;

public final class ak extends ad {
    public static void a(bl blVar) {
        if (blVar != null && !bh.cA(blVar.niv)) {
            Iterator it = blVar.niv.iterator();
            while (it.hasNext()) {
                ag agVar = (ag) it.next();
                if (agVar.ngI != null && agVar.ngI.nfh != null) {
                    d.a(a(agVar.ngI.nfh));
                } else if (agVar.ngK != null && !bh.cA(agVar.ngK.nfN)) {
                    Iterator it2 = agVar.ngK.nfN.iterator();
                    while (it2.hasNext()) {
                        d.a(a(((aa) it2.next()).nfh));
                    }
                } else if (!(agVar.ngJ == null || agVar.ngJ.nfh == null)) {
                    d.a(a(agVar.ngJ.nfh));
                }
            }
        }
    }
}
