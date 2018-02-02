package com.tencent.mm.ui;

import com.tencent.mm.g.a.an;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class w$1 extends c<an> {
    final /* synthetic */ w xKI;

    w$1(w wVar) {
        this.xKI = wVar;
        this.xen = an.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = ((an) bVar).foF.index;
        if (i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.xKI.Yp("tab_main");
                    break;
                case 1:
                    this.xKI.Yp("tab_address");
                    break;
                case 2:
                    this.xKI.Yp("tab_find_friend");
                    break;
                case 3:
                    this.xKI.Yp("tab_settings");
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
