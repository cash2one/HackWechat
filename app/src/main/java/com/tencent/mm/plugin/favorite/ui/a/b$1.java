package com.tencent.mm.plugin.favorite.ui.a;

import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$1 extends c<js> {
    final /* synthetic */ b muA;

    b$1(b bVar) {
        this.muA = bVar;
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
                    this.muA.notifyDataSetChanged();
                    break;
            }
        }
        return false;
    }
}
