package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.sdk.platformtools.x;

class NoteEditorUI$2 implements Runnable {
    final /* synthetic */ int kI;
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$2(NoteEditorUI noteEditorUI, int i) {
        this.tXd = noteEditorUI;
        this.kI = i;
    }

    public final void run() {
        x.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", Integer.valueOf(this.kI));
        NoteEditorUI.P(this.tXd).bj(this.kI);
        x.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", Integer.valueOf(this.kI));
    }
}
