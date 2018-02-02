package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements OnClickListener {
    final /* synthetic */ f ssq;

    f$4(f fVar) {
        this.ssq = fVar;
    }

    public final void onClick(View view) {
        boolean isChecked = f.a(this.ssq).isChecked();
        x.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[]{Boolean.valueOf(isChecked)});
        f.a(this.ssq).setEnabled(false);
        if (!(this.ssq.spN == null || this.ssq.spN.get() == null)) {
            ((c) this.ssq.spN.get()).jg(isChecked);
        }
        f.a(this.ssq, isChecked ? 1 : 2);
        f.a(this.ssq).setEnabled(true);
    }
}
