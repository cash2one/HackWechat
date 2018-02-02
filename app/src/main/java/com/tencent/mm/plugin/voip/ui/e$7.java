package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.sdk.platformtools.x;

class e$7 implements Runnable {
    final /* synthetic */ e srL;

    e$7(e eVar) {
        this.srL = eVar;
    }

    public final void run() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        e.p(this.srL);
        if (this.srL.getActivity() != null && !this.srL.getActivity().isFinishing() && e.q(this.srL) <= 0) {
            e.n(this.srL).setVisibility(8);
            e.r(this.srL).setVisibility(8);
            e.s(this.srL).setVisibility(8);
            e.a(this.srL).setVisibility(8);
            e.b(this.srL).setVisibility(8);
            e.d(this.srL, false);
        }
    }
}
