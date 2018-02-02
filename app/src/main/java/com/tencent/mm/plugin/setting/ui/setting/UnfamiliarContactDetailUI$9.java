package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.R;

class UnfamiliarContactDetailUI$9 implements OnClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI qma;

    UnfamiliarContactDetailUI$9(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qma = unfamiliarContactDetailUI;
    }

    public final void onClick(View view) {
        boolean z;
        CheckBox checkBox = (CheckBox) UnfamiliarContactDetailUI.i(this.qma).findViewById(R.h.checkbox);
        if (checkBox.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        checkBox.setChecked(z);
        if (checkBox.isChecked()) {
            for (int i = 0; i < UnfamiliarContactDetailUI.f(this.qma).size(); i++) {
                UnfamiliarContactDetailUI.b(this.qma).add(Integer.valueOf(i));
            }
        } else {
            UnfamiliarContactDetailUI.b(this.qma).clear();
        }
        if (UnfamiliarContactDetailUI.b(this.qma).size() > 0) {
            UnfamiliarContactDetailUI.d(this.qma).setEnabled(true);
            UnfamiliarContactDetailUI.c(this.qma).setEnabled(true);
        } else {
            UnfamiliarContactDetailUI.d(this.qma).setEnabled(false);
            UnfamiliarContactDetailUI.c(this.qma).setEnabled(false);
        }
        UnfamiliarContactDetailUI.j(this.qma).post(new Runnable(this) {
            final /* synthetic */ UnfamiliarContactDetailUI$9 qmf;

            {
                this.qmf = r1;
            }

            public final void run() {
                UnfamiliarContactDetailUI.e(this.qmf.qma).UR.notifyChanged();
            }
        });
    }
}
