package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

class g$a extends g {
    List<g> aNO;

    g$a(List<g> list) {
        this.aNO = list;
    }

    public final g a(g gVar) {
        List arrayList = new ArrayList(this.aNO);
        arrayList.add(w.ag(gVar));
        return new g$a(arrayList);
    }

    public final boolean e(char c) {
        for (g e : this.aNO) {
            if (e.e(c)) {
                return true;
            }
        }
        return false;
    }
}
