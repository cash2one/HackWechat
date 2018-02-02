package com.tencent.mm.ui;

import com.tencent.mm.g.a.ru;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class x$3 extends c<ru> {
    final /* synthetic */ x xKV;

    x$3(x xVar) {
        this.xKV = xVar;
        this.xen = ru.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.v("MicroMsg.LauncherUI.MainTabUnreadMgr", "appTagUnreadChangeListener, event:%s", new Object[]{((ru) bVar).toString()});
        this.xKV.cnm();
        return false;
    }
}
