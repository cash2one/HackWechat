package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements a {
    final /* synthetic */ b vnd;

    b$5(b bVar) {
        this.vnd = bVar;
    }

    public final void a(boolean z, String str, int i) {
        x.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
        this.vnd.fW(-1);
    }
}
