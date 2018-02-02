package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.plugin.emoji.e.c.1;
import com.tencent.mm.plugin.emoji.e.c.2;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ar;

class b$5 extends c<cn> {
    final /* synthetic */ b lvv;

    b$5(b bVar) {
        this.lvv = bVar;
        this.xen = cn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cn cnVar = (cn) bVar;
        c aAO = c.aAO();
        if (cnVar != null && (cnVar instanceof cn)) {
            cnVar = cnVar;
            switch (cnVar.fqL.scene) {
                case 0:
                    ar.Dm().F(new 1(aAO, cnVar.fqL.fqM));
                    break;
                case 1:
                    Context context = cnVar.fqL.context;
                    ar.Dm().F(new 2(aAO, cnVar.fqL.fqM, context));
                    break;
            }
        }
        return false;
    }
}
