package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qi;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class av$2 extends c<qi> {
    final /* synthetic */ av rHD;

    av$2(av avVar) {
        this.rHD = avVar;
        this.xen = qi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qi qiVar = (qi) bVar;
        if (qiVar instanceof qi) {
            String str = qiVar.fHU.id;
            if (qiVar.fHU.type == 1) {
                av.c(this.rHD, str);
            } else if (qiVar.fHU.type == 2) {
                av.d(this.rHD, qiVar.fHU.id);
            }
        }
        return false;
    }
}
