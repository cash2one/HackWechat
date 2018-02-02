package com.tencent.mm.plugin.record.ui.b;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$4 extends c<mr> {
    final /* synthetic */ a pGF;

    a$4(a aVar) {
        this.pGF = aVar;
        this.xen = mr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mr mrVar = (mr) bVar;
        this.pGF.msp.put(mrVar.fED.filePath, mrVar);
        if (this.pGF.jni != null && this.pGF.jni.rKB.isShowing()) {
            this.pGF.mwJ.onLongClick(null);
        }
        return true;
    }
}
