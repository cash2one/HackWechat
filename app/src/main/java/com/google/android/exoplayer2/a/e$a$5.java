package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;
import com.google.android.exoplayer2.b.d;

class e$a$5 implements Runnable {
    final /* synthetic */ a afD;
    final /* synthetic */ d afL;

    e$a$5(a aVar, d dVar) {
        this.afD = aVar;
        this.afL = dVar;
    }

    public final void run() {
        this.afL.jc();
        this.afD.afB.d(this.afL);
    }
}
