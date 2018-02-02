package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2;

class NoteEditorUI$23$2$3 implements OnCancelListener {
    final /* synthetic */ 2 tXm;

    NoteEditorUI$23$2$3(2 2) {
        this.tXm = 2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.tXm.tXl.tXd.lTm != null) {
            this.tXm.tXl.tXd.lTm.dismiss();
            this.tXm.tXl.tXd.lTm = null;
        }
    }
}
