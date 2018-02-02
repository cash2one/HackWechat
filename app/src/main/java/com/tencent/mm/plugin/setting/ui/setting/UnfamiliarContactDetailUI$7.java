package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class UnfamiliarContactDetailUI$7 implements OnClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI qma;

    UnfamiliarContactDetailUI$7(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qma = unfamiliarContactDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.qma.mController.xIM, true, this.qma.mController.xIM.getString(R.l.eRM), this.qma.mController.xIM.getString(R.l.bXr), this.qma.mController.xIM.getString(R.l.dEw), this.qma.mController.xIM.getString(R.l.dEn), new 1(this), null, R.e.brm, 0);
    }
}
