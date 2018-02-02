package com.d.a.a;

import com.d.a.a.r.f;
import java.lang.ref.WeakReference;

class b$a implements Runnable {
    private final WeakReference<b> bgE;
    private final p bgF;

    private b$a(b bVar, p pVar) {
        if (bVar == null || pVar == null) {
            throw new Exception("CoreAssembly: HandleMsgTask: null arg");
        }
        this.bgE = new WeakReference(bVar);
        this.bgF = pVar;
    }

    public final void run() {
        b bVar = (b) this.bgE.get();
        if (bVar != null) {
            switch (this.bgF.what) {
                case 202:
                    f fVar = (f) this.bgF;
                    if (fVar.bjW == 1) {
                        bVar.a(fVar.bjX, fVar.bjx, fVar.bjy);
                        return;
                    } else {
                        bVar.a(fVar.bjW, fVar.message, fVar.bjx, fVar.bjy);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
