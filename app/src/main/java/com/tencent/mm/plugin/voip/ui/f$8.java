package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class f$8 implements OnClickListener {
    final /* synthetic */ f ssq;

    f$8(f fVar) {
        this.ssq = fVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
        if (this.ssq.spN != null && this.ssq.spN.get() != null && ((c) this.ssq.spN.get()).bGJ()) {
            this.ssq.co(this.ssq.getString(R.l.eVi), -1);
        }
    }
}
