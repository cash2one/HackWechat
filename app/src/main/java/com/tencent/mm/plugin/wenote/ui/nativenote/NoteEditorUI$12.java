package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class NoteEditorUI$12 implements OnCancelListener {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$12(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (NoteEditorUI.c(this.tXd) != null) {
            NoteEditorUI.c(this.tXd).dismiss();
            NoteEditorUI.a(this.tXd, null);
        }
    }
}
