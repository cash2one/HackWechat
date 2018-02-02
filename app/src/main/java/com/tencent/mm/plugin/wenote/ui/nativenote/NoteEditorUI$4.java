package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$4 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$4(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void run() {
        if (NoteEditorUI.U(this.tXd) != null) {
            NoteEditorUI.U(this.tXd).N(NoteEditorUI.V(this.tXd), NoteEditorUI.W(this.tXd));
            NoteEditorUI.a(this.tXd, NoteEditorUI.V(this.tXd));
            NoteEditorUI.b(this.tXd, NoteEditorUI.W(this.tXd));
        }
    }
}
