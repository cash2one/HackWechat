package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.video.e.a;

class e$a$6 implements Runnable {
    final /* synthetic */ a aEb;
    final /* synthetic */ Surface aEi;

    e$a$6(a aVar, Surface surface) {
        this.aEb = aVar;
        this.aEi = surface;
    }

    public final void run() {
        this.aEb.aEa.b(this.aEi);
    }
}
