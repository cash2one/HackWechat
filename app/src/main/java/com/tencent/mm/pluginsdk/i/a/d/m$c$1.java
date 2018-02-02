package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.pluginsdk.i.a.d.f.c;
import java.util.Comparator;

class m$c$1 implements Comparator<Runnable> {
    m$c$1() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        int random;
        Runnable runnable = (Runnable) obj;
        Runnable runnable2 = (Runnable) obj2;
        if ((runnable instanceof c) && (runnable2 instanceof c) && (((c) runnable).vhC instanceof k) && (((c) runnable2).vhC instanceof k)) {
            k kVar = (k) ((c) runnable).vhC;
            k kVar2 = (k) ((c) runnable2).vhC;
            int i = kVar.priority - kVar2.priority;
            random = (kVar.bZn() && kVar2.bZn()) ? i != 0 ? i : ((int) (Math.random() * 50.0d)) - 25 : i;
        } else {
            random = 0;
        }
        return 0 - random;
    }
}
