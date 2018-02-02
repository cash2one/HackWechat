package com.tencent.mm.plugin.record.ui.b;

import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$3 extends c<js> {
    final /* synthetic */ b pGP;

    b$3(b bVar) {
        this.pGP = bVar;
        super(0);
        this.xen = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        if (jsVar instanceof js) {
            switch (jsVar.fAz.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    this.pGP.handler.sendMessageAtFrontOfQueue(this.pGP.handler.obtainMessage(1));
                    break;
            }
        }
        return false;
    }
}
