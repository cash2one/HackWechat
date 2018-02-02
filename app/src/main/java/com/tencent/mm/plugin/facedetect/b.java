package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

public final class b implements a<Void, Void> {
    private static j meG = new j();
    private static m meH = new m();
    private static i meI = new i();
    private com.tencent.mm.vending.g.b igh = null;

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.TaskInitFace", "hy: TaskInitFace init");
        this.igh = g.czQ();
        safeAddListener(meG);
        safeAddListener(meH);
        safeAddListener(meI);
        e.post(new 1(this), "FaceDetectCopyModelFile");
        return null;
    }

    private static void safeAddListener(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.b.a.xef.d(cVar)) {
            x.w("MicroMsg.TaskInitFace", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.b.a.xef.b(cVar);
        }
    }
}
