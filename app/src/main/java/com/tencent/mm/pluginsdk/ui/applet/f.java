package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.p;

public final class f implements i {
    public final q a(p pVar, String str, String str2, String str3, String str4, String str5, a aVar) {
        return e.a(pVar, null, str, str2, str3, str4, str5, aVar);
    }

    public final void a(p pVar, String str, String str2, String str3, a aVar) {
        e.a f = new e.a(pVar.xIM).bS(str).Sp(str2).f(Boolean.valueOf(false));
        f.vnr = str3;
        f.a(aVar).pyk.show();
    }
}
