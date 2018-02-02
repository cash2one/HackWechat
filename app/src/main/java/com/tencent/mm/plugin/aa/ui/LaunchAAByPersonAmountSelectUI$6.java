package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i$a;

class LaunchAAByPersonAmountSelectUI$6 implements OnClickListener {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI ijj;

    LaunchAAByPersonAmountSelectUI$6(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        this.ijj = launchAAByPersonAmountSelectUI;
    }

    public final void onClick(View view) {
        if (LaunchAAByPersonAmountSelectUI.c(this.ijj) != null && LaunchAAByPersonAmountSelectUI.c(this.ijj).size() > 0) {
            try {
                i$a com_tencent_mm_ui_base_i_a = new i$a(this.ijj);
                com_tencent_mm_ui_base_i_a.EA(i.uGN);
                com_tencent_mm_ui_base_i_a.EC(i.dFU).a(new 1(this));
                com_tencent_mm_ui_base_i_a.ED(i.dEn).b(new 2(this));
                com_tencent_mm_ui_base_i_a.akx().show();
            } catch (Exception e) {
                x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
            }
        }
        g.pQN.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(8)});
    }
}
