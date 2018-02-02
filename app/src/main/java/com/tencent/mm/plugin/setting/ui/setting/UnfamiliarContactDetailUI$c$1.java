package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c;

class UnfamiliarContactDetailUI$c$1 implements OnClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI qmn;
    final /* synthetic */ c qmo;

    UnfamiliarContactDetailUI$c$1(c cVar, UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qmo = cVar;
        this.qmn = unfamiliarContactDetailUI;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        this.qmo.mSc.setChecked(!this.qmo.mSc.isChecked());
        if (this.qmo.mSc.isChecked()) {
            UnfamiliarContactDetailUI.b(this.qmo.qma).add(Integer.valueOf(intValue));
        } else {
            UnfamiliarContactDetailUI.b(this.qmo.qma).remove(Integer.valueOf(intValue));
        }
        if (UnfamiliarContactDetailUI.b(this.qmo.qma).size() == 0) {
            UnfamiliarContactDetailUI.d(this.qmo.qma).setEnabled(false);
            UnfamiliarContactDetailUI.c(this.qmo.qma).setEnabled(false);
            return;
        }
        UnfamiliarContactDetailUI.d(this.qmo.qma).setEnabled(true);
        UnfamiliarContactDetailUI.c(this.qmo.qma).setEnabled(true);
    }
}
