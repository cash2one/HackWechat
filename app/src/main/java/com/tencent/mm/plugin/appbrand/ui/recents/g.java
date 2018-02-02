package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Iterator;

final class g {
    final boolean fqP;

    g(boolean z) {
        this.fqP = z;
    }

    final ArrayList<i> k(ArrayList<i> arrayList) {
        if (!this.fqP || bh.cA(arrayList)) {
            return arrayList;
        }
        ArrayList<i> arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!iVar.iJL) {
                arrayList2.add(iVar);
            }
        }
        return arrayList2;
    }
}
