package com.tencent.mm.app.plugin;

import com.tencent.mm.pluginsdk.ui.applet.k;
import java.util.Comparator;

class c$1 implements Comparator<k> {
    final /* synthetic */ c fgY;

    c$1(c cVar) {
        this.fgY = cVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        k kVar = (k) obj2;
        int i = ((k) obj).start;
        int i2 = kVar.start;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
