package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class ShakeSayHiListUI$1 implements OnClickListener {
    final /* synthetic */ View oPn;
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$1(ShakeSayHiListUI shakeSayHiListUI, View view) {
        this.qsr = shakeSayHiListUI;
        this.oPn = view;
    }

    public final void onClick(View view) {
        ShakeSayHiListUI.a(this.qsr, ShakeSayHiListUI.a(this.qsr) + 8);
        x.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.a(this.qsr));
        ShakeSayHiListUI.b(this.qsr).wf(ShakeSayHiListUI.a(this.qsr));
        if (ShakeSayHiListUI.c(this.qsr) <= ShakeSayHiListUI.a(this.qsr)) {
            ShakeSayHiListUI.d(this.qsr).removeFooterView(this.oPn);
            x.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.a(this.qsr));
        }
    }
}
