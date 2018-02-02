package com.tencent.mm.pluginsdk.ui;

class AbstractVideoView$3 implements Runnable {
    final /* synthetic */ AbstractVideoView vjf;
    final /* synthetic */ int vjg;

    AbstractVideoView$3(AbstractVideoView abstractVideoView, int i) {
        this.vjf = abstractVideoView;
        this.vjg = i;
    }

    public final void run() {
        this.vjf.viW = true;
        this.vjf.mK(this.vjg);
        this.vjf.s(this.vjg, true);
        this.vjf.viW = false;
    }
}
