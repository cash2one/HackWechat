package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class e$16 implements OnClickListener {
    final /* synthetic */ e srL;

    e$16(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if (this.srL.spN != null && this.srL.spN.get() != null && ((c) this.srL.spN.get()).bGP()) {
            e.a(this.srL).setEnabled(false);
            e.f(this.srL).setEnabled(false);
            e.g(this.srL).setVisibility(0);
            e.g(this.srL).setText(R.l.eUu);
        }
    }
}
