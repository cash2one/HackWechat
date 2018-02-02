package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends k {
    protected l(String str) {
        super(str);
    }

    public final void aQf() {
        LinkedList n = n(optJSONArray("items"));
        Iterator it = n.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.cP(dVar.naQ);
        }
        d.U(n);
    }
}
