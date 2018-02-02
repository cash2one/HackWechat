package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$20 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;
    final /* synthetic */ boolean tXj;

    NoteEditorUI$20(NoteEditorUI noteEditorUI, boolean z) {
        this.tXd = noteEditorUI;
        this.tXj = z;
    }

    public final void run() {
        if (this.tXj && !NoteEditorUI.L(this.tXd)) {
            this.tXd.showVKB();
        } else if (!this.tXj && NoteEditorUI.L(this.tXd)) {
            this.tXd.aWs();
        }
    }
}
