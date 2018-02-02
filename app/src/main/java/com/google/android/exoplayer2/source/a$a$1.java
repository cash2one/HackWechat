package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.source.a.a;

class a$a$1 implements Runnable {
    final /* synthetic */ long arA;
    final /* synthetic */ long arB;
    final /* synthetic */ long arC;
    final /* synthetic */ a arD;
    final /* synthetic */ i aru;
    final /* synthetic */ int arv;
    final /* synthetic */ int arw;
    final /* synthetic */ Format arx;
    final /* synthetic */ int ary;
    final /* synthetic */ Object arz;

    public a$a$1(a aVar, i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
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
    }

    public final void run() {
        a.a(this.arD, this.arA);
        a.a(this.arD, this.arB);
    }
}
