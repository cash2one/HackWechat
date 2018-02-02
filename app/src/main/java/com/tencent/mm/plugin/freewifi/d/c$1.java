package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.network.q;

class c$1 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ q hmH;
    final /* synthetic */ String hnj;
    final /* synthetic */ int hny;
    final /* synthetic */ byte[] hnz;
    final /* synthetic */ c mER;

    c$1(c cVar, int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.mER = cVar;
        this.hny = i;
        this.fma = i2;
        this.fmb = i3;
        this.hnj = str;
        this.hmH = qVar;
        this.hnz = bArr;
    }

    public final void run() {
        this.mER.b(this.hny, this.fma, this.fmb, this.hnj);
        if (this.mER.gJT != null) {
            this.mER.gJT.a(this.fma, this.fmb, this.hnj, this.mER);
        }
    }
}
