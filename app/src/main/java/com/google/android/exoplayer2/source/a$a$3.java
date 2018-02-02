package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.source.a.a;

class a$a$3 implements Runnable {
    final /* synthetic */ long arA;
    final /* synthetic */ long arB;
    final /* synthetic */ long arC;
    final /* synthetic */ a arD;
    final /* synthetic */ long arE;
    final /* synthetic */ long arF;
    final /* synthetic */ i aru;
    final /* synthetic */ int arv;
    final /* synthetic */ int arw;
    final /* synthetic */ Format arx;
    final /* synthetic */ int ary;
    final /* synthetic */ Object arz;

    a$a$3(a aVar, i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        this.arD = aVar;
        this.aru = iVar;
        this.arv = i;
        this.arw = i2;
        this.arx = format;
        this.ary = i3;
        this.arz = obj;
        this.arA = j;
        this.arB = j2;
        this.arC = j3;
        this.arE = j4;
        this.arF = j5;
    }

    public final void run() {
        a.a(this.arD, this.arA);
        a.a(this.arD, this.arB);
    }
}
