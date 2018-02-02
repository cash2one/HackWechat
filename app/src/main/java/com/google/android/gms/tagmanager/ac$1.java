package com.google.android.gms.tagmanager;

import com.google.android.gms.c.at;
import com.google.android.gms.c.at.b;
import com.google.android.gms.tagmanager.ac.a;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ac$1 implements a {
    final /* synthetic */ Map bcg;
    final /* synthetic */ Map bch;
    final /* synthetic */ Map bci;
    final /* synthetic */ Map bcj;
    final /* synthetic */ ac bck;

    ac$1(ac acVar, Map map, Map map2, Map map3, Map map4) {
        this.bck = acVar;
        this.bcg = map;
        this.bch = map2;
        this.bci = map3;
        this.bcj = map4;
    }

    public final void a(b bVar, Set<at.a> set, Set<at.a> set2, aa aaVar) {
        List list = (List) this.bcg.get(bVar);
        this.bch.get(bVar);
        if (list != null) {
            set.addAll(list);
            aaVar.qN();
        }
        list = (List) this.bci.get(bVar);
        this.bcj.get(bVar);
        if (list != null) {
            set2.addAll(list);
            aaVar.qO();
        }
    }
}
