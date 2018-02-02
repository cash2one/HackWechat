package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class av$3 extends c<qk> {
    final /* synthetic */ av rHD;

    av$3(av avVar) {
        this.rHD = avVar;
        this.xen = qk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qk qkVar = (qk) bVar;
        if (qkVar instanceof qk) {
            String str = qkVar.fHX.id;
            if (qkVar.fHX.type == 1) {
                av.e(this.rHD, str);
            } else if (qkVar.fHX.type == 2) {
                av.f(this.rHD, str);
            }
        }
        return false;
    }
}
