package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.g.a.tk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class j$1 extends c<tk> {
    final /* synthetic */ j lyp;

    j$1(j jVar) {
        this.lyp = jVar;
        this.xen = tk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tk tkVar = (tk) bVar;
        switch (tkVar.fLY.fpr) {
            case 1:
                this.lyp.lyk.addAll(bh.F(tkVar.fLY.fLZ));
                this.lyp.lyl.addAll(this.lyp.lyk);
                this.lyp.aBI();
                break;
        }
        return false;
    }
}
