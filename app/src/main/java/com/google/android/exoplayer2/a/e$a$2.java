package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;

class e$a$2 implements Runnable {
    final /* synthetic */ a afD;
    final /* synthetic */ String afE;
    final /* synthetic */ long afF;
    final /* synthetic */ long afG;

    e$a$2(a aVar, String str, long j, long j2) {
        this.afD = aVar;
        this.afE = str;
        this.afF = j;
        this.afG = j2;
    }

    public final void run() {
        this.afD.afB.a(this.afE, this.afF, this.afG);
    }
}
