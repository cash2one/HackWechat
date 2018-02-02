package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements OnClickListener {
    final /* synthetic */ f ssq;

    f$5(f fVar) {
        this.ssq = fVar;
    }

    public final void onClick(View view) {
        boolean isChecked = f.b(this.ssq).isChecked();
        x.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[]{Boolean.valueOf(isChecked)});
        f.b(this.ssq).setEnabled(false);
        if (!(this.ssq.spN == null || this.ssq.spN.get() == null)) {
            ((c) this.ssq.spN.get()).gM(isChecked);
        }
        f.a(this.ssq, isChecked);
        f.b(this.ssq).setEnabled(true);
    }
}
