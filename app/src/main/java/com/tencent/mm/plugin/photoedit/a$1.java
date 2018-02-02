package com.tencent.mm.plugin.photoedit;

import android.content.Intent;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

class a$1 extends c<lq> {
    final /* synthetic */ a pdm;

    a$1(a aVar) {
        this.pdm = aVar;
        this.xen = lq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((lq) bVar).fDe.fpr == 0) {
            ac.getContext().sendBroadcast(new Intent("com.tencent.mm.plugin.photoedit.action.clear"));
        }
        return false;
    }
}
