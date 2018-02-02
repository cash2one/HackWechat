package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.c.c.a;
import java.util.List;

class c$2 implements a {
    final /* synthetic */ c bbv;

    c$2(c cVar) {
        this.bbv = cVar;
    }

    public final void t(List<c.a> list) {
        for (c.a aVar : list) {
            c.a(this.bbv, c.j(aVar.aXw, aVar.bbw));
        }
        c.a(this.bbv).countDown();
    }
}
