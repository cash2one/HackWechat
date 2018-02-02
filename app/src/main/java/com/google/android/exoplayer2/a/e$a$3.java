package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.e.a;

class e$a$3 implements Runnable {
    final /* synthetic */ a afD;
    final /* synthetic */ Format afH;

    e$a$3(a aVar, Format format) {
        this.afD = aVar;
        this.afH = format;
    }

    public final void run() {
        this.afD.afB.d(this.afH);
    }
}
