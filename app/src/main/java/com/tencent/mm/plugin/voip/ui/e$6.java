package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$6 implements OnClickListener {
    final /* synthetic */ e srL;

    e$6(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        e.n(this.srL).setEnabled(false);
        e.o(this.srL);
        e.n(this.srL).setEnabled(true);
        if (this.srL.spN != null && this.srL.spN.get() != null) {
            ((c) this.srL.spN.get()).bGR();
        }
    }
}
