package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.a;

class a$a$5 implements Runnable {
    final /* synthetic */ a arD;
    final /* synthetic */ long arI;
    final /* synthetic */ int arw;
    final /* synthetic */ Format arx;
    final /* synthetic */ int ary;
    final /* synthetic */ Object arz;

    public a$a$5(a aVar, int i, Format format, int i2, Object obj, long j) {
        this.arD = aVar;
        this.arw = i;
        this.arx = format;
        this.ary = i2;
        this.arz = obj;
        this.arI = j;
    }

    public final void run() {
        a.a(this.arD, this.arI);
    }
}
