package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.pluginsdk.i.a.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$1 implements Runnable {
    final /* synthetic */ b meJ;

    b$1(b bVar) {
        this.meJ = bVar;
    }

    public final void run() {
        String aGQ = n.aGQ();
        String aGR = n.aGR();
        x.i("MicroMsg.TaskInitFace", "alvinluo detectmodel: %s, exist: %b, alignModel: %s, exist: %b", new Object[]{aGQ, Boolean.valueOf(a.bO(aGQ)), aGR, Boolean.valueOf(a.bO(aGR))});
        if (!a.bO(aGQ)) {
            x.i("MicroMsg.TaskInitFace", "alvinluo copy detect model file");
            n.n(ac.getContext(), "face_detect" + File.separator + "ufdmtcc.bin", aGQ);
        }
        if (!r3) {
            x.i("MicroMsg.TaskInitFace", "alvinluo copy alignment model file");
            n.n(ac.getContext(), "face_detect" + File.separator + "ufat.bin", aGR);
        }
    }
}
