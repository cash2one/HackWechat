package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1.1;

class NormalUserFooterPreference$a$1$1$1 implements OnClickListener {
    final /* synthetic */ CheckBox pkE;
    final /* synthetic */ 1 pkF;

    NormalUserFooterPreference$a$1$1$1(1 1, CheckBox checkBox) {
        this.pkF = 1;
        this.pkE = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.b(this.pkF.pkD.pkC);
        if (NormalUserFooterPreference.a(this.pkF.pkD.pkC.pkA).getSource() == 18) {
            NormalUserFooterPreference.a(this.pkF.pkD.pkC.pkA, 9);
            if (this.pkE.isChecked()) {
                a.c(this.pkF.pkD.pkC);
            }
        }
    }
}
