package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.e.a;

class e$a$3 implements Runnable {
    final /* synthetic */ a aEb;
    final /* synthetic */ Format afH;

    e$a$3(a aVar, Format format) {
        this.aEb = aVar;
        this.afH = format;
    }

    public final void run() {
        this.aEb.aEa.c(this.afH);
    }
}
