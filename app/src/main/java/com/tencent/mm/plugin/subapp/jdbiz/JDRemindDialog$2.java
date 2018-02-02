package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class JDRemindDialog$2 implements OnClickListener {
    final /* synthetic */ JDRemindDialog rVF;

    JDRemindDialog$2(JDRemindDialog jDRemindDialog) {
        this.rVF = jDRemindDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.rVF.finish();
    }
}
