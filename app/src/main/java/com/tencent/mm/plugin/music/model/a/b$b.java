package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.ac.a;
import java.util.Comparator;

public class b$b implements Comparator<a> {
    final /* synthetic */ b oKy;

    public b$b(b bVar) {
        this.oKy = bVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        if (aVar.hkx > aVar2.hkx) {
            return 1;
        }
        return aVar.hkx < aVar2.hkx ? -1 : 0;
    }
}
