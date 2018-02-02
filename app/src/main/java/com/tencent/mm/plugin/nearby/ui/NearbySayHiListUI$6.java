package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class NearbySayHiListUI$6 implements OnClickListener {
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$6(NearbySayHiListUI nearbySayHiListUI) {
        this.oPo = nearbySayHiListUI;
    }

    public final void onClick(View view) {
        NearbySayHiListUI.a(this.oPo, new c(2, 0.0f, 0.0f, 0, 0, "", ""));
        ar.CG().a(NearbySayHiListUI.f(this.oPo), 0);
        NearbySayHiListUI nearbySayHiListUI = this.oPo;
        Context context = this.oPo.mController.xIM;
        this.oPo.getString(R.l.dGO);
        NearbySayHiListUI.a(nearbySayHiListUI, h.a(context, this.oPo.getString(R.l.exc), true, new 1(this)));
        g.pQN.k(11429, "0");
    }
}
