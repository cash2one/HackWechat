package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class NewTaskUI$4 implements OnCancelListener {
    final /* synthetic */ NewTaskUI zmc;

    NewTaskUI$4(NewTaskUI newTaskUI) {
        this.zmc = newTaskUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (NewTaskUI.zma != null) {
            NewTaskUI.zma = null;
            this.zmc.finish();
        }
    }
}
