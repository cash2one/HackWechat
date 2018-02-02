package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.6;
import com.tencent.mm.ui.snackbar.a;

class NoteEditorUI$6$1 implements Runnable {
    final /* synthetic */ 6 tXf;

    NoteEditorUI$6$1(6 6) {
        this.tXf = 6;
    }

    public final void run() {
        this.tXf.msk.dismiss();
        a.h(this.tXf.tXd, this.tXf.tXd.getString(R.l.eic));
    }
}
