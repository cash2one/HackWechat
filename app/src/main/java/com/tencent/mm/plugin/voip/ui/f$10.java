package com.tencent.mm.plugin.voip.ui;

class f$10 implements Runnable {
    final /* synthetic */ f ssq;

    f$10(f fVar) {
        this.ssq = fVar;
    }

    public final void run() {
        if (this.ssq.getActivity() != null && !this.ssq.getActivity().isFinishing()) {
            f.k(this.ssq).setVisibility(8);
        }
    }
}
