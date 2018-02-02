package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class NoteEditorUI$26 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$26(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void run() {
        h.b(this.tXd.mController.xIM, this.tXd.getString(R.l.eXP), null, true);
    }
}
