package com.tencent.mm.plugin.address.b.a;

import com.tencent.mm.plugin.o.a.b;
import java.util.Iterator;

public final class a {
    public com.tencent.mm.plugin.o.a.a ilP = new com.tencent.mm.plugin.o.a.a();

    public final b jg(int i) {
        Iterator it = this.ilP.nBH.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.nBI == i) {
                return bVar;
            }
        }
        return null;
    }
}
