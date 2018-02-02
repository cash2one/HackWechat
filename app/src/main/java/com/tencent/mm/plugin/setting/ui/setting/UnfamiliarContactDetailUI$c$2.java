package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c;
import com.tencent.mm.sdk.platformtools.x;

class UnfamiliarContactDetailUI$c$2 implements OnClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI qmn;
    final /* synthetic */ c qmo;

    UnfamiliarContactDetailUI$c$2(c cVar, UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qmo = cVar;
        this.qmn = unfamiliarContactDetailUI;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        x.i("MicroMsg.UnfamiliarContactUI", "position:%s", Integer.valueOf(intValue), UnfamiliarContactDetailUI.e(this.qmo.qma).vY(intValue).gBL);
        c.a(this.qmo, r1, intValue);
    }
}
