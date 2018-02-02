package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;

class ae$15 extends c<qw> {
    final /* synthetic */ ae qWL;

    ae$15(ae aeVar) {
        this.qWL = aeVar;
        this.xen = qw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qw qwVar = (qw) bVar;
        if (qwVar.fIH.fut != 9 && qwVar.fIH.fut == 7) {
            new af(Looper.getMainLooper()).post(new 1(this, qwVar));
        }
        return false;
    }
}
