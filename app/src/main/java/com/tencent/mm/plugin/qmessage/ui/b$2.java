package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class b$2 implements OnClickListener {
    final /* synthetic */ b pnJ;
    final /* synthetic */ CheckBoxPreference pnK;

    b$2(b bVar, CheckBoxPreference checkBoxPreference) {
        this.pnJ = bVar;
        this.pnK = checkBoxPreference;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pnK.tSw = true;
        this.pnJ.arR();
    }
}
