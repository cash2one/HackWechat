package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.av;

class g$4 implements OnClickListener {
    final /* synthetic */ int rAB;
    final /* synthetic */ av rPd;
    final /* synthetic */ g rPe;
    final /* synthetic */ a$c rrP;

    g$4(g gVar, av avVar, int i, a$c com_tencent_mm_plugin_sns_ui_a_a_c) {
        this.rPe = gVar;
        this.rPd = avVar;
        this.rAB = i;
        this.rrP = com_tencent_mm_plugin_sns_ui_a_a_c;
    }

    public final void onClick(View view) {
        this.rPd.qZo.rPU.onClick(view);
        if (this.rAB > 0) {
            this.rPd.rHp.rrs.el(this.rrP.rND);
        }
    }
}
