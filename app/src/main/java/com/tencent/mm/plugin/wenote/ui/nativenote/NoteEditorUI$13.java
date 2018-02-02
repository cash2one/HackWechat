package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.ui.snackbar.a;

class NoteEditorUI$13 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$13(NoteEditorUI noteEditorUI, Dialog dialog) {
        this.tXd = noteEditorUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
        a.h(this.tXd, this.tXd.getString(R.l.eic));
    }
}
