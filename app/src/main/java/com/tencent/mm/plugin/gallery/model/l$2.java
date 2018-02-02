package com.tencent.mm.plugin.gallery.model;

class l$2 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ long iIP;
    final /* synthetic */ l mRy;
    final /* synthetic */ String mRz;

    l$2(l lVar, String str, int i, long j) {
        this.mRy = lVar;
        this.mRz = str;
        this.iGh = i;
        this.iIP = j;
    }

    public final void run() {
        this.mRy.mRw.a(this.mRz, this.iGh, new 1(this), this.iIP);
    }

    public final String toString() {
        return super.toString() + "|queryMediaInAlbums";
    }
}
