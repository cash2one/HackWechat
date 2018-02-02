package com.tencent.mm.plugin.fps_lighter.d;

import com.tencent.mm.plugin.fps_lighter.c.d;
import java.util.Comparator;

class a$3 implements Comparator<d> {
    final /* synthetic */ a mBI;

    a$3(a aVar) {
        this.mBI = aVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return (int) (((d) obj2).mBB - ((d) obj).mBB);
    }
}
