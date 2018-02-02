package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.scanner.util.d;

class p$8 implements Runnable {
    final /* synthetic */ byte[] ibn;
    final /* synthetic */ p pYq;
    final /* synthetic */ Point pYu;
    final /* synthetic */ int pYv;
    final /* synthetic */ Rect pYw;

    p$8(p pVar, byte[] bArr, Point point, int i, Rect rect) {
        this.pYq = pVar;
        this.ibn = bArr;
        this.pYu = point;
        this.pYv = i;
        this.pYw = rect;
    }

    public final void run() {
        Object a = ((d) this.pYq.boM()).a(this.ibn, this.pYu, this.pYv, this.pYw, this.pYq.pYl);
        if (a != null) {
            if (this.pYq.pYk == null || this.pYq.pYm < a.length) {
                this.pYq.pYk = new byte[a.length];
                this.pYq.pYm = a.length;
            }
            System.arraycopy(a, 0, this.pYq.pYk, 0, a.length);
            synchronized (this.pYq.hpF) {
                p pVar = this.pYq;
                pVar.bufferSize++;
                p.b(this.pYq);
            }
        }
    }
}
