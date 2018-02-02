package com.tencent.mm.plugin.fps_lighter.d;

import com.tencent.mm.plugin.fps_lighter.c.c;
import java.util.Comparator;

class a$2 implements Comparator<c> {
    final /* synthetic */ a mBI;

    a$2(a aVar) {
        this.mBI = aVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        c cVar = (c) obj;
        c cVar2 = (c) obj2;
        return cVar.axZ - cVar2.axZ == 0 ? (int) (cVar2.mBB - cVar.mBB) : cVar.axZ - cVar2.axZ;
    }
}
