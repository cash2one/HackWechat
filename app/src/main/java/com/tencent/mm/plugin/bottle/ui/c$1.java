package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$1 implements a {
    final /* synthetic */ c kCo;

    c$1(c cVar) {
        this.kCo = cVar;
    }

    public final boolean a(Preference preference, Object obj) {
        String str = (String) obj;
        int i = -1;
        if ("male".equalsIgnoreCase(str)) {
            i = 1;
        } else if ("female".equalsIgnoreCase(str)) {
            i = 2;
        }
        if (i > 0) {
            ar.Hg();
            c.CU().set(12290, Integer.valueOf(i));
        }
        return false;
    }
}
