package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.clean.c.d;

class CleanChattingUI$6 implements OnClickListener {
    final /* synthetic */ CleanChattingUI lhQ;

    CleanChattingUI$6(CleanChattingUI cleanChattingUI) {
        this.lhQ = cleanChattingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (d.ayk() != null && d.ayk().size() == 0) {
            this.lhQ.finish();
        }
    }
}
