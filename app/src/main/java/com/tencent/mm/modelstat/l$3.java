package com.tencent.mm.modelstat;

class l$3 implements Runnable {
    final /* synthetic */ l hSh;
    final /* synthetic */ int hSk;
    final /* synthetic */ int hSl;
    final /* synthetic */ int hSm;
    final /* synthetic */ String hSn;
    final /* synthetic */ boolean hSo;
    final /* synthetic */ String hnj;

    l$3(l lVar, int i, int i2, String str, int i3, String str2, boolean z) {
        this.hSh = lVar;
        this.hSk = i;
        this.hSl = i2;
        this.hnj = str;
        this.hSm = i3;
        this.hSn = str2;
        this.hSo = z;
    }

    public final void run() {
        l.b(this.hSk, this.hSl, this.hSm, this.hSo);
    }

    public final String toString() {
        return super.toString() + "|report";
    }
}
