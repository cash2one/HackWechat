package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ac$1 extends c<js> {
    final /* synthetic */ ac ruu;

    ac$1(ac acVar) {
        this.ruu = acVar;
        this.xen = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((js) bVar).fAz.action) {
            case 0:
            case 1:
                this.ruu.rus.setImageResource(e.bDR);
                break;
            case 2:
            case 3:
            case 4:
                this.ruu.rus.setImageResource(e.bDS);
                break;
        }
        return false;
    }
}
