package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.facedetect.e.a.4;
import com.tencent.mm.plugin.facedetect.e.a.a;

class a$4$1 implements Runnable {
    final /* synthetic */ 4 mlw;

    a$4$1(4 4) {
        this.mlw = 4;
    }

    public final void run() {
        synchronized (a.a(this.mlw.mlr)) {
            a.e(this.mlw.mlr, a.mlD);
            b.deleteFile(a.h(this.mlw.mlr));
            if (a.r(this.mlw.mlr) != null) {
                a.r(this.mlw.mlr).zN(a.g(this.mlw.mlr).getFilePath());
            }
        }
    }
}
