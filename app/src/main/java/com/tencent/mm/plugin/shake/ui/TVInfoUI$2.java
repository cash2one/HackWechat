package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.e.c.a;

class TVInfoUI$2 implements OnClickListener {
    final /* synthetic */ a qsD;
    final /* synthetic */ TVInfoUI qsE;

    TVInfoUI$2(TVInfoUI tVInfoUI, a aVar) {
        this.qsE = tVInfoUI;
        this.qsD = aVar;
    }

    public final void onClick(View view) {
        g.pQN.h(10987, new Object[]{Integer.valueOf(2), this.qsD.field_playstatid, "", ""});
        TVInfoUI.a(this.qsE, this.qsD.field_playurl);
    }
}
