package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.fts.a.a.j;
import java.util.Comparator;

class a$a implements Comparator<j> {
    final /* synthetic */ a phz;

    private a$a(a aVar) {
        this.phz = aVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        if (jVar2.timestamp > jVar.timestamp) {
            return 1;
        }
        return jVar2.timestamp < jVar.timestamp ? -1 : 0;
    }
}
