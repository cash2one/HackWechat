package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.video.e.a;

class e$a$1 implements Runnable {
    final /* synthetic */ a aEb;
    final /* synthetic */ d afC;

    e$a$1(a aVar, d dVar) {
        this.aEb = aVar;
        this.afC = dVar;
    }

    public final void run() {
        this.aEb.aEa.a(this.afC);
    }
}
