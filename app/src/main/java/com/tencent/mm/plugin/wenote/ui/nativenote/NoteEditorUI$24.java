package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$24 implements Runnable {
    final /* synthetic */ int kI;
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$24(NoteEditorUI noteEditorUI, int i) {
        this.tXd = noteEditorUI;
        this.kI = i;
    }

    public final void run() {
        NoteEditorUI.K(this.tXd).be(this.kI);
    }
}
