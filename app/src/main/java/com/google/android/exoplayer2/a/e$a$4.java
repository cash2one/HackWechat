package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;

class e$a$4 implements Runnable {
    final /* synthetic */ a afD;
    final /* synthetic */ int afI;
    final /* synthetic */ long afJ;
    final /* synthetic */ long afK;

    e$a$4(a aVar, int i, long j, long j2) {
        this.afD = aVar;
        this.afI = i;
        this.afJ = j;
        this.afK = j2;
    }

    public final void run() {
        this.afD.afB.c(this.afI, this.afJ, this.afK);
    }
}
