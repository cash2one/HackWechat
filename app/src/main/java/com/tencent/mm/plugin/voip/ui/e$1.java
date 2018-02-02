package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements OnClickListener {
    final /* synthetic */ e srL;

    e$1(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
        if (this.srL.spN != null && this.srL.spN.get() != null && ((c) this.srL.spN.get()).bGJ()) {
            e.a(this.srL).setEnabled(false);
            e.b(this.srL).setEnabled(false);
            this.srL.co(this.srL.getString(R.l.eVi), -1);
        }
    }
}
