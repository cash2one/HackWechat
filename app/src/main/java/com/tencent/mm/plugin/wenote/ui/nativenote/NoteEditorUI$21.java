package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$21 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;
    final /* synthetic */ int tXk;

    NoteEditorUI$21(NoteEditorUI noteEditorUI, int i) {
        this.tXd = noteEditorUI;
        this.tXk = i;
    }

    public final void run() {
        switch (this.tXk) {
            case 0:
                NoteEditorUI.ac(this.tXd).setVisibility(8);
                if (NoteEditorUI.e(this.tXd).tXE) {
                    NoteEditorUI.M(this.tXd).setVisibility(0);
                    return;
                } else {
                    NoteEditorUI.M(this.tXd).setVisibility(8);
                    return;
                }
            case 1:
                NoteEditorUI.M(this.tXd).setVisibility(0);
                NoteEditorUI.ac(this.tXd).setVisibility(8);
                return;
            case 2:
                NoteEditorUI.M(this.tXd).setVisibility(0);
                NoteEditorUI.ac(this.tXd).setVisibility(8);
                return;
            case 3:
                NoteEditorUI.M(this.tXd).setVisibility(0);
                NoteEditorUI.ac(this.tXd).setVisibility(0);
                return;
            default:
                return;
        }
    }
}
