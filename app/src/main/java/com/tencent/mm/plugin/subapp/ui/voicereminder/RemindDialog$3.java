package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.subapp.c.d;

class RemindDialog$3 implements OnClickListener {
    final /* synthetic */ RemindDialog rYR;

    RemindDialog$3(RemindDialog remindDialog) {
        this.rYR = remindDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d bEa = d.bEa();
        if (bEa != null) {
            bEa.hL(RemindDialog.c(this.rYR));
        }
        this.rYR.finish();
    }
}
