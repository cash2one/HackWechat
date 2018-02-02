package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.video.e.a;

class e$a$7 implements Runnable {
    final /* synthetic */ a aEb;
    final /* synthetic */ d afL;

    e$a$7(a aVar, d dVar) {
        this.aEb = aVar;
        this.afL = dVar;
    }

    public final void run() {
        this.afL.jc();
        this.aEb.aEa.b(this.afL);
    }
}
