package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class NoteEditorUI$8 implements OnCancelListener {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$8(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (NoteEditorUI.Z(this.tXd) != null) {
            NoteEditorUI.Z(this.tXd).dismiss();
            NoteEditorUI.aa(this.tXd);
        }
    }
}
