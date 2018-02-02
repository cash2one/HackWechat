package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$25 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$25(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void run() {
        if (NoteEditorUI.Z(this.tXd) != null) {
            NoteEditorUI.Z(this.tXd).dismiss();
            NoteEditorUI.aa(this.tXd);
        }
    }
}
