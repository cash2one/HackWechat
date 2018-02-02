package com.tencent.mm.plugin.fps_lighter.d;

import com.tencent.mm.plugin.fps_lighter.c.b;
import java.util.Comparator;

class a$1 implements Comparator<b> {
    final /* synthetic */ a mBI;

    a$1(a aVar) {
        this.mBI = aVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((b) obj).mBw - ((b) obj2).mBw;
    }
}
