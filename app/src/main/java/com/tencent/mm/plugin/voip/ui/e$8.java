package com.tencent.mm.plugin.voip.ui;

class e$8 implements Runnable {
    final /* synthetic */ e srL;

    e$8(e eVar) {
        this.srL = eVar;
    }

    public final void run() {
        if (this.srL.getActivity() != null && !this.srL.getActivity().isFinishing()) {
            e.g(this.srL).setVisibility(8);
        }
    }
}
