package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.sdk.platformtools.x;

class f$6 implements OnClickListener {
    final /* synthetic */ f ssq;

    f$6(f fVar) {
        this.ssq = fVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(2)});
        if (this.ssq.spN != null && this.ssq.spN.get() != null && ((c) this.ssq.spN.get()).bGO()) {
            f.c(this.ssq).setEnabled(false);
            f.d(this.ssq).setText(R.l.eWb);
            this.ssq.sqh.a(f.e(this.ssq), d.sqb);
            f.f(this.ssq).setVisibility(0);
            f.g(this.ssq).setVisibility(8);
            f.c(this.ssq).setVisibility(8);
            f.h(this.ssq).setVisibility(8);
            f.i(this.ssq).setVisibility(0);
        }
    }
}
