package com.tencent.mm.plugin.voip.video;

class h$a implements Runnable {
    private int mPo;
    private int streamType;
    final /* synthetic */ h suJ;
    private long suO;
    private boolean suP;

    public h$a(h hVar, int i, long j, boolean z, int i2) {
        this.suJ = hVar;
        this.mPo = i;
        this.suO = j;
        this.suP = z;
        this.streamType = i2;
    }

    public final void run() {
        this.suJ.a(this.mPo, this.suO, this.suP, this.streamType);
    }
}
